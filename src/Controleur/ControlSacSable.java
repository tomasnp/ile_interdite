package Controleur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Modele.Modele;
public class ControlSacSable implements ActionListener{
    public Modele modele;
    public ControlSacSable(Modele modele) {
        this.modele = modele;
    }

    public void actionPerformed(ActionEvent e) {
        modele.setActSpe(5);
    }
}
