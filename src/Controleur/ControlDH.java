package Controleur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Modele.Modele;

public class ControlDH implements ActionListener {
    public Modele modele;
    public ControlDH(Modele modele) {
        this.modele = modele;
    }

    public void actionPerformed(ActionEvent e) {
        modele.deplaceHaut();
    }
    
}
