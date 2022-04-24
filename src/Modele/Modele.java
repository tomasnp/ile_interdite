package Modele;

import java.util.ArrayList;

public class Modele{
    private Ile ile;
    private ArrayList<Joueur> joueurs;
    private int joueurAct;
    private Zone heliport;

    public Modele(int size) {
        ile = new Ile(size);
    }

    public Ile getIle() {
        return ile;
    }

    public Joueur getjoueurAct(){
        return this.joueurs.get(joueurAct);
    }

    public void nextPlayer() {
        this.joueurAct = (this.joueurAct + 1) % this.joueurs.size();
    }

    public ArrayList<Zone> zonesAccessibles(Joueur joueur) {
        ArrayList<Zone> access = new ArrayList<Zone>();
        for(Zone z : getIle().neighbours(joueur.getPosition())){
            if(z.getEtat() !=2 ){
                access.add(z);
            }
        }
        return access;
    }
   
    public void Gauche(){
        ArrayList<Zone> zones = this.zonesAccessibles(getjoueurAct());
        if(zones.size() == 4){
            this.getjoueurAct().deplace(zones.get(0));
        }
    }

    

    public void FinTour(){
        this.getIle().randomZone().noie();
        this.getIle().randomZone().noie();
        this.getIle().randomZone().noie();
    }
}