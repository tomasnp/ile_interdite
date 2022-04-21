package Modele;

import java.util.ArrayList;


 // Players
public class Joueur {
    private final int nbActions;

    private Zone position;
    private String nom;
    private ArrayList<Integer> card;

    // Constructeur
    public Joueur(String name, Zone zone) {
        this.nom = name;
        this.card = new ArrayList<Integer>();
        this.nbActions = 3;
        position = zone;
    }

    // Setter
    public void setPosition(Zone z) {
        this.position = z;
    }

    public void setNom(String name) {
        this.nom = name;
    }

    public void addcard(int x) {
        this.card.add(x);
    }

    // Getter
    public Zone getPosition() {
        return this.position;
    }

    public String getNom() {
        return this.nom;
    }

    public int getcard(int num) {
        return this.card.get(num);
    }

    public ArrayList<Integer> getAllCards() {
        return this.card;
    }

    public int getNbActions() {
        return this.nbActions;
    }
    
}
 