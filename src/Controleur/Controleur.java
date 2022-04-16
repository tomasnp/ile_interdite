package Controleur;
import Modele.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
/**
 * Controllers
 */
public class Controleur implements ActionListener {
    private Modele modele;
    public Controleur(Modele modele) {
        this.modele = modele;
    }

    public Modele getModele() {
        return modele;
    }
}