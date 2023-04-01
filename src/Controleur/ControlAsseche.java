package Controleur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Modele.Modele;

public class ControlAsseche implements ActionListener {
    public Modele modele;
    public ControlAsseche(Modele modele) {
        this.modele = modele;
    }

    public void actionPerformed(ActionEvent e) {
        modele.assecheSurPlace();
    }
    
}
    
