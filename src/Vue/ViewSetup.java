
package Vue;

import javax.swing.JButton;

import javax.swing.JPanel;

import Controleur.Controleur; 
import Modele.Modele;

public class ViewSetup extends JPanel {
	private Modele modele;

    /** Constructeur. */
    public ViewSetup(Modele modele) {
	this.modele = modele;
	
	JButton boutonAvance = new JButton(">");
	this.add(boutonAvance);
	
	Controleur ctrl = new Controleur(modele);

	boutonAvance.addActionListener(ctrl);


    }
}