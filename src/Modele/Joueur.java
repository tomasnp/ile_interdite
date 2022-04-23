package Modele;

import java.util.ArrayList;


 // Players
public class Joueur {
    private int nbActions;

    private Zone position;
    private String nom;
    private ArrayList<Integer> cles;
    private ArrayList<Integer> tresors;



    // Constructeur
    public Joueur(String name, Zone zone) {
        this.nom = name;
        this.cles = new ArrayList<Integer>();
        this.tresors = new ArrayList<Integer>();
        this.nbActions = 3;
        position = zone;
    }

    // Setter
    public void setPosition(Zone z) {
        this.position = z;
    }

    public void setNom(String name) {
        this.nom = name;
    }

    // Getter
    public Zone getPosition() {
        return this.position;
    }

    public String getNom() {
        return this.nom;
    }

    public int getNbActions() {
        return this.nbActions;
    }

    public boolean aCle(int i){
        if(this.cles.size() == 0){return false;}
        for(int j = 0; j<this.cles.size(); j++){
            if(this.cles.get(j)==i){return true;}
        }
        return false;
    }

    public void resetAction() {
        this.nbActions = 3;
    }

    public void setAction(int n) {
        this.nbActions = n;
    }
    
    public void ajouteCle(int i){this.cles.add(i);}

    public void ajouteTresor(int i){this.tresors.add(i);}

    public void deplace(Zone z) {
        this.position = z;
        this.nbActions--;
    }

    public String getComment() {
        String comment = nom + " :\n\n";

        comment += " - move a space\n\n";
        comment += " - dig a space\n\n";
        comment += " - win treasure\n\n";
        comment += "\n\n   "+ this.getNbActions() + " remaining action\n";

        return comment;
    }

    
}
 