package Controleur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Modele.*;

public class ControlDG implements ActionListener {
    public Modele modele;
    public ControlDG(Modele modele) {
        this.modele = modele;
    }

    public void actionPerformed(ActionEvent e) {
        modele.deplaceGauche();;
    }
}
