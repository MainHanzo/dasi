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

import javax.persistence.*;
import modele.Client;

public class ClientDAO {
    public ClientDAO(){
        
    }
    public Client creerClient (Client c){
        JpaUtil.obtenirEntityManager().persist(c);
        return c;
    }
    
    public Client verifLogin(String user, int mdp){
        Query query = JpaUtil.obtenirEntityManager().createQuery("select c from Client c where c.mail = :usr and c.id = :m");
        query.setParameter("usr", user);
        query.setParameter("m", mdp);
        Client cl;
        try {
            cl = (Client) query.getSingleResult();
        } catch (Exception e) {
            cl = null;
        }
        return cl;
    }
}
