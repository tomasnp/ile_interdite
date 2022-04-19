
import java.awt.*;

import Modele.*;
import Vue.*;



public class Projet { 
    public static void main(String[] args) {
        Ile il = new Ile(6);
        il.affiche();
        //System.out.println
        
        EventQueue.invokeLater(() -> {
                Modele m = new Modele(6);
                Vue v = new Vue(m);
        });
    }
}
