/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author cguittat
 */

import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import modele.Client;
import modele.Employe;
import modele.Intervention;

public class InterventionDAO {
    public InterventionDAO(){
        
    }
    public Intervention creerIntervention (Intervention in){
        boolean unDispo = false;
        Query query = JpaUtil.obtenirEntityManager().createQuery("select e from Employe e where e.dispo =1");
        List<Employe> res = (List<Employe>) query.getResultList();
        for (int i =0; i<res.size();i++){
            if (res.get(i).disponi(in.getTimeInterv().getHours())){
                in.setEmploye(res.get(i));
                res.get(i).setDispo(false);
                unDispo = true;
                JpaUtil.obtenirEntityManager().persist(in);
                break;
            }
        }
        if (!unDispo){
            in = null;
        }
        return in;
    }
    
    public List<Intervention> getAllIntervClient (Client c){
        Query query = JpaUtil.obtenirEntityManager().createQuery("Select i from Intervention i where i.demandePar = :cl ORDER BY i.id DESC");
        query.setParameter("cl", c);
        List<Intervention> liste;
        liste = (List<Intervention>) query.getResultList();
        return liste;
    }
    
    public List<Intervention> get5LastIntervClient (Client c){
        Query query = JpaUtil.obtenirEntityManager().createQuery("Select i from Intervention i where i.demandePar = :cl ORDER BY i.id DESC");
        query.setParameter("cl", c);
        List<Intervention> liste;
        liste = (List<Intervention>) query.setMaxResults(5).getResultList();
        return liste;
    }
    
    public Intervention getIntervInProgress (Employe emp){
        Query query = JpaUtil.obtenirEntityManager().createQuery("Select i from Intervention i where i.realisePar = :em and i.estFini =0");
        query.setParameter("em", emp);
        Intervention in;
        try{
            in = (Intervention) query.getSingleResult();
        } catch (Exception e) {
            in = null;
        }
        return in;
    }
    
    public List<Intervention> getAllIntervEmploye (Employe emp){
        Query query = JpaUtil.obtenirEntityManager().createQuery("Select i from Intervention i where i.realisePar = :em ORDER BY i.id DESC");
        query.setParameter("em", emp);
        List<Intervention> liste;
        liste = (List<Intervention>) query.getResultList();
        return liste;
    } 
    
    public List<Intervention> getAllIntervToday (){
        Query query = JpaUtil.obtenirEntityManager().createQuery("Select i from Intervention i where i.fin = :date ORDER BY i.id DESC");
        Date d = new Date();
        query.setParameter("date", d);
        List<Intervention> liste;
        liste = (List<Intervention>) query.getResultList();
        return liste;
    } 
    
    public Intervention closeInterv (Employe emp, String comm){
        Query query = JpaUtil.obtenirEntityManager().createQuery("Select i from Intervention i where i.realisePar = :em and i.estFini =0");
        query.setParameter("em", emp);
        Intervention in;
        try{
            in = (Intervention) query.getSingleResult();
            in.setFini(true);
            in.setDateFin();
            in.setComm(comm);
            emp.setDispo(true);
            JpaUtil.obtenirEntityManager().merge(emp);
        } catch (Exception e) {
            in = null;
        }
        return in;
    }
    
    public Intervention getInterventionById(int InterventionId){
        Intervention cl = JpaUtil.obtenirEntityManager().find(Intervention.class, InterventionId);
        return cl;
    }
}
