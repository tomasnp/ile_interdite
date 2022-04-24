package Controleur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Modele.Modele;

public class ControlFvE implements ActionListener {
    public Modele modele;
    public ControlFvE(Modele modele) {
        this.modele = modele;
    }

    public void actionPerformed(ActionEvent e) {
        modele.echangeCles(0,2);
    }

}
