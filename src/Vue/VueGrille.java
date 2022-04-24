package Vue;
import java.awt.*;

import javax.swing.*;

import Modele.*;

public class VueGrille extends JPanel{
    private Modele modele;
    
    final public int sizeJpanel;
    
    public VueGrille(int taille){
        this.sizeJpanel = taille;
    }

    public VueGrille(Modele m) {
        this.modele = m;
        this.sizeJpanel = 30;
        Dimension dim = new Dimension(400,400);
        setPreferredSize(dim);
        setLayout(new BorderLayout());
        this.add(m.getIle());
    }
    public void ajouteElement(JComponent element) {
        add(element);
    }

    /* public void update() { repaint(); }

    public void paintComponent(Graphics g) {
        super.repaint();
        for(int i=0; i<this.sizeJpanel; i++) {
            for(int j=0; j<this.sizeJpanel; j++) {
                Zone z = modele.getIle().getZone(i, j);
                paint(g, z, z.getWidth(), z.getHeight());
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
        g.fillRect(x, y, z.getWidth(), z.getWidth());
        this.update();

    } */
}