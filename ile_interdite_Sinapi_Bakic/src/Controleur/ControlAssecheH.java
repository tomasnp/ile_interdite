package Controleur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Modele.Modele;

public class ControlAssecheH implements ActionListener {
    public Modele modele;
    public ControlAssecheH(Modele modele) {
        this.modele = modele;
    }

    public void actionPerformed(ActionEvent e) {
        modele.assecheHaut();
    }
    
}
    