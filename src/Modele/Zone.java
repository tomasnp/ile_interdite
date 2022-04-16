package Modele;

import java.awt.*;

//Zone
public class Zone {
    private Point c;
    private int etat;  // 0 : normale ; 1 : submergé ; 2 :  inondée
    private Cle aCle;
    private Tresor aTresor; 

    public Zone(int x, int y){
        this.c = new Point(x, y);
    }

    public Point getCoord(){return this.c;}
    public int getEtat(){return this.etat;}
    public Cle getCle(){return this.aCle;}
    public Tresor getTresor(){return this.aTresor;}

    public void setEtat(int e){ this.etat = e;}

    public void noie(){
        if(this.etat != 2){
            this.etat++;
        }
    }
    public void asseche(){
        if(this.etat != 0){
            this.etat--;
        }
    }


    public String toString(){

        String s = " ";
        if(this.aCle != null){
            s+= "(c)";
        }
        if(this.aTresor != null){
            s+="(t)";
        }

        return this.etat+s;
    }


}
