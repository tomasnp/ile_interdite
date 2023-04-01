package Controleur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Modele.Modele;

public class ControlHelicoTous implements ActionListener {
    public Modele modele;
    public ControlHelicoTous(Modele modele) {
        this.modele = modele;
    }

    public void actionPerformed(ActionEvent e) {
        modele.setActSpe(44);
    }
}