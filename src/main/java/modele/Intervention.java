package modele;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import java.io.Serializable;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public abstract class Intervention implements Serializable {
    
    @Id
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    protected  String description;
    
    protected boolean estFini;
    
    protected String commentaire;
    
    @Temporal(TemporalType.DATE)
    protected Date debut;
    
    @Temporal(TemporalType.DATE)
    protected Date fin;
    
    @ManyToOne
    @JoinColumn(nullable=false)
    protected Client demandePar;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    protected Employe realisePar;
    
    public Intervention() {
        
    }
    
    public Intervention(String desc,Date debu, Client c) {
        this.description = desc;
        this.debut = debu;
        this.demandePar = c;
    }
    
    public Date getTimeInterv(){
        return this.debut;
    }
    
    public void setEmploye (Employe e){
        this.realisePar = e; 
    }
    
    public void setFini (boolean b){
        this.estFini = b;
    }
    
    public void setDateFin (){
        this.fin = new Date();
    }
    
    public void setComm(String comm){
        this.commentaire = comm;
    }
    
    public String toString(){
        return "L'intervention a pour descritption: " + this.description+ " ,a commencé le "+ this.debut + " juqu'à "+ this.fin + " est demandé par :"+ this.demandePar+". Elles est réalisé par : "+ this.realisePar +", fini ? : "+this.estFini +" dont le commentaire est : "+ this.commentaire;
    }
}
