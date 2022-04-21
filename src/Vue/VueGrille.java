package Vue;
import java.awt.*;

import javax.swing.*;

import Modele.Modele;

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
}