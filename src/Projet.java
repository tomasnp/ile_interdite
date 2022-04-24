
import java.awt.*;

import Modele.*;
import Vue.*;


public class Projet { 
    public static void main(String[] args) {
        //Ile il = new Ile(6);
        //il.affiche();
        //il.neighbours(il.getZone(3, 3));
        //System.out.println(il.neighbours(il.getZone(3, 3)) );
        
        EventQueue.invokeLater(() -> {
           Modele m = new Modele(6);
                //Vue men = new Vue(m,1);
                Vue v = new Vue(m);
                //System.out.println(  m.getjoueurAct().getNbActions());
                //v.setup();
                //v.start(); 
        });

    }
}