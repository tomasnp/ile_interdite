package Controleur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Modele.*;

public class ControlFinTour implements ActionListener {
    public Modele modele;
    public ControlFinTour(Modele modele) {
        this.modele = modele;
    }

    public void actionPerformed(ActionEvent e) {
        modele.FinTour();
    }
}
