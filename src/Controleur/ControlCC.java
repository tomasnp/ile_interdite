package Controleur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Modele.*;

public class ControlCC implements ActionListener {
    public Modele modele;
    public ControlCC(Modele modele) {
        this.modele = modele;
    }

    public void actionPerformed(ActionEvent e) {
        modele.chercheCle();
    }
}
