/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPack;

/**
 *
 * @author cguittat
 */

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import modele.Client;
import modele.Employe;
import modele.Intervention;
import modele.InterventionAnimal;
import modele.InterventionIncident;
import modele.InterventionLivraison;
import DAO.JpaUtil;
import Service.ServiceApp;
import java.util.List;




public class main {
    public static void main(String []args) {
        JpaUtil.init();
        ServiceApp serv = new ServiceApp();
        //serv.creationEmployes(declareEmployes());
        
        SimpleDateFormat saf = new SimpleDateFormat("dd/mm/yyyy");
        Date d = null;
        try {
            d = saf.parse("03/05/2018");
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);// ou date du jour
        }
        
        SimpleDateFormat dateInterv = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date debut = null;
        try {
            debut = dateInterv.parse("2018/01/12 11:00:00");
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);// ou date du jour
        }
        
        //Client c = new Client ('F', "béa", "guittat", d,"INSA-LYON", "06", "Guit@gmail");
        //System.out.println(serv.creationClient(c));
        Client c = serv.clientLogin("Guit@gmail", 1966);
        Intervention ia = new InterventionAnimal("tout se passe bien", debut, c, "panda");
        System.out.println(serv.creationIntervention(ia));
        /*List<Intervention>k = serv.recupToutesIntervClient(c);
        for (int i=0; i< k.size();i++){
            System.out.println(k.get(i));
        }*/
        //System.out.println(serv.clientLogin("Guittat@gmail", 1001));
        /*Employe e = serv.employeLogin("Varane@proactif.fr", 1957);
        List<Intervention>k = serv.recupToutesIntervEmploye(e);
        for (int i=0; i< k.size();i++){
            System.out.println(k.get(i));
        }*/
        //System.out.println(serv.fermerInterv(e, "tout s'est bien passé"));
        JpaUtil.destroy();
    }
    
    
    public static Employe[] declareEmployes (){
        Employe [] tabEmp = new Employe[15];
        
        int[][] hor1 = {{10,12},{20,22}};
        int[][] hor2 = {{8,12}};
        int[][] hor3 = {{8,10},{14,16}};
        int[][] hor4 = {{9,10},{11,12},{13,14}};
        int[][] hor5 = {{10,12},{20,22}};
        int[][] hor6 = {{14,20},{21,22}};
        int[][] hor7 = {{10,15},{20,22}};
        int[][] hor8 = {{8,17}};
        int[][] hor9 = {{9,12},{15,17}};
        int[][] hor10 = {{11,12},{15,16},{17,18}};
        int[][] hor11 = {{10,18}};
        int[][] hor12 = {{16,19},{21,22}};
        int[][] hor13 = {{8,12},{16,22}};
        int[][] hor14 = {{10,14},{18,22}};
        int[][] hor15 = {{9,12},{17,19},{20,23}};
        
        Employe e1= new Employe ('M',"Mbappe", "Kylian",hor1, "Paris", "Mbappe@proactif.fr");
        tabEmp[0]=e1;
        Employe e2= new Employe ('M',"Griezmann", "Antoine",hor2, "Madrid", "Griezmann@proactif.fr");
        tabEmp[1]=e2;
        Employe e3= new Employe ('M',"Pogba", "Paul",hor3, "Manchester", "Pogba@proactif.fr");
        tabEmp[2]=e3;
        Employe e4= new Employe ('M',"Martial", "Anthony",hor4, "Manchester", "Martial@proactif.fr");
        tabEmp[3]=e4;
        Employe e5= new Employe ('M',"Coman", "Kingsley",hor5, "Munich", "Coman@proactif.fr");
        tabEmp[4]=e5;
        Employe e6= new Employe ('M',"Umtiti", "Samuel",hor6, "Barcelone", "Umtiti@proactif.fr");
        tabEmp[5]=e6;
        Employe e7= new Employe ('M',"Varane", "Raphael",hor7, "Madrid", "Varane@proactif.fr");
        tabEmp[6]=e7;
        Employe e8= new Employe ('M',"Matuidi", "Blaise",hor8, "Turin", "Matuidi@proactif.fr");
        tabEmp[7]=e8;
        Employe e9= new Employe ('M',"Rabiot", "Adrien",hor9, "Paris", "Rabiot@proactif.fr");
        tabEmp[8]=e9;
        Employe e10= new Employe ('M',"Tolisso", "Corentin",hor10, "Munich", "Tolisso@proactif.fr");
        tabEmp[9]=e10;
        Employe e11= new Employe ('M',"Kante", "Ngolo",hor11, "Londres", "Kante@proactif.fr");
        tabEmp[10]=e11;
        Employe e12= new Employe ('M',"Koscielny", "Laurent",hor12, "Londres", "Koscielny@proactif.fr");
        tabEmp[11]=e12;
        Employe e13= new Employe ('M',"Giroud", "Olivier",hor13, "Londres", "Giroud@proactif.fr");
        tabEmp[12]=e13;
        Employe e14= new Employe ('M',"Sidibe", "Djibril",hor14, "Monaco", "Sidibe@proactif.fr");
        tabEmp[13]=e14;
        Employe e15= new Employe ('M',"Lemar", "Thomas",hor15, "Monaco", "Lemar@proactif.fr");
        tabEmp[14]=e15;
        
        return tabEmp;
    }
} 
