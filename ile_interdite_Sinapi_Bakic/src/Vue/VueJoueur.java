package Vue;
import Modele.*;
import javax.swing.*;
import java.awt.*;

public class VueJoueur extends JPanel implements Observer{
    private Modele modele;
    private JLabel label;
    private JLabel label1;
    private JLabel j1;
    private JLabel j2;
    private JLabel j3;
    private JLabel j4;
    private JLabel p1;
    private JLabel p2;
    private JLabel p3;
    private JLabel p4;

    public VueJoueur(Modele m){
        this.modele = m;
        modele.addObserver(this);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        this.label = new JLabel("0");
        this.label1 = new JLabel("1");
        this.j1 = new JLabel("j1");
        this.j2 = new JLabel("j2");
        this.j3 = new JLabel("j3");
        this.j4 = new JLabel("j4");

        this.p1 = new JLabel("p1");
        this.p2 = new JLabel("p2");
        this.p3 = new JLabel("p3");
        this.p4 = new JLabel("p4");


        panel1.setBorder(BorderFactory.createTitledBorder("TOUR ACTUEL"));
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));


/*         label.setAlignmentX(Component.LEFT_ALIGNMENT);
        label1.setAlignmentX(Component.LEFT_ALIGNMENT); */
        label1.setForeground(Color.BLUE);

        panel1.add(label);
        panel1.add(label1);


        panel2.setBorder(BorderFactory.createTitledBorder("SAC A DOS JOUEURS"));
        //j1.setAlignmentX(Component.RIGHT_ALIGNMENT);
        j1.setForeground(Color.RED);
        j2.setForeground(Color.BLUE);
        j3.setForeground(new Color(255,100,150));
        j4.setForeground(new Color(190,0,190));

        panel2.add(j1);
        panel2.add(j2);
        panel2.add(j3);
        panel2.add(j4);


        panel3.setBorder(BorderFactory.createTitledBorder("ACTIONS SPECIALES"));
        p1.setForeground(Color.RED);
        p2.setForeground(Color.BLUE);
        p3.setForeground(new Color(255,100,150));
        p4.setForeground(new Color(190,0,190));

        panel3.add(p1);
        panel3.add(p2);
        panel3.add(p3);
        panel3.add(p4);

        this.setLayout(new FlowLayout());
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.update();

    }


    public void update() { repaint(); }

    public void paintComponent(Graphics g) {
        super.repaint();
        nbActions(g, modele.getjoueurAct(), this.label);
        nomsJoueurs(g, modele.getjoueurAct(), this.label1);
        sacAdos(g, modele.getjoueurs().get(0), j1);
        sacAdos(g, modele.getjoueurs().get(1), j2);
        sacAdos(g, modele.getjoueurs().get(2), j3);
        sacAdos(g, modele.getjoueurs().get(3), j4);
        actSpe(g, modele.getjoueurs().get(0), p1);
        actSpe(g, modele.getjoueurs().get(1), p2);
        actSpe(g, modele.getjoueurs().get(2), p3);
        actSpe(g, modele.getjoueurs().get(3), p4);


    }

    public void nbActions(Graphics g, Joueur j, JLabel label){
        label.setText("Nombres d'actions restantes :  " + j.getNbActions());
    }

    public void nomsJoueurs(Graphics g, Joueur j, JLabel label){
        label.setText("→ Joueur Actif :  " + j.getNom());
    }

    public void sacAdos(Graphics g, Joueur j, JLabel label){
        String f = "FEU , ";
        String t = "TERRE , ";
        String e = "EAU , ";
        String a = "AIR ,";
        label.setText("Joueur " + j.getNom() + " : " +
                "Cles : " + f.repeat(j.aCle(00))+ t.repeat(j.aCle(01)) + e.repeat(j.aCle(02)) +  a.repeat(j.aCle(03))
                + f.repeat(j.aCle(10))+ t.repeat(j.aCle(11)) + e.repeat(j.aCle(12)) +  a.repeat(j.aCle(13))
                + f.repeat(j.aCle(20))+ t.repeat(j.aCle(21)) + e.repeat(j.aCle(22)) +  a.repeat(j.aCle(23))
                + f.repeat(j.aCle(30))+ t.repeat(j.aCle(31)) + e.repeat(j.aCle(32)) +  a.repeat(j.aCle(33))

                + " ||  Tresors : " + f.repeat(j.aTresor(0)) + t.repeat(j.aTresor(1)) + e.repeat(j.aTresor(2)) + a.repeat(j.aTresor(3)));

    }

    public void actSpe(Graphics g, Joueur j, JLabel label){
        label.setText("Joueur " + j.getNom() + " : " + " HELICO : " + j.getActionHeli() + " ||  SAC SABLE : " + j.getActionSacSable());
    }


}
