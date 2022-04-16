package Vue;
import javax.swing.JFrame;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Modele.*;

public class Vue extends JFrame {
    private JFrame frame;

    public Vue(Modele modele) {
        frame = new JFrame();
        frame.setTitle("ILE INTERDITE");

        frame.setLayout(new FlowLayout());
        VueGrille grille;
        ViewSetup commandes;
        grille = new VueGrille(100,100);
        frame.add(grille);
        commandes = new ViewSetup(modele);
        frame.add(commandes); 
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}