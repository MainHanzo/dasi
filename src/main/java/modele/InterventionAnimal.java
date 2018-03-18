/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
/**
 *
 * @author DellUser
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class InterventionAnimal extends Intervention {
    private String typeAnimal;
    
    public InterventionAnimal(){
        
    }
    
    public InterventionAnimal(String desc, Date debu,Client c, String type){
        super(desc, debu, c);
        this.typeAnimal = type;
    }
    
    @Override
    public String toString(){
        String str = "L'intervention animal qui est de type " + this.typeAnimal +" "+super.toString();
        return str;
    }
}



