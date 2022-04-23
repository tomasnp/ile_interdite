package Vue;
import java.awt.*;

import javax.swing.*;

import Modele.*;

public class VueGrille extends JPanel implements Observer{
    private Modele modele;
    
    final public int TAILLE = 100;
    
    public VueGrille(Modele il){
        this.modele = il;
        il.addObserver(this);

        Dimension dim = new Dimension(TAILLE*modele.getIle().gettaille(), 
        TAILLE*modele.getIle().gettaille());
	    this.setPreferredSize(dim);
    }

    public void update() { repaint(); }

    public void paintComponent(Graphics g) {
        super.repaint();
        for(int i=0; i<modele.getIle().gettaille(); i++) {
            for(int j=0; j<modele.getIle().gettaille(); j++) {
                Zone z = modele.getIle().getZone(i, j);
                paint(g, z, (i)*TAILLE, (j)*TAILLE);
                /* if(modele.tom.getPosition() == modele.getZone(i, j)){
                    placeTom(g, modele.tom, i, j);
                } */
                for(int k = 0; k < this.modele.getjoueurs().size(); k++){
                    if(this.modele.getjoueurs().get(k).getPosition() == z){
                        placeJoueurs(g, modele.getjoueurs().get(k), i, j);
                    }
                }
                placeTresor(g,z,i,j);


            }
        }
    }

    private void paint(Graphics g, Zone z, int x, int y) {
        if (z.getEtat()==2) {
            g.setColor(Color.BLACK);
        } else if (z.getEtat()==1) {
            g.setColor(Color.BLUE);
        } else if(z.getEtat()==0){
            g.setColor(Color.GREEN);
        } else {
            g.setColor(Color.orange);
        }
        g.fillRect(x, y, TAILLE, TAILLE);
        this.update();
    }

    private void placeTom(Graphics g, Joueur j, int x, int y){
        if(j == this.modele.tom){
            g.setColor(Color.RED);
            g.drawOval(x*TAILLE, y*TAILLE, 40,40);
            g.fillOval(x*TAILLE, y*TAILLE, 40,40);
            g.setColor(Color.BLACK);
            g.drawString(j.getNom(),x*TAILLE+3, y*TAILLE+20);
        }
    }

     private void placeTresor(Graphics g, Zone z, int x, int y){
        if(z.getTresor()==0){
            g.setColor(Color.ORANGE);
            g.drawRect(x*TAILLE + TAILLE/2, y*TAILLE + TAILLE/2, 60, 20);
            g.fillRect(x*TAILLE + TAILLE/2, y*TAILLE + TAILLE/2, 60, 20);
            g.setColor(Color.BLACK);
            g.drawString("FEU",x*TAILLE + TAILLE/2+5, y*TAILLE + TAILLE/2+15);
        }
        if(z.getTresor()==1){
            g.setColor(new Color(0,130,0));
            g.drawRect(x*TAILLE + TAILLE/2, y*TAILLE + TAILLE/2, 60, 20);
            g.fillRect(x*TAILLE + TAILLE/2, y*TAILLE + TAILLE/2, 60, 20);
            g.setColor(Color.BLACK);
            g.drawString("TERRE",x*TAILLE + TAILLE/2+5, y*TAILLE + TAILLE/2+15);
        }

        if(z.getTresor()==2){
            g.setColor(new Color(0,0,130));
            g.drawRect(x*TAILLE + TAILLE/2, y*TAILLE + TAILLE/2, 60, 20);
            g.fillRect(x*TAILLE + TAILLE/2, y*TAILLE + TAILLE/2, 60, 20);
            g.setColor(Color.BLACK);
            g.drawString("EAU",x*TAILLE + TAILLE/2+5, y*TAILLE + TAILLE/2+15);
        }

        if(z.getTresor()==3){
            g.setColor(Color.WHITE);
            g.drawRect(x*TAILLE + TAILLE/2, y*TAILLE + TAILLE/2, 60, 20);
            g.fillRect(x*TAILLE + TAILLE/2, y*TAILLE + TAILLE/2, 60, 20);
            g.setColor(Color.BLACK);
            g.drawString("AIR",x*TAILLE + TAILLE/2+5, y*TAILLE + TAILLE/2+15);
        }

    } 


    private void placeJoueurs(Graphics g, Joueur j, int x, int y){
        if(modele.getjoueurs().size()==1){
            if(j == this.modele.getjoueurs().get(0)){
                g.setColor(Color.RED);
                g.drawOval(x*TAILLE, y*TAILLE, 30,30);
                g.fillOval(x*TAILLE, y*TAILLE, 30,30);
                g.setColor(Color.BLACK);
                g.drawString(j.getNom(),x*TAILLE+3, y*TAILLE+20);
            }
        }

        if(modele.getjoueurs().size()==2){
            if(j == this.modele.getjoueurs().get(0)){
                g.setColor(Color.RED);
                g.drawOval(x*TAILLE, y*TAILLE, 30,30);
                g.fillOval(x*TAILLE, y*TAILLE, 30,30);
                g.setColor(Color.BLACK);
                g.drawString(j.getNom(),x*TAILLE+3, y*TAILLE+20);
            }

            if(j == this.modele.getjoueurs().get(1)){
                g.setColor(Color.CYAN);
                g.drawOval(x*TAILLE+50, y*TAILLE, 30,30);
                g.fillOval(x*TAILLE+50, y*TAILLE, 30,30);
                g.setColor(Color.BLACK);
                g.drawString(j.getNom(),x*TAILLE+53, y*TAILLE+20);
            }
        }

        if(modele.getjoueurs().size()==3){
            if(j == this.modele.getjoueurs().get(0)){
                g.setColor(Color.RED);
                g.drawOval(x*TAILLE, y*TAILLE, 30,30);
                g.fillOval(x*TAILLE, y*TAILLE, 30,30);
                g.setColor(Color.BLACK);
                g.drawString(j.getNom(),x*TAILLE+3, y*TAILLE+20);
            }

            if(j == this.modele.getjoueurs().get(1)){
                g.setColor(Color.CYAN);
                g.drawOval(x*TAILLE+50, y*TAILLE, 30,30);
                g.fillOval(x*TAILLE+50, y*TAILLE, 30,30);
                g.setColor(Color.BLACK);
                g.drawString(j.getNom(),x*TAILLE+53, y*TAILLE+20);
            }

            if(j == this.modele.getjoueurs().get(2)){
                g.setColor(Color.PINK);
                g.drawOval(x*TAILLE, y*TAILLE+50, 30,30);
                g.fillOval(x*TAILLE, y*TAILLE+50, 30,30);
                g.setColor(Color.BLACK);
                g.drawString(j.getNom(),x*TAILLE+3, y*TAILLE+70);
            }
        }

        if(modele.getjoueurs().size()==4){
            if(j == this.modele.getjoueurs().get(0)){
                g.setColor(Color.RED);
                g.drawOval(x*TAILLE, y*TAILLE, 30,30);
                g.fillOval(x*TAILLE, y*TAILLE, 30,30);
                g.setColor(Color.BLACK);
                g.drawString(j.getNom(),x*TAILLE+3, y*TAILLE+20);
            }

            if(j == this.modele.getjoueurs().get(1)){
                g.setColor(Color.CYAN);
                g.drawOval(x*TAILLE+50, y*TAILLE, 30,30);
                g.fillOval(x*TAILLE+50, y*TAILLE, 30,30);
                g.setColor(Color.BLACK);
                g.drawString(j.getNom(),x*TAILLE+53, y*TAILLE+20);
            }

            if(j == this.modele.getjoueurs().get(2)){
                g.setColor(Color.PINK);
                g.drawOval(x*TAILLE, y*TAILLE+50, 30,30);
                g.fillOval(x*TAILLE, y*TAILLE+50, 30,30);
                g.setColor(Color.BLACK);
                g.drawString(j.getNom(),x*TAILLE+3, y*TAILLE+70);
            }

            if(j == this.modele.getjoueurs().get(3)){
                g.setColor(Color.YELLOW);
                g.drawOval(x*TAILLE+50, y*TAILLE+50, 30,30);
                g.fillOval(x*TAILLE+50, y*TAILLE+50, 30,30);
                g.setColor(Color.BLACK);
                g.drawString(j.getNom(),x*TAILLE+53, y*TAILLE+70);
            }
        }
    } 
}