package Controleur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Modele.Modele;

public class ControlFvT implements ActionListener {
    public Modele modele;
    public ControlFvT(Modele modele) {
        this.modele = modele;
    }

    public void actionPerformed(ActionEvent e) {
        modele.echangeCles(0,1);
    }

}
