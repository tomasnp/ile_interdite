package Controleur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Modele.Modele;

public class ControlAssecheB implements ActionListener {
    public Modele modele;
    public ControlAssecheB(Modele modele) {
        this.modele = modele;
    }

    public void actionPerformed(ActionEvent e) {
        modele.assecheBas();
    }
    
}
    