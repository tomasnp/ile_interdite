package Vue;
import java.awt.*;

import javax.swing.*;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import Modele.*;

import Controleur.*;

public class VueGrille extends JPanel implements Observer,MouseListener{
    private Modele modele;
    private ControlGrille controle;
    
    final public int TAILLE = 100;

    public VueGrille(Modele m,ControlFinTour c){
        this.modele = m;
        this.controle =  new ControlGrille(m);;
        m.addObserver(this);
        addMouseListener(this);


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
                placeTresor(g,z,i,j);
                //placeCle(g, z, i, j);
                placeHeliport(g, z, i, j);
                for(int k = 0; k < this.modele.getjoueurs().size(); k++){
                    if(this.modele.getjoueurs().get(k).getPosition() == z){
                        placeJoueurs(g, modele.getjoueurs().get(k), i, j);
                    }
                }



            }
        }
        if(modele.PartiePerdu()){
            gameOver(g);

        }

        if(modele.PartieGagnee()){
            gameWin(g);

        }
    }

    private void paint(Graphics g, Zone z, int x, int y) {
        if (z.getEtat()==2) {
            g.setColor(Color.WHITE);
            g.drawRect(x, y, TAILLE, TAILLE);
            g.setColor(Color.BLACK);
            g.fillRect(x, y, TAILLE, TAILLE);
        } else if (z.getEtat()==1) {
            g.setColor(Color.WHITE);
            g.drawRect(x, y, TAILLE, TAILLE);
            g.setColor(Color.BLUE);
            g.fillRect(x, y, TAILLE, TAILLE);
        } else if(z.getEtat()==0){
            g.setColor(Color.WHITE);
            g.drawRect(x, y, TAILLE, TAILLE);
            g.setColor(Color.GREEN);
            g.fillRect(x, y, TAILLE, TAILLE);
        } else {
            g.setColor(Color.orange);
            g.fillRect(x, y, TAILLE, TAILLE);
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
            g.setColor(new Color(255,132,0));
            g.fillRect(x*TAILLE+25, y*TAILLE + TAILLE/2-10, 50, 20);
            g.setColor(Color.BLACK);
            g.drawRect(x*TAILLE+25, y*TAILLE + TAILLE/2-10, 50, 20);
            g.drawString("FEU",x*TAILLE+37, y*TAILLE + TAILLE/2+5);
        }
        if(z.getTresor()==1){
            g.setColor(new Color(88,41,0));
            g.fillRect(x*TAILLE+25, y*TAILLE + TAILLE/2-10, 50, 20);
            g.setColor(Color.WHITE);
            g.drawRect(x*TAILLE+25, y*TAILLE + TAILLE/2-10, 50, 20);
            g.drawString("TERRE",x*TAILLE+30, y*TAILLE + TAILLE/2+5);
        }

        if(z.getTresor()==2){
            g.setColor(new Color(0,0,120));
            g.fillRect(x*TAILLE+25, y*TAILLE + TAILLE/2-10, 50, 20);
            g.setColor(Color.WHITE);
            g.drawRect(x*TAILLE+25, y*TAILLE + TAILLE/2-10, 50, 20);
            g.drawString("EAU",x*TAILLE+37, y*TAILLE + TAILLE/2+5);
        }

        if(z.getTresor()==3){
            g.setColor(Color.WHITE);
            g.fillRect(x*TAILLE+25, y*TAILLE + TAILLE/2-10, 50, 20);
            g.setColor(Color.BLACK);
            g.drawRect(x*TAILLE+25, y*TAILLE + TAILLE/2-10, 50, 20);
            g.drawString("AIR",x*TAILLE+37, y*TAILLE + TAILLE/2+5);
        }

    }

    private void placeCle(Graphics g, Zone z, int x, int y){
        if(z.getCle()%10==0){
            g.setColor(new Color(255,132,0));
            g.fillRect(x*TAILLE+25, y*TAILLE + TAILLE/2-10, 20, 10);
            g.setColor(Color.BLACK);
            g.drawRect(x*TAILLE+25, y*TAILLE + TAILLE/2-10, 20, 10);
            //g.drawString("FEU",x*TAILLE+37, y*TAILLE + TAILLE/2+5);
        }
        if(z.getCle()%10==1){
            g.setColor(new Color(88,41,0));
            g.fillRect(x*TAILLE+25, y*TAILLE + TAILLE/2-10, 20, 10);
            g.setColor(Color.WHITE);
            g.drawRect(x*TAILLE+25, y*TAILLE + TAILLE/2-10, 20, 10);
            //g.drawString("TERRE",x*TAILLE+30, y*TAILLE + TAILLE/2+5);
        }

        if(z.getCle()%10==2){
            g.setColor(new Color(0,0,120));
            g.fillRect(x*TAILLE+25, y*TAILLE + TAILLE/2-10, 20, 10);
            g.setColor(Color.WHITE);
            g.drawRect(x*TAILLE+25, y*TAILLE + TAILLE/2-10, 20, 10);
            //g.drawString("EAU",x*TAILLE+37, y*TAILLE + TAILLE/2+5);
        }

        if(z.getCle()%10==3){
            g.setColor(Color.WHITE);
            g.fillRect(x*TAILLE+25, y*TAILLE + TAILLE/2-10, 20, 10);
            g.setColor(Color.BLACK);
            g.drawRect(x*TAILLE+25, y*TAILLE + TAILLE/2-10, 20, 10);
            //g.drawString("AIR",x*TAILLE+37, y*TAILLE + TAILLE/2+5);
        }

    }



    private void placeJoueurs(Graphics g, Joueur j, int x, int y){
        if(modele.getjoueurs().size()==1){
            if(j == this.modele.getjoueurs().get(0)){
                g.setColor(Color.RED);
                g.fillOval(x*TAILLE, y*TAILLE, 30,30);
                g.setColor(Color.BLACK);
                g.drawOval(x*TAILLE, y*TAILLE, 30,30);
                g.drawString(j.getNom(),x*TAILLE+10, y*TAILLE+20);
            }
        }

        if(modele.getjoueurs().size()==2){
            if(j == this.modele.getjoueurs().get(0)){
                if(j == modele.getjoueurAct()){
                    if(j.getPosition().getEtat() == 0)g.setColor(Color.BLACK);
                    else g.setColor(Color.WHITE);
                    g.drawString("←",x*TAILLE+32, y*TAILLE+20);
                }
                g.setColor(Color.RED);
                g.fillOval(x*TAILLE, y*TAILLE, 30,30);
                g.setColor(Color.BLACK);
                g.drawOval(x*TAILLE, y*TAILLE, 30,30);
                g.drawString(j.getNom(),x*TAILLE+10, y*TAILLE+20);
            }

            if(j == this.modele.getjoueurs().get(1)){
                if(j == modele.getjoueurAct()){
                    if(j.getPosition().getEtat() == 0)g.setColor(Color.BLACK);
                    else g.setColor(Color.WHITE);
                    g.drawString("→",x*TAILLE+50, y*TAILLE+20);
                }
                g.setColor(Color.CYAN);
                
                g.fillOval(x*TAILLE+68, y*TAILLE, 30,30);
                g.setColor(Color.BLACK);
                g.drawOval(x*TAILLE+68, y*TAILLE, 30,30);
                g.drawString(j.getNom(),x*TAILLE+78, y*TAILLE+20);
            }
        }

        if(modele.getjoueurs().size()==3){
            if(j == this.modele.getjoueurs().get(0)){
                if(j == modele.getjoueurAct()){
                    if(j.getPosition().getEtat() == 0)g.setColor(Color.BLACK);
                    else g.setColor(Color.WHITE);
                    g.drawString("←",x*TAILLE+32, y*TAILLE+20);
                }
                g.setColor(Color.RED);
                g.fillOval(x*TAILLE, y*TAILLE, 30,30);
                g.setColor(Color.BLACK);
                g.drawOval(x*TAILLE, y*TAILLE, 30,30);
                g.drawString(j.getNom(),x*TAILLE+10, y*TAILLE+20);
            }

            if(j == this.modele.getjoueurs().get(1)){
                if(j == modele.getjoueurAct()){
                    if(j.getPosition().getEtat() == 0)g.setColor(Color.BLACK);
                    else g.setColor(Color.WHITE);
                    g.drawString("→",x*TAILLE+50, y*TAILLE+20);
                }
                g.setColor(Color.CYAN);
                
                g.fillOval(x*TAILLE+68, y*TAILLE, 30,30);
                g.setColor(Color.BLACK);
                g.drawOval(x*TAILLE+68, y*TAILLE, 30,30);
                g.drawString(j.getNom(),x*TAILLE+78, y*TAILLE+20);
            }

            if(j == this.modele.getjoueurs().get(2)){
                if(j == modele.getjoueurAct()){
                    if(j.getPosition().getEtat() == 0)g.setColor(Color.BLACK);
                    else g.setColor(Color.WHITE);
                    g.drawString("←",x*TAILLE+32, y*TAILLE+88);
                }
                g.setColor(Color.PINK);
                
                g.fillOval(x*TAILLE, y*TAILLE+68, 30,30);
                g.setColor(Color.BLACK);
                g.drawOval(x*TAILLE, y*TAILLE+68, 30,30);
                g.drawString(j.getNom(),x*TAILLE+10, y*TAILLE+88);
            }
        }

        if(modele.getjoueurs().size()==4){
            if(j == this.modele.getjoueurs().get(0)){
                if(j == modele.getjoueurAct()){
                    if(j.getPosition().getEtat() == 0)g.setColor(Color.BLACK);
                    else g.setColor(Color.WHITE);
                    g.drawString("←",x*TAILLE+32, y*TAILLE+20);
                }
                g.setColor(Color.RED);
                g.fillOval(x*TAILLE, y*TAILLE, 30,30);
                g.setColor(Color.BLACK);
                g.drawOval(x*TAILLE, y*TAILLE, 30,30);
                g.drawString(j.getNom(),x*TAILLE+10, y*TAILLE+20);
            }

            if(j == this.modele.getjoueurs().get(1)){
                if(j == modele.getjoueurAct()){
                    if(j.getPosition().getEtat() == 0)g.setColor(Color.BLACK);
                    else g.setColor(Color.WHITE);
                    g.drawString("→",x*TAILLE+50, y*TAILLE+20);
                }
                g.setColor(Color.CYAN);
                g.fillOval(x*TAILLE+68, y*TAILLE, 30,30);
                g.setColor(Color.BLACK);
                g.drawOval(x*TAILLE+68, y*TAILLE, 30,30);
                g.drawString(j.getNom(),x*TAILLE+78, y*TAILLE+20);
            }

            if(j == this.modele.getjoueurs().get(2)){
                if(j == modele.getjoueurAct()){
                    if(j.getPosition().getEtat() == 0)g.setColor(Color.BLACK);
                    else g.setColor(Color.WHITE);
                    g.drawString("←",x*TAILLE+32, y*TAILLE+88);
                }
                g.setColor(Color.PINK);
                
                g.fillOval(x*TAILLE, y*TAILLE+68, 30,30);
                g.setColor(Color.BLACK);
                g.drawOval(x*TAILLE, y*TAILLE+68, 30,30);
                g.drawString(j.getNom(),x*TAILLE+10, y*TAILLE+88);
            }

            if(j == this.modele.getjoueurs().get(3)){
                if(j == modele.getjoueurAct()){
                    if(j.getPosition().getEtat() == 0)g.setColor(Color.BLACK);
                    else g.setColor(Color.WHITE);
                    g.drawString("→",x*TAILLE+50, y*TAILLE+88);
                }

                
                g.setColor(new Color(190,0,190));
                g.fillOval(x*TAILLE+68, y*TAILLE+68, 30,30);
                g.setColor(Color.BLACK);
                g.drawOval(x*TAILLE+68, y*TAILLE+68, 30,30);
                g.setColor(Color.WHITE);
                g.drawString(j.getNom(),x*TAILLE+78, y*TAILLE+88);
            }
        }
    } 

    private void placeHeliport(Graphics g, Zone z, int x, int y){
        if(z.aHeli()){
            g.setColor(Color.BLACK);
            g.fillRect(x*TAILLE-1, y*TAILLE + TAILLE/2-10, TAILLE, 20);
            g.fillRect(x*TAILLE+ TAILLE/2-10, y*TAILLE, 20, TAILLE);
            g.drawRect(x*TAILLE, y*TAILLE + TAILLE/2-10, TAILLE, 20);
            g.setColor(Color.WHITE);
            g.drawString("HELIPORT",x*TAILLE+20, y*TAILLE + TAILLE/2+5);
            g.setColor(new Color(223,175,44));
            g.fillRect(x*TAILLE-1, y*TAILLE + TAILLE/2-10, 20, 20);
            g.fillRect(x*TAILLE+83, y*TAILLE + TAILLE/2-10, 20, 20);
            g.fillRect(x*TAILLE+ TAILLE/2-10, y*TAILLE-1, 20, 20);
            g.fillRect(x*TAILLE+ TAILLE/2-10, y*TAILLE+83, 20, 20);
        }
    }

    private void gameOver(Graphics g){
        g.setColor(Color.RED);
        g.fillRect((2)* TAILLE/2, (4)* TAILLE/2, 4*TAILLE, 2*TAILLE);
        g.setColor(Color.BLACK);
        g.drawString("GAME OVER",3*TAILLE-35, 3*TAILLE);

    }

    private void gameWin(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect((2)* TAILLE/2, (4)* TAILLE/2, 4*TAILLE, 2*TAILLE);
        g.setColor(Color.BLACK);
        g.drawString("WINNERS",3*TAILLE-35, 3*TAILLE);

    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.print(x+" ");
        System.out.println(y+" ");

        int x_case = x / (TAILLE );
        int y_case = y / (TAILLE);
        this.controle.clique(x_case, y_case,modele.getActSpe());
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }
}