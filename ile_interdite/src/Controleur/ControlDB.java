package Controleur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Modele.Modele;

public class ControlDB implements ActionListener {
    public Modele modele;
    public ControlDB(Modele modele) {
        this.modele = modele;
    }

    public void actionPerformed(ActionEvent e) {
        modele.deplaceBas();
    }
    
}
    
