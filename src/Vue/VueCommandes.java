package Vue;

import javax.swing.JButton;

import javax.swing.JPanel;

import Modele.Modele;

import javax.sound.sampled.Control;
import javax.swing.*;
import java.awt.*;

import Controleur.*;


public class VueCommandes extends JPanel {
	private Modele modele;

    public VueCommandes(Modele g) {
        this.modele = g;
        /**
         * On crée un nouveau bouton, de classe [JButton], en précisant le
         * texte qui doit l'étiqueter.
         * Puis on ajoute ce bouton au panneau [this].
         */

        this.setLayout(new GridLayout(3,1,20,100));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        JButton boutonFindetour = new JButton("Fin de tour");
        panel1.add(boutonFindetour, BorderLayout.CENTER);
        ControlFinTour ctrl = new ControlFinTour(g);
        boutonFindetour.addActionListener(ctrl);


        this.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        JButton boutonDeplaceGauche = new JButton("←");
        panel2.add(boutonDeplaceGauche, BorderLayout.WEST);
        ControlDG ctrl2 = new ControlDG(g);
        boutonDeplaceGauche.addActionListener(ctrl2);

        JButton boutonDeplaceHaut = new JButton("↑");
        panel2.add(boutonDeplaceHaut, BorderLayout.NORTH);
        ControlDH ctrl3 = new ControlDH(g);
        boutonDeplaceHaut.addActionListener(ctrl3);

        JButton boutonDeplaceBas = new JButton("↓");
        panel2.add(boutonDeplaceBas, BorderLayout.SOUTH);
        ControlDB ctrl4 = new ControlDB(g);
        boutonDeplaceBas.addActionListener(ctrl4);

        JButton boutonDeplaceDroite = new JButton("→");
        panel2.add(boutonDeplaceDroite, BorderLayout.EAST);
        ControlDD ctrl5 = new ControlDD(g);
        boutonDeplaceDroite.addActionListener(ctrl5);

        this.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());

        JButton boutonAsseche = new JButton("Assecher");
        panel3.add(boutonAsseche, BorderLayout.CENTER);
        ControlAsseche ctrl6 = new ControlAsseche(g);
        boutonAsseche.addActionListener(ctrl6);

        JButton boutonAssecheGauche = new JButton("G");
        panel3.add(boutonAssecheGauche, BorderLayout.WEST);
        ControlAssecheG ctrl7 = new ControlAssecheG(g);
        boutonAssecheGauche.addActionListener(ctrl7);

        JButton boutonAssecheHaut = new JButton("H");
        panel3.add(boutonAssecheHaut, BorderLayout.NORTH);
        ControlAssecheH ctrl8 = new ControlAssecheH(g);
        boutonAssecheHaut.addActionListener(ctrl8);

        JButton boutonAssecheBas = new JButton("B");
        panel3.add(boutonAssecheBas, BorderLayout.SOUTH);
        ControlAssecheB ctrl9 = new ControlAssecheB(g);
        boutonAssecheBas.addActionListener(ctrl9);

        JButton boutonAssecheDroite = new JButton("D");
        panel3.add(boutonAssecheDroite, BorderLayout.EAST);
        ControlAssecheD ctrl10 = new ControlAssecheD(g);
        boutonAssecheDroite.addActionListener(ctrl10);

        this.add(panel3);

        JPanel panel6 = new JPanel();
        panel6.setLayout(new BorderLayout());
        JButton boutonChercheCle = new JButton("Chercher Clé");
        panel6.add(boutonChercheCle, BorderLayout.WEST);
        
        JButton boutonRecupTresor = new JButton("Ramasser Tresor");
        panel6.add(boutonRecupTresor, BorderLayout.EAST);
        ControlRecupT ctrlRecupT = new ControlRecupT(g);
        ControlCC ctrlCC = new ControlCC(g);
        boutonRecupTresor.addActionListener(ctrlRecupT);
        boutonChercheCle.addActionListener(ctrlCC);
        this.add(panel6);

        JPanel panel7 = new JPanel();
        panel7.setLayout(new FlowLayout());
        JButton helico = new JButton("HELICO SEUL");
        JButton helicoT = new JButton("HELICO TOUS");
        JButton sacSable = new JButton("SAC SABLE");
        panel7.add(helico);
        panel7.add(helicoT);
        panel7.add(sacSable);
        ControlHelico ctrlHelico = new ControlHelico(g);
        ControlHelicoTous ctrlHelicoT = new ControlHelicoTous(g);
        ControlSacSable ctrlSacSable = new ControlSacSable(g);
        helico.addActionListener(ctrlHelico);
        helicoT.addActionListener(ctrlHelicoT);
        sacSable.addActionListener(ctrlSacSable);
        this.add(panel7);


    }
}