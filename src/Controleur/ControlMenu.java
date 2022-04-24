package Controleur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import Modele.*;
import Vue.*;

/**
 * ContrSetup
 */
public class ControlMenu extends Controleur implements ActionListener {
    private Vue vue;

    public ControlMenu(Modele modele, Vue vue) {
        super(modele);
        this.vue = vue;
    }
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> names = vue.getViewSetup().getNamePlayer();
        System.out.println(names);
        vue.start();
    }
}