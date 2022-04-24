package Vue;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;

import Controleur.*;

public class Vue extends JFrame {
    private Modele modele;
    private JFrame frame;
    private Menu setup;
    private VueCommandes commandes;
    private VueGrille grille;
    private ControlFinTour c;
    private VueJoueur joue;
    final int height = 200;
    final int width = 200;
    private JPanel elements;
    private JTextArea comment;
    private JPanel panel;
    private JLabel label;



    public Vue(Modele modele) {
        frame = new JFrame();
        frame.setTitle("ILE INTERDITE");
        //frame.setResizable(false);
        frame.setLayout(new BorderLayout(20,30));

        //this.setup = new Menu(this.modele, this);
        //frame.add(setup);
        this.grille = new VueGrille(modele,c);

        frame.add(grille,BorderLayout.CENTER);
        this.commandes = new VueCommandes(modele);
        frame.add(commandes,BorderLayout.EAST);
        this.joue = new VueJoueur(modele);
        frame.add(joue,BorderLayout.SOUTH); 

        /* panel = new JPanel();

		panel.setBackground(Color.GRAY);
		frame.add(panel, BorderLayout.SOUTH);
		label = new JLabel("Nombres d'actions restantes :  " + modele.getjoueurAct().getNbActions());
		panel.add(label);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sans-serif", Font.BOLD, 10)); */


        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public Vue(Modele modele,int n) {
        frame = new JFrame();
        frame.setTitle("MENU");
        frame.setAlwaysOnTop(true);


        frame.setLayout(new FlowLayout(100));
        this.setup = new Menu(this.modele, this);
        frame.add(setup);


        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setup() {
        add(this.setup);
    }

    public void start() {
        getContentPane().removeAll();
        setSize(width, height);
        elements = new JPanel();
        elements.setBackground(new Color(55, 55, 55));

        add(elements);

        comment = new JTextArea();
        comment.setFont(comment.getFont().deriveFont(20f));
        comment.setPreferredSize(new Dimension(300, this.grille.TAILLE - 40));
        comment.setBackground(new Color(255, 0, 100));
        changeText();


        elements.add(this.grille);
        elements.add(this.comment);
        repaint();
    }

    public void changeText() {
        String text = modele.getjoueurAct().getComment();
        this.comment.setText(text);
        this.comment.repaint();
    }

    public Menu getViewSetup() {
        return this.setup;
    }

}