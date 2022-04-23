package Modele;

import Vue.*;

import java.util.ArrayList;

public class Modele extends Observable{
    private Ile ile;
    private ArrayList<Joueur> joueurs;
    private ArrayList<Integer> cles;
    private ArrayList<Integer> tresors;
    public Joueur tom;
    private int joueurAct;
    private Zone heliport;

    public Modele(int size) {
        this.ile = new Ile(size);
        joueurs = new ArrayList<Joueur>();
        cles = new ArrayList<Integer>();
        this.cles.add(0);
        this.cles.add(1);
        this.cles.add(2);
        this.cles.add(3);
        tresors = new ArrayList<Integer>();
        this.tresors.add(0);
        this.tresors.add(1);
        this.tresors.add(2);
        this.tresors.add(3);

        for(int i = 0; i< tresors.size(); i++){
            this.ile.randomZone().donneTresor(i);
        }


        this.tom = new Joueur("1", ile.randomZone());
        Joueur tom2 = new Joueur("2", ile.randomZone());
        Joueur tom3 = new Joueur("3", ile.randomZone());
        Joueur tom4 = new Joueur("4", ile.randomZone());
        joueurs.add(tom);
        joueurs.add(tom2);
        joueurs.add(tom3);
        joueurs.add(tom4);
    }

    public Ile getIle() {
        return ile;
    }

    public Zone getZone(int x, int y) {
        return getIle().getZone(x, y);
    }

    public Joueur getjoueurAct(){
        return this.joueurs.get(joueurAct);
    }

    public ArrayList<Joueur> getjoueurs(){return this.joueurs;};

    public int getCle(int c){return this.cles.get(c);}

    public int clesSize(){return this.cles.size();}

    //Setters

    public void enleveCle(int c){this.cles.remove(c);}

