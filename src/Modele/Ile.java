package Modele;


import java.awt.*;

import Modele.Zone;
import Vue.*;
import java.util.Random;


 // Ile

public class Ile extends VueGrille {

    private Zone[][] plateau;
    private int taille;
    private Random rand; 

    public Ile(int taille){
        super(taille);
        this.taille = taille;
        this.plateau = new Zone[taille][taille];
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                Zone z = new Zone(i,j);
                this.plateau[i][j] = z;
                if (Math.abs(i - (taille - 1) / 2.) +
                        Math.abs(j - (taille - 1) / 2.) <= taille / 2.) {
                    z.setEtat(0);
                    this.ajouteElement(z);
                } else {
                    z.setEtat(2);
                    this.ajouteElement(z);
                }
                
            }
        }
        this.rand = new Random();
    }

    public Zone[][] getIleEtat(){
        return plateau;
    }

    public Zone getZone(int i, int j) {
        return this.plateau[i][j];
    }

    public int getGridtaille() {
        return this.taille;
    }

    public void affiche(){
        for(int i = 0; i<6; i++ ){
            for(int j = 0; j<6;j++){

                System.out.print(this.getZone(i, j));
            }
            System.out.println();
        }
    }

    public boolean ileSubmerg(){
        int cpt= 0;
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if(this.getZone(i,j).getEtat() == 2){
                    cpt++;
                }
            }
        }
        return cpt == taille*taille;

    }

    public Zone randomZone(){
        boolean b = true;
        int y=0;
        int x=0;
        while(b){
            y = rand.nextInt(taille);
            if (y == 0 || y == taille-1){
                x = rand.nextInt(2,4);
            }
            else if(y == 1 || y == taille-2){
                x = rand.nextInt(1,5);
            }
            else{x = rand.nextInt(taille);}
            if(this.getZone(x,y).getEtat() != 2){
                b = false;
            }
            if(ileSubmerg()){b=false;}
        }
        return getZone(x,y);
    }

/*     public ArrayList<Integer> getCoordLine(int y) {
        ArrayList<Integer> s = new ArrayList<Integer>();
        for (int index = 0; index < grid.taille(); index++) {
            if (grid.get(y).get(index) != null) {
                s.add(index);
            }
        }
        return s;
    } */
}
