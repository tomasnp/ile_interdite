package Modele;

import java.awt.*;

import javax.swing.JPanel;

//Zone
public class Zone extends JPanel{
    private Point c;
    private int etat;  // 0 : normale ; 1 : submergé ; 2 :  inondée
    private Cle aCle;
    private Tresor aTresor; 

    public Zone(int x, int y){
        this.c = new Point(x, y);
        setPreferredSize(new Dimension(60, 60));
        if(this.etat == 0)setBackground(Color.BLACK);
        else if(this.etat == 1)setBackground(Color.LIGHT_GRAY);
        else setBackground(Color.BLUE);
    }

    public Zone(int x, int y, int e){
        this.c = new Point(x, y);
        this.etat = e;
        setPreferredSize(new Dimension(60, 60));
        if(this.etat == 0)setBackground(Color.BLACK);
        else if(this.etat == 1)setBackground(Color.LIGHT_GRAY);
        else setBackground(Color.BLUE);
    }

    public Point getCoord(){return this.c;}
    public int getEtat(){return this.etat;}
    public Cle getCle(){return this.aCle;}
    public Tresor getTresor(){return this.aTresor;}

    public void setEtat(int e){
        if(this.etat == 0)setBackground(Color.BLACK);
        else if(this.etat == 1)setBackground(Color.LIGHT_GRAY);
        else setBackground(Color.BLUE);
        this.etat = e;
    }

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
