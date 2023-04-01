package Controleur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Modele.Modele;

public class ControlAvF implements ActionListener {
    public Modele modele;
    public ControlAvF(Modele modele) {
        this.modele = modele;
    }

    public void actionPerformed(ActionEvent e) {
        modele.echangeCles(3,0);
    }

}
