
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
	
	JButton boutonDroite = new JButton(">");
	JButton boutonHaut = new JButton("^");
	JButton boutonBas = new JButton("v");
	JButton boutonGauche = new JButton("<");
	this.add(boutonDroite);
	this.add(boutonHaut);
	this.add(boutonBas);
	this.add(boutonGauche);
	
	Controleur ctrl = new Controleur(modele);

	boutonDroite.addActionListener(ctrl);


    }
}