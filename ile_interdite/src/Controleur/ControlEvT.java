package Controleur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Modele.Modele;

public class ControlEvT implements ActionListener {
    public Modele modele;
    public ControlEvT(Modele modele) {
        this.modele = modele;
    }

    public void actionPerformed(ActionEvent e) {
        modele.echangeCles(2,1);
    }

}
