package Controleur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Modele.*;

public class ControlG {
    public Modele modele;
    public ControlG(Modele modele) {
        this.modele = modele;
    }

    public void actionPerformed(ActionEvent e) {
        modele.FinTour();
    }
}
