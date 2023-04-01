package Controleur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Modele.*;

public class ControlRecupT implements ActionListener{
    public Modele modele;
    public ControlRecupT(Modele modele) {
        this.modele = modele;
    }

    public void actionPerformed(ActionEvent e) {
        modele.recupTresor();
    }
}

