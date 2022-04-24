package Modele;

import java.util.ArrayList;


 // Players
public class Joueur {
     private int nbActions;
     private boolean actionHelico;
     private boolean actionSacSable;

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
         actionHelico =true;
         actionSacSable =true;
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


     public boolean getActionHeli(){
         return actionHelico;
     }
     public boolean getActionSacSable(){
         return actionSacSable;
     }



     public int aCle(int i){
        if(this.cles.size() == 0){return 0;}
        for(int j = 0; j<this.cles.size(); j++){
            if(this.cles.get(j)==i){return 1;}
        }
        return 0;
    }

    public int aToutesClesPour(int t){
        int cpt = 0;
        for(int i = 0; i<this.cles.size(); i++){
            if(this.cles.get(i)%10 == t){
                cpt++;
                if(cpt==4)return 1;
            }
        }
        return 0;
    }

    public int aTresor(int i){
        if(this.tresors.size() == 0){return 0;}
        for(int j = 0; j<this.tresors.size(); j++){
            if(this.tresors.get(j)==i){return 1;}
        }
        return 0;
    }

    public void resetAction() {
        this.nbActions = 3;
    }

    public void setAction(int n) {
        this.nbActions = n;
    }
    
    public void ajouteCle(int i){this.cles.add(i);}

     public int donneCleTresor(int t){
         for(int i = 0; i<this.cles.size(); i++){
             if(this.cles.get(i)%10 == t){
                 int res = this.cles.get(i);
                 this.cles.remove(this.cles.indexOf(this.cles.get(i)));
                 return res;
             }
         }
         return -1;


     }


    public void ajouteTresor(int i){this.tresors.add(i);}

     public void donneHelico(){this.actionHelico = true;}
     public void donneSacSable(){this.actionSacSable = true;}

     public void utiliseHelico(){this.actionHelico = false;}
     public void utiliseSacSable(){this.actionSacSable = false;}

     public void deplace(Zone z) {
         if(z.getEtat() !=2 && getActionHeli()){
             this.position = z;
             this.utiliseHelico();
         }
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
 