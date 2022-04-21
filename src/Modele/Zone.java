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
        this.etat = 2;
    }

    public Zone(int x, int y, int e){
        this.c = new Point(x, y);
        this.etat = e;
        setPreferredSize(new Dimension(60, 60));
        
    }

    public Point getCoord(){return this.c;}
    public int getEtat(){return this.etat;}
    public Cle getCle(){return this.aCle;}
    public Tresor getTresor(){return this.aTresor;}

    public void setEtat(int e){
        if(e == 0){setBackground(Color.GREEN);}
        else if(e == 1){System.out.println("BLUE");setBackground(Color.BLUE);}
        else setBackground(Color.BLACK);
        this.etat = e;
    }

    public void noie(){
        int et = this.etat;
        if(et < 2){
            System.out.println("NOIE");
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
