package Vue;

import javax.swing.JButton;

import javax.swing.JPanel;

import Controleur.Controleur; 
import Modele.Modele;

import javax.swing.*;
import java.awt.*;

import Controleur.ControlFinTour;
import Controleur.Controleur; 
import Modele.Modele;

public class VueCommandes extends JPanel {
	private Modele modele;


    
/*     public VueCommandes(Modele modele) {
        this.modele = modele;
        JButton finTour = new JButton("Fin de Tour");
        JButton boutonDroite = new JButton(">");
        JButton boutonHaut = new JButton("^");
        JButton boutonBas = new JButton("v");
        JButton boutonGauche = new JButton("<");
        this.add(boutonDroite);
        this.add(boutonHaut);
        this.add(boutonBas);
        this.add(boutonGauche);
        this.add(finTour);
        
        ControlFinTour ctrl = new ControlFinTour(modele);

        finTour.addActionListener(ctrl);

    } */

    public VueCommandes(Modele g) {
        this.modele = g;
        /**
         * On crée un nouveau bouton, de classe [JButton], en précisant le
         * texte qui doit l'étiqueter.
         * Puis on ajoute ce bouton au panneau [this].
         */

        this.setLayout(new GridLayout(3,1,20,100));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout());
        JButton boutonFindetour = new JButton("Fin de tour");
        panel1.add(boutonFindetour);
        ControlFinTour ctrl = new ControlFinTour(g);
        boutonFindetour.addActionListener(ctrl);


        this.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        JButton boutonDeplaceGauche = new JButton("←");
        panel2.add(boutonDeplaceGauche, BorderLayout.WEST);
        //ControleurG ctrl2 = new Controleur2(g);
        //boutonDeplaceGauche.addActionListener(ctrl2);

        JButton boutonDeplaceHaut = new JButton("↑");
        panel2.add(boutonDeplaceHaut, BorderLayout.NORTH);
        //Controleur3 ctrl3 = new Controleur3(g);
        //boutonDeplaceHaut.addActionListener(ctrl3);

        JButton boutonDeplaceBas = new JButton("↓");
        panel2.add(boutonDeplaceBas, BorderLayout.SOUTH);
        //Controleur4 ctrl4 = new Controleur4(g);
        //boutonDeplaceBas.addActionListener(ctrl4);

        JButton boutonDeplaceDroite = new JButton("→");
        panel2.add(boutonDeplaceDroite, BorderLayout.EAST);
        //Controleur5 ctrl5 = new Controleur5(g);
        //boutonDeplaceDroite.addActionListener(ctrl5);

        this.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());

        JButton boutonAsseche = new JButton("Assecher");
        panel3.add(boutonAsseche, BorderLayout.CENTER);
        //Controleur6 ctrl6 = new Controleur6(g);
        //boutonAsseche.addActionListener(ctrl6);

        JButton boutonAssecheGauche = new JButton("G");
        panel3.add(boutonAssecheGauche, BorderLayout.WEST);
        //Controleur7 ctrl7 = new Controleur7(g);
        //boutonAssecheGauche.addActionListener(ctrl7);

        JButton boutonAssecheHaut = new JButton("H");
        panel3.add(boutonAssecheHaut, BorderLayout.NORTH);
        //Controleur8 ctrl8 = new Controleur8(g);
        //boutonAssecheHaut.addActionListener(ctrl8);

        JButton boutonAssecheBas = new JButton("B");
        panel3.add(boutonAssecheBas, BorderLayout.SOUTH);
        //Controleur9 ctrl9 = new Controleur9(g);
        //boutonAssecheBas.addActionListener(ctrl9);

        JButton boutonAssecheDroite = new JButton("D");
        panel3.add(boutonAssecheDroite, BorderLayout.EAST);
        //Controleur10 ctrl10 = new Controleur10(g);
        //boutonAssecheDroite.addActionListener(ctrl10);

        this.add(panel3);

        JPanel panel5 = new JPanel();
        panel5.setLayout(new BorderLayout());

        JButton boutonRecupereArtefact = new JButton("Ramasser Artefact");
        panel5.add(boutonRecupereArtefact, BorderLayout.EAST);
        //ControleurRecupereArtefact ctrlrecupereA = new ControleurRecupereArtefact(g);
        //boutonRecupereArtefact.addActionListener(ctrlrecupereA);
        this.add(panel5);
    }

}