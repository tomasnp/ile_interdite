package Modele;

import java.awt.*;

import javax.swing.JPanel;

//Zone
public class Zone extends JPanel{
    //private Modele modele;
    private Point c;
    private int etat;  // 0 : normale ; 1 : submergé ; 2 :  inondée
    private int cle; // -1 pas de Cle
    private int tresor; // -1 pas de Tresor
    private boolean heli; 

    public Zone(int x, int y){
        this.c = new Point(x, y);
        //setPreferredSize(new Dimension(60, 60));
        this.etat = 2;
        this.cle = -1;
        this.tresor = -1;
        this.heli = false;
    }

    public Zone(Modele m,int x, int y, int e){
        this.c = new Point(x, y);
        this.etat = e;
        //setPreferredSize(new Dimension(60, 60));
        
    }

    public Point getCoord(){return this.c;}
    public int getEtat(){return this.etat;}
    public boolean aCle(){return this.cle > -1 ;}
    public boolean aTresor(){return this.tresor > -1 ;}
    public int getCle(){return this.cle;}
    public int getTresor(){return this.tresor;}
    public boolean aHeli(){return this.heli;}



    public void setEtat(int e){
        if(e == 0){setBackground(Color.GREEN);}
        else if(e == 1){setBackground(Color.BLUE);}
        else setBackground(Color.BLACK);
        this.etat = e;
    }
    public void poseHeli(){this.heli = true;}
    public void donneTresor(int t){this.tresor = t;}

    public void enleveCle(){this.cle = -1;}
    public void enleveTresor(){this.tresor = -1;}

    public void noie(){
        int et = this.etat;
        if(et < 2){
            this.setEtat(et+1);
        }
    }
    public void asseche(){
        int et = this.etat;
        if(et > 0){
            System.out.println("DRY");
            this.setEtat(et-1);
        }
    }

    /* public String toString(){

        String s = " ";
        if(this.aCle != null){
            s+= "(c)";
        }
        if(this.aTresor != null){
            s+="(t)";
        }

        return this.etat+s;
    } */


}
