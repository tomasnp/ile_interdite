package Controleur;

import Modele.Modele;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControlDD implements ActionListener{
    public Modele modele;
    public ControlDD(Modele modele) {
        this.modele = modele;
    }

    public void actionPerformed(ActionEvent e) {
        modele.deplaceDroite();
    }
}
