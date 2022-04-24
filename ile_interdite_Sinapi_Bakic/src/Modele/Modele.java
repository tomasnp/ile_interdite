package Modele;

import Vue.*;
import java.util.Random;
import java.util.ArrayList;

public class Modele extends Observable{
    private Ile ile;
    private ArrayList<Joueur> joueurs;
    private ArrayList<Integer> cles;
    private ArrayList<Integer> tresors;
    public Joueur tom;
    private int joueurAct;
    private int ActionSpe;

    public Modele(int size) {
        this.ile = new Ile(size);
        joueurs = new ArrayList<Joueur>();
        tresors = new ArrayList<Integer>();
        this.tresors.add(0);
        this.tresors.add(1);
        this.tresors.add(2);
        this.tresors.add(3);

        for(int i = 0; i< tresors.size(); i++){
            this.ile.randomZoneVide().donneTresor(i);
        }

        this.ile.randomZoneVide().poseHeli();

        cles = new ArrayList<Integer>();
        this.cles.add(00);
        this.cles.add(10);
        this.cles.add(20);
        this.cles.add(30);
        this.cles.add(01);
        this.cles.add(11);
        this.cles.add(21);
        this.cles.add(31);
        this.cles.add(02);
        this.cles.add(12);
        this.cles.add(22);
        this.cles.add(32);
        this.cles.add(03);
        this.cles.add(13);
        this.cles.add(23);
        this.cles.add(33);

        for(int i = 0; i< this.cles.size(); i++){
            this.ile.randomZoneVide().donneCle(this.cles.get(i));
        }
        System.out.println(this.cles.size());
        this.tom = new Joueur("1", ile.randomZone());
        Joueur tom2 = new Joueur("2", ile.randomZone());
        Joueur tom3 = new Joueur("3", ile.randomZone());
        Joueur tom4 = new Joueur("4", ile.randomZone());
        joueurs.add(tom);
        joueurs.add(tom2);
        joueurs.add(tom3);
        joueurs.add(tom4);
        this.ActionSpe = -1;
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

    public int getActSpe(){return ActionSpe;}

    public ArrayList<Joueur> getjoueurs(){return this.joueurs;};

    public int getCle(int c){return this.cles.get(c);}

    public int clesSize(){return this.cles.size();}

    //Setters

    public void enleveCle(int c){
        this.cles.remove(cles.indexOf(c));
    }

    public void setActSpe(int j){ActionSpe = j;}

    public void joueurSuiv() {
        this.joueurAct = (this.joueurAct + 1) % this.joueurs.size();
    }

/*     public ArrayList<Zone> zonesAccessibles(Joueur joueur) {
        ArrayList<Zone> access = new ArrayList<Zone>();
        for(Zone z : getIle().neighbours(joueur.getPosition())){
            if(z.getEtat() !=2 ){
                access.add(z);
            }
        }
        return access;
    } */

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

    public void asseche(Zone z){

        if(z.getEtat()==1 && getjoueurAct().getActionSacSable()){
            z.setEtat(0);
            getjoueurAct().utiliseSacSable();
        }

        /** METTRE EVENTUELLEMENT UN MESSAGE D'ERREUR EN ELSE QUAND ON LE POURRA**/
    }

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

        if((z.aTresor()) && j.aToutesClesPour(z.getTresor())==1){
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

    public void chercheCle(){

        Joueur j = getjoueurAct();
        int x = j.getPosition().getCoord().x;
        int y = j.getPosition().getCoord().y;
        Zone z = this.getZone(x,y);

        if(z.aCle()){
            int c = z.getCle();
            j.ajouteCle(c);
            z.enleveCle();
            this.enleveCle(c);
            int nbAct = j.getNbActions() - 1;
            j.setAction(nbAct);
            if(nbAct == 0){
                j.resetAction();
                FinTour();
            }
        }else{
            int i = this.getIle().getRand().nextInt(1,3);
            if(i==1&&z.getCle()<2){
                z.setEtat(z.getEtat()+1);
            }
            int nbAct = j.getNbActions() - 1;
            j.setAction(nbAct);
            if(nbAct == 0){
                j.resetAction();
                FinTour();
            }
        }
    }


    //METTRE DES EXCEPTIONS ABSOLUMENT

    public void echangeCles(int s, int e){

        Joueur j1 = getjoueurAct();
        int x = j1.getPosition().getCoord().x;
        int y = j1.getPosition().getCoord().y;
        Zone z = this.getZone(x,y);

        Joueur j2 = getjoueurAct();
        //Recherche du 2e joueur

        for(int i =0; i<this.joueurs.size(); i++){
            Joueur provisoire = this.joueurs.get(i);
            if(provisoire.getPosition() == j1.getPosition() && provisoire.getNom()!=j1.getNom()){
                j2 = provisoire;
            }
        }

        //throw new RuntimeException("Il n'y a qu'un joueur sur la zone");
        if(!(j1.getNom()==j2.getNom())) {

            if (s == 0) {
                if (e == 1) {
                    int c1 = j1.donneCleTresor(0);
                    if(c1>-1){
                        int c2 = j2.donneCleTresor(1);
                        if(c2>-1){
                            j2.ajouteCle(c1);
                            j1.ajouteCle(c2);
                        }
                    }



                }
                if (e == 2) {

                    int c1 = j1.donneCleTresor(0);
                    if(c1>-1){
                        int c2 = j2.donneCleTresor(2);
                        if(c2>-1){
                            j2.ajouteCle(c1);
                            j1.ajouteCle(c2);
                        }
                    }


                }
                if (e == 3) {

                    int c1 = j1.donneCleTresor(0);
                    if(c1>-1){
                        int c2 = j2.donneCleTresor(3);
                        if(c2>-1){
                            j2.ajouteCle(c1);
                            j1.ajouteCle(c2);
                        }
                    }

                }
            }

            if (s == 1) {
                if (e == 0) {

                    int c1 = j1.donneCleTresor(1);
                    if(c1>-1){
                        int c2 = j2.donneCleTresor(0);
                        if(c2>-1){
                            j2.ajouteCle(c1);
                            j1.ajouteCle(c2);
                        }
                    }

                }
                if (e == 2) {

                    int c1 = j1.donneCleTresor(1);
                    if(c1>-1){
                        int c2 = j2.donneCleTresor(2);
                        if(c2>-1){
                            j2.ajouteCle(c1);
                            j1.ajouteCle(c2);
                        }
                    }
                }
                if (e == 3) {

                    int c1 = j1.donneCleTresor(1);
                    if(c1>-1){
                        int c2 = j2.donneCleTresor(3);
                        if(c2>-1){
                            j2.ajouteCle(c1);
                            j1.ajouteCle(c2);
                        }
                    }
                }
            }

            if (s == 2) {
                if (e == 1) {
                    int c1 = j1.donneCleTresor(2);
                    if(c1>-1){
                        int c2 = j2.donneCleTresor(1);
                        if(c2>-1){
                            j2.ajouteCle(c1);
                            j1.ajouteCle(c2);
                        }
                    }
                }
                if (e == 0) {

                    int c1 = j1.donneCleTresor(2);
                    if(c1>-1){
                        int c2 = j2.donneCleTresor(0);
                        if(c2>-1){
                            j2.ajouteCle(c1);
                            j1.ajouteCle(c2);
                        }
                    }

                }
                if (e == 3) {

                    int c1 = j1.donneCleTresor(2);
                    if(c1>-1){
                        int c2 = j2.donneCleTresor(3);
                        if(c2>-1){
                            j2.ajouteCle(c1);
                            j1.ajouteCle(c2);
                        }
                    }

                }
            }


            if (s == 3) {
                if (e == 1) {

                    int c1 = j1.donneCleTresor(3);
                    if(c1>-1){
                        int c2 = j2.donneCleTresor(1);
                        if(c2>-1){
                            j2.ajouteCle(c1);
                            j1.ajouteCle(c2);
                        }
                    }
                }
                if (e == 2) {

                    int c1 = j1.donneCleTresor(3);
                    if(c1>-1){
                        int c2 = j2.donneCleTresor(2);
                        if(c2>-1){
                            j2.ajouteCle(c1);
                            j1.ajouteCle(c2);
                        }
                    }

                }
                if (e == 0) {

                    int c1 = j1.donneCleTresor(3);
                    if(c1>-1){
                        int c2 = j2.donneCleTresor(0);
                        if(c2>-1){
                            j2.ajouteCle(c1);
                            j1.ajouteCle(c2);
                        }
                    }

                }
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
            System.out.println(this.clesSize());

        }

    }

    public boolean PartiePerdu(){
        int size = this.getIle().gettaille();
        for( int i = 0; i < size; i++){
            for( int j = 0; j < size; j++){
                if(this.getZone(i, j).aHeli() && this.getZone(i, j).getEtat() == 2){
                    return true;
                }
                if(this.getZone(i, j).aTresor()&& this.getZone(i, j).getEtat() == 2){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean PartieGagnee(){
        int size = this.getIle().gettaille();
        int cpt = 0;
        for( int i = 0; i < size; i++){
            for( int j = 0; j < size; j++){
                if(this.getZone(i, j).aHeli()){
                    for(int k = 0; k < this.getjoueurs().size(); k++){
                        if(getjoueurs().get(k).getPosition() == this.getZone(i, j)){
                            cpt++;
                        }
                    }
                }
            }
        }
        return cpt == this.getjoueurs().size();

    }



    public void FinTour(){
        Zone z1 = this.getIle().randomZone();
        //z1.noie();
        Zone z2 = this.getIle().randomZone();
        while(z1 == z2){
            z2 = this.getIle().randomZone();
            if(this.getIle().ileInondee() || this.getIle().ileSubmerg())break;
        }
        //z2.noie();
        Zone z3 = this.getIle().randomZone();
        while(z3 == z2 || z3 == z1){
            z3= this.getIle().randomZone();
            if(this.getIle().ileInondee() || this.getIle().ileSubmerg())break;
        }
        //z3.noie();
        cleHasard();
        notifyObservers();
        this.joueurSuiv();
    }
}