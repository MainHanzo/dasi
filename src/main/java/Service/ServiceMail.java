/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import modele.Client;
import modele.Intervention;

/**
 *
 * @author cguittat
 */
public class ServiceMail {
    public String sendMailConfirInscrip (Client c ){
        String Newligne=System.getProperty("line.separator"); 
        String message = "Bonjour " + c.getName()+ ","+Newligne+ "Nous vpus confirmons votre inscritpion au service Proact'IF.Votre numéro de client est : "+ c.getId();
        return message;
    }
    
    public String sendMailRefusIncrip(Client c){
        String Newligne=System.getProperty("line.separator"); 
        String message = "Bonjour " + c.getName()+ ","+Newligne+"Votre inscription au service Proact'IF a malencontreusement échoué... Merci de recommencer ultérieurement.";
        return message;
    }
    
    public String notifPourEmploye (Intervention in){
        String message = in.toString();
        return message;
    }
    
    public String notifPourClient (Intervention in){
        String message = "Votre intervention a bien été effectuée le " + in.getTimeFin();
        return message;
    }
    
}
