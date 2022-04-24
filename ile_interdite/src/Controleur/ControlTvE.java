package Controleur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Modele.Modele;

public class ControlTvE implements ActionListener {
    public Modele modele;
    public ControlTvE(Modele modele) {
        this.modele = modele;
    }

    public void actionPerformed(ActionEvent e) {
        modele.echangeCles(1,2);
    }

}