    public void joueurSuiv() {
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

     //Méthodes de déplacement

     public void deplaceGauche(){

        Joueur j = getjoueurAct();
        int x = j.getPosition().getCoord().x;
        int y = j.getPosition().getCoord().y;

        if((x-1>=0) && (this.getIle().getZone(x-1, y).getEtat()<2)){
            j.setPosition(this.getIle().getZone(x-1, y));
            int nbAct = j.getNbActions() - 1;
            j.setAction(nbAct);

            if(nbAct == 0){
                j.resetAction();
                FinTour();
            }
        }

        /** METTRE EVENTUELLEMENT UN MESSAGE D'ERREUR EN ELSE QUAND ON LE POURRA**/

    }

    public void deplaceDroite(){

        Joueur j = getjoueurAct();
        int x = j.getPosition().getCoord().x;
        int y = j.getPosition().getCoord().y;

        if((x+1<=this.getIle().gettaille()-1) && (this.getIle().getZone(x+1, y).getEtat()<2)){
            j.setPosition(this.getIle().getZone(x+1, y));
            int nbAct = j.getNbActions() - 1;
            j.setAction(nbAct);

            if(nbAct == 0){
                j.resetAction();
                FinTour();
            }
        }

        /** METTRE EVENTUELLEMENT UN MESSAGE D'ERREUR EN ELSE QUAND ON LE POURRA**/

    }

    public void deplaceHaut(){

        Joueur j = getjoueurAct();
        int x = j.getPosition().getCoord().x;
        int y = j.getPosition().getCoord().y;

        if((y-1>=0) && (this.getIle().getZone(x, y-1).getEtat()<2)){
            j.setPosition(this.getIle().getZone(x, y-1));
            int nbAct = j.getNbActions() - 1;
            j.setAction(nbAct);

            if(nbAct == 0){
                j.resetAction();
                FinTour();
            }
        }

        /** METTRE EVENTUELLEMENT UN MESSAGE D'ERREUR EN ELSE QUAND ON LE POURRA**/

    }


    public void deplaceBas(){

        Joueur j = getjoueurAct();
        int x = j.getPosition().getCoord().x;
        int y = j.getPosition().getCoord().y;

        if((y+1<=this.getIle().gettaille()-1) && (this.getIle().getZone(x, y+1).getEtat()<2)){
            j.setPosition(this.getIle().getZone(x, y+1));
            int nbAct = j.getNbActions() - 1;
            j.setAction(nbAct);

            if(nbAct == 0){
                j.resetAction();
                FinTour();
            }
        }

        /** METTRE EVENTUELLEMENT UN MESSAGE D'ERREUR EN ELSE QUAND ON LE POURRA**/

    }

    //Méthodes d'assèchement

    public void assecheSurPlace(){

        Joueur j = getjoueurAct();
        Zone z = j.getPosition();

        if(z.getEtat()==1){
            z.setEtat(0);
            int nbAct = j.getNbActions() - 1;
            j.setAction(nbAct);
            if(nbAct == 0){
                j.resetAction();
                FinTour();
            }
        }

        /** METTRE EVENTUELLEMENT UN MESSAGE D'ERREUR EN ELSE QUAND ON LE POURRA**/
    }

    public void assecheGauche(){

        Joueur j = getjoueurAct();
        int x = j.getPosition().getCoord().x;
        int y = j.getPosition().getCoord().y;

        if((x-1>=0)&&(this.getIle().getZone(x-1, y).getEtat()==1)){
            this.getIle().getZone(x-1,y).setEtat(0);
            int nbAct = j.getNbActions() - 1;
            j.setAction(nbAct);
            if(nbAct == 0){
                j.resetAction();
                FinTour();
            }
        }

        /** METTRE EVENTUELLEMENT UN MESSAGE D'ERREUR EN ELSE QUAND ON LE POURRA**/

    }

    public void assecheDroite(){

        Joueur j = getjoueurAct();
        int x = j.getPosition().getCoord().x;
        int y = j.getPosition().getCoord().y;

        if((x+1<=this.getIle().gettaille()-1)&&(this.getIle().getZone(x+1,y).getEtat()==1)){
            this.getIle().getZone(x+1,y).setEtat(0);
            int nbAct = j.getNbActions() - 1;
            j.setAction(nbAct);
            if(nbAct == 0){
                j.resetAction();
                FinTour();
            }
        }
        /** METTRE EVENTUELLEMENT UN MESSAGE D'ERREUR EN ELSE QUAND ON LE POURRA**/
    }

    public void assecheHaut(){

        Joueur j = getjoueurAct();
        int x = j.getPosition().getCoord().x;
        int y = j.getPosition().getCoord().y;

        if((y-1>=0)&&(this.getIle().getZone(x,y-1).getEtat()==1)){
            this.getIle().getZone(x,y-1).setEtat(0);
            int nbAct = j.getNbActions() - 1;
            j.setAction(nbAct);
            if(nbAct == 0){
                j.resetAction();
                FinTour();
            }
        }
        /** METTRE EVENTUELLEMENT UN MESSAGE D'ERREUR EN ELSE QUAND ON LE POURRA**/
    }

    public void assecheBas(){

        Joueur j = getjoueurAct();
        int x = j.getPosition().getCoord().x;
        int y = j.getPosition().getCoord().y;

        if((y+1<=this.getIle().gettaille()-1)&&(this.getIle().getZone(x,y+1).getEtat()==1)){
            this.getIle().getZone(x,y+1).setEtat(0);
            int nbAct = j.getNbActions() - 1;
            j.setAction(nbAct);
            if(nbAct == 0){
                j.resetAction();
                FinTour();
            }
        }
        /** METTRE EVENTUELLEMENT UN MESSAGE D'ERREUR EN ELSE QUAND ON LE POURRA**/
    }
     //Méthode pour récuperer un artefact

    public void recupTresor(){

        Joueur j = getjoueurAct();
        int x = j.getPosition().getCoord().x;
        int y = j.getPosition().getCoord().y;
        Zone z = this.getZone(x,y);

        if((z.aTresor()) && j.aCle(z.getTresor())){
            j.ajouteTresor(z.getTresor());
            z.enleveTresor();
            int nbAct = j.getNbActions() - 1;
            j.setAction(nbAct);
            if(nbAct == 0){
                j.resetAction();
                FinTour();
            }
        }
    }

    //Méthode pour donner (ou pas) une clé au hasard au joueur en fin de tour

    public void cleHasard(){
        Joueur j = getjoueurAct();
        int i = this.getIle().getRand().nextInt(1,3);
        if(i==1 && this.clesSize()>0){
            int c = this.getCle(this.getIle().getRand().nextInt(0,this.clesSize()));
            j.ajouteCle(c);
            this.enleveCle(c); //A BIEN VERIFIER
            this.getIle().enleveCle(c);
        }

    }




    public void FinTour(){
        this.getIle().randomZone().noie();
        this.getIle().randomZone().noie();
        this.getIle().randomZone().noie();
        this.joueurSuiv();
        notifyObservers();
    }
}