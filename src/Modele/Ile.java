package Modele;


import java.awt.*;
import java.util.*;

import Vue.*;
import java.util.Random;


 // Ile

public class Ile {

    private Zone[][] plateau;
    private int taille;
    private Random rand; 

    public Ile(int taille){
        this.taille = taille;
        this.plateau = new Zone[taille][taille];
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                Zone z = new Zone(i,j);
                this.plateau[i][j] = z;
                if (Math.abs(i - (taille - 1) / 2.) +
                        Math.abs(j - (taille - 1) / 2.) <= taille / 2.) {
                    z.setEtat(0);       
                    
                } else {
                    z.setEtat(2);
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

    public int gettaille() {
        return this.taille;
    }

    public Random getRand() {
        return this.rand;
    }


    public void enleveCle(int c) {

        boolean fin = false;

        for (int y = 0; y < taille - 1; y++) {
            if (y == 0 || y == taille - 1) {
                for (int x = 2; x < 4; x++) {
                    if (this.plateau[x][y].getCle() == c) {
                        this.plateau[x][y].enleveCle();
                        fin = true;
                        break;
                    }
                }
            }
            if (y == 1 || y == taille - 2) {
                for (int x = 1; x < 5; x++) {
                    if (this.plateau[x][y].getCle() == c) {
                        this.plateau[x][y].enleveCle();
                        fin = true;
                        break;
                    }
                }
            }
            for (int x = 0; x < taille; x++) {
                if (this.plateau[x][y].getCle() == c) {
                    this.plateau[x][y].enleveCle();
                    fin = true;
                    break;
                }
            }
            if (fin) {
                break;
            }
        }
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

    public boolean ileInondee(){
        int cpt= 0;
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if(this.getZone(i,j).getEtat() != 0){
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

    public Zone randomZoneVide(){
        Zone z = randomZone();
        while(z.aHeli() || z.aCle() || z.aTresor()){
            z = randomZone();
        }
        return z;
    }

/* 
    public ArrayList<Zone> neighbours(Zone p) {
        ArrayList<Zone> neighbours = new ArrayList<Zone>();
        neighbours.add(this.getZone(p.getCoord().x, p.getCoord().y + 1));
        neighbours.add(this.getZone(p.getCoord().x, p.getCoord().y - 1));
        neighbours.add(this.getZone(p.getCoord().x + 1, p.getCoord().y));
        neighbours.add(this.getZone(p.getCoord().x - 1, p.getCoord().y));
        return neighbours;
    } */
}
