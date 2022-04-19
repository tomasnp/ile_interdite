package Vue;
import javax.swing.JFrame;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Modele.*;

public class Vue extends JFrame {
    private JFrame frame;
    private ViewSetup setup;
    private VueGrille grid;
    final int height = 200;
    final int width = 200;
    private JPanel elements;
    private JTextArea comment;
   //private ContrEndTurn contrEndTurn;


    public Vue(Modele modele) {
        frame = new JFrame();
        frame.setTitle("ILE INTERDITE");
        //frame.setResizable(false);
        
    
        frame.setLayout(new GridLayout());
        //Ile ile = new Ile(6);
        //frame.add(ile);
        VueGrille grille;
        ViewSetup commandes;
        grille = new VueGrille(modele);

        frame.add(grille);
        commandes = new ViewSetup(modele);
        frame.add(commandes); 
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void start() {
        getContentPane().removeAll();
        setSize(width, height);
        elements = new JPanel();
        elements.setBackground(new Color(55, 55, 55));

        add(elements);

        comment = new JTextArea();
        comment.setFont(comment.getFont().deriveFont(20f));
        comment.setPreferredSize(new Dimension(300, this.grid.sizeJpanel - 40));
        comment.setBackground(new Color(100, 100, 100));
        //changeText();

        JButton next = new JButton("End of turn");
        next.setPreferredSize(new Dimension(this.grid.sizeJpanel / 3, 50));
        //next.addActionListener(contrEndTurn);
        JButton dig = new JButton("Dig");
        dig.setPreferredSize(new Dimension(this.grid.sizeJpanel / 3, 50));
        JButton pick = new JButton("Pick");
        pick.setPreferredSize(new Dimension(this.grid.sizeJpanel / 3, 50));

        elements.add(this.grid);
        elements.add(this.comment);
        elements.add(next);
        elements.add(dig);
        elements.add(pick);

        repaint();
    }
}