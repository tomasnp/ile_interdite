import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

interface Observer {
    /**
     * Un observateur doit posséder une méthode [update] déclenchant la mise à
     * jour.
     */
    public void update();
    /**
     * La version officielle de Java possède des paramètres précisant le
     * changement qui a eu lieu.
     */
}
/**
 * Classe des objets pouvant être observés.
 */
abstract class Observable {
    /**
     * On a une liste [observers] d'observateurs, initialement vide, à laquelle
     * viennent s'inscrire les observateurs via la méthode [addObserver].
     */
    private ArrayList<Observer> observers;
    public Observable() {
	this.observers = new ArrayList<Observer>();
    }
    public void addObserver(Observer o) {
	observers.add(o);
    }

    /**
     * Lorsque l'état de l'objet observé change, il est convenu d'appeler la
     * méthode [notifyObservers] pour prévenir l'ensemble des observateurs
     * enregistrés.
     * On le fait ici concrètement en appelant la méthode [update] de chaque
     * observateur.
     */
    public void notifyObservers() {
		for(Observer o : observers) {
			o.update();
		}
    }
}
/** Fin du schéma observateur/observé. */


/**
 * Nous allons commencer à construire notre application, en voici la classe
 * principale.
 */
public class Projet {
    /**
     * L'amorçage est fait en créant le modèle et la vue, par un simple appel
     * à chaque constructeur.
     * Ici, le modèle est créé indépendamment (il s'agit d'une partie autonome
     * de l'application), et la vue prend le modèle comme paramètre (son
     * objectif est de faire le lien entre modèle et utilisateur).
     */
    public static void main(String[] args) {
	/**
	 * Pour les besoins du jour on considère la ligne EvenQueue... comme une
	 * incantation qu'on pourra expliquer plus tard.
	 */
	EventQueue.invokeLater(() -> {
		/** Voici le contenu qui nous intéresse. */
                CModele modele = new CModele();
                CVue vue = new CVue(modele);
	    });
    }
}
/** Fin de la classe principale. */


/**
 * Le modèle : le coeur de l'application.
 *
 * Le modèle étend la classe [Observable] : il va posséder un certain nombre
 * d'observateurs (ici, un : la partie de la vue responsable de l'affichage)
 * et devra les prévenir avec [notifyObservers] lors des modifications.
 * Voir la méthode [avance()] pour cela.
 */
class CModele extends Observable {
    /** On fixe la taille de la grille. */
    public static final int HAUTEUR=60, LARGEUR=60;
    /** On stocke un tableau de cellules. */
    private Cellule[][] cellules;

    /** Construction : on initialise un tableau de cellules. */
    public CModele() {
	/**
	 * Pour éviter les problèmes aux bords, on ajoute une ligne et une
	 * colonne de chaque côté, dont les cellules n'évolueront pas.
	 */ 
	cellules = new Cellule[LARGEUR+2][HAUTEUR+2];
	for(int i=0; i<LARGEUR+2; i++) {
	    for(int j=0; j<HAUTEUR+2; j++) {
		cellules[i][j] = new Cellule(this,i, j);
	    }
	}
	init();
    }

    /**
     * Initialisation aléatoire des cellules, exceptées celle des bords qui
     * ont été ajoutés.
     */
    public void init() {
	for(int i=1; i<=LARGEUR; i++) {
	    for(int j=1; j<=HAUTEUR; j++) {
		if (Math.random() < .2) {
		    cellules[i][j].etat = 0;
		}
	    }
	}
    }

    /**
     * Calcul de la génération suivante.
     */
    public void avance() {
	/**
	 * On procède en deux étapes.
	 *  - D'abord, pour chaque cellule on évalue ce que sera son état à la
	 *    prochaine génération.
	 *  - Ensuite, on applique les évolutions qui ont été calculées.

	for(int i=1; i<LARGEUR+1; i++) {
	    for(int j=1; j<HAUTEUR+1; j++) {
		cellules[i][j].evalue();
	    }
	}
	for(int i=1; i<LARGEUR+1; i++) {
	    for(int j=1; j<HAUTEUR+1; j++) {
		cellules[i][j].evolue();
	    }
	}
	 */
	/**
	 * Pour finir, le modèle ayant changé, on signale aux observateurs
	 * qu'ils doivent se mettre à jour.
	 */
	notifyObservers();
    }

    /**
     * Méthode auxiliaire : compte le nombre de voisines vivantes d'une
     * cellule désignée par ses coordonnées.
     */
    /*protected int compteVoisines(int x, int y) {
	int res=0; */
	/**
	 * Stratégie simple à écrire : on compte les cellules vivantes dans le
	 * carré 3x3 centré autour des coordonnées (x, y), puis on retire 1
	 * si la cellule centrale est elle-même vivante.
	 * On n'a pas besoin de traiter à part les bords du tableau de cellules
	 * grâce aux lignes et colonnes supplémentaires qui ont été ajoutées
	 * de chaque côté (dont les cellules sont mortes et n'évolueront pas).
	 */
	/*
	for(int i=x-1; i<=x+1; i++) {
	    for(int j=y-1; j<=y+1; j++) {
		if (cellules[i][j].etat) { res++; }
	    }
	}*/
	//return (res - ((cellules[x][y].etat)?1:0));
	/**
	 * L'expression [(c)?e1:e2] prend la valeur de [e1] si [c] vaut [true]
	 * et celle de [e2] si [c] vaut [false].
	 * Cette dernière ligne est donc équivalente à
	 *     int v;
	 *     if (cellules[x][y].etat) { v = res - 1; }
	 *     else { v = res - 0; }
	 *     return v;
	 */
    //}

    /**
     * Une méthode pour renvoyer la cellule aux coordonnées choisies (sera
     * utilisée par la vue).
     */
    public Cellule getCellule(int x, int y) {
	return cellules[x][y];
    }
    /**
     * Notez qu'à l'intérieur de la classe [CModele], la classe interne est
     * connue sous le nom abrégé [Cellule].
     * Son nom complet est [CModele.Cellule], et cette version complète est
     * la seule à pouvoir être utilisée depuis l'extérieur de [CModele].
     * Dans [CModele], les deux fonctionnent.
     */
}

/** Fin de la classe CModele. */

/**
 * Définition d'une classe pour les cellules.
 * Cette classe fait encore partie du modèle.
 */
class Cellule {
    /** On conserve un pointeur vers la classe principale du modèle. */
    private CModele modele;

    /** L'état d'une cellule est donné par un booléen. */
    protected int etat;
    /**
     * On stocke les coordonnées pour pouvoir les passer au modèle lors
     * de l'appel à [compteVoisines].
     */
    private final int x, y;
    public Cellule(CModele modele, int x, int y) {
        this.modele = modele;
        this.etat = 0;
        this.x = x; this.y = y;
    }

    
    /** Un test à l'usage des autres classes (sera utilisé par la vue). */
    public boolean estVivant() {
        return etat ==1 || etat ==0;
    }
}    
/** Fin de la classe Cellule, et du modèle en général. */


/**
 * La vue : l'interface avec l'utilisateur.
 *
 * On définit une classe chapeau [CVue] qui crée la fenêtre principale de 
 * l'application et contient les deux parties principales de notre vue :
 *  - Une zone d'affichage où on voit l'ensemble des cellules.
 *  - Une zone de commande avec un bouton pour passer à la génération suivante.
 */
class CVue {
    /**
     * JFrame est une classe fournie pas Swing. Elle représente la fenêtre
     * de l'application graphique.
     */
    private JFrame frame;
    /**
     * VueGrille et VueCommandes sont deux classes définies plus loin, pour
     * nos deux parties de l'interface graphique.
     */
    private VueGrille grille;
    private VueCommandes commandes;

    /** Construction d'une vue attachée à un modèle. */
    public CVue(CModele modele) {
	/** Définition de la fenêtre principale. */
	frame = new JFrame();
	frame.setTitle("Jeu de la vie de Conway");
	/**
	 * On précise un mode pour disposer les différents éléments à
	 * l'intérieur de la fenêtre. Quelques possibilités sont :
	 *  - BorderLayout (défaut pour la classe JFrame) : chaque élément est
	 *    disposé au centre ou le long d'un bord.
	 *  - FlowLayout (défaut pour un JPanel) : les éléments sont disposés
	 *    l'un à la suite de l'autre, dans l'ordre de leur ajout, les lignes
	 *    se formant de gauche à droite et de haut en bas. Un élément peut
	 *    passer à la ligne lorsque l'on redimensionne la fenêtre.
	 *  - GridLayout : les éléments sont disposés l'un à la suite de
	 *    l'autre sur une grille avec un nombre de lignes et un nombre de
	 *    colonnes définis par le programmeur, dont toutes les cases ont la
	 *    même dimension. Cette dimension est calculée en fonction du
	 *    nombre de cases à placer et de la dimension du contenant.
	 */
	frame.setLayout(new FlowLayout());

	/** Définition des deux vues et ajout à la fenêtre. */
	grille = new VueGrille(modele);
	frame.add(grille);
	commandes = new VueCommandes(modele);
	frame.add(commandes);
	/**
	 * Remarque : on peut passer à la méthode [add] des paramètres
	 * supplémentaires indiquant où placer l'élément. Par exemple, si on
	 * avait conservé la disposition par défaut [BorderLayout], on aurait
	 * pu écrire le code suivant pour placer la grille à gauche et les
	 * commandes à droite.
	 *     frame.add(grille, BorderLayout.WEST);
	 *     frame.add(commandes, BorderLayout.EAST);
	 */

	/**
	 * Fin de la plomberie :
	 *  - Ajustement de la taille de la fenêtre en fonction du contenu.
	 *  - Indiquer qu'on quitte l'application si la fenêtre est fermée.
	 *  - Préciser que la fenêtre doit bien apparaître à l'écran.
	 */
	frame.pack();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
    }
}


/**
 * Une classe pour représenter la zone d'affichage des cellules.
 *
 * JPanel est une classe d'éléments graphiques, pouvant comme JFrame contenir
 * d'autres éléments graphiques.
 *
 * Cette vue va être un observateur du modèle et sera mise à jour à chaque
 * nouvelle génération des cellules.
 */
class VueGrille extends JPanel implements Observer {
    /** On maintient une référence vers le modèle. */
    private CModele modele;
    /** Définition d'une taille (en pixels) pour l'affichage des cellules. */
    private final static int TAILLE = 12;

    /** Constructeur. */
    public VueGrille(CModele modele) {
	this.modele = modele;
	/** On enregistre la vue [this] en tant qu'observateur de [modele]. */
	modele.addObserver(this);
	/**
	 * Définition et application d'une taille fixe pour cette zone de
	 * l'interface, calculée en fonction du nombre de cellules et de la
	 * taille d'affichage.
	 */
	Dimension dim = new Dimension(TAILLE*CModele.LARGEUR,
				      TAILLE*CModele.HAUTEUR);
	this.setPreferredSize(dim);
    }

    /**
     * L'interface [Observer] demande de fournir une méthode [update], qui
     * sera appelée lorsque la vue sera notifiée d'un changement dans le
     * modèle. Ici on se content de réafficher toute la grille avec la méthode
     * prédéfinie [repaint].
     */
    public void update() { repaint(); }

    /**
     * Les éléments graphiques comme [JPanel] possèdent une méthode
     * [paintComponent] qui définit l'action à accomplir pour afficher cet
     * élément. On la redéfinit ici pour lui confier l'affichage des cellules.
     *
     * La classe [Graphics] regroupe les éléments de style sur le dessin,
     * comme la couleur actuelle.
     */
    /**
     * Fonction auxiliaire de dessin d'une cellule.
     * Ici, la classe [Cellule] ne peut être désignée que par l'intermédiaire
     * de la classe [CModele] à laquelle elle est interne, d'où le type
     * [CModele.Cellule].
     * Ceci serait impossible si [Cellule] était déclarée privée dans [CModele].

    private void paint(Graphics g, Cellule c, int x, int y) {
        /** Sélection d'une couleur. */
	/*
	if (c.estVivante()) {
	    g.setColor(Color.BLACK);
	} else {
            g.setColor(Color.WHITE);
        }
        // Coloration d'un rectangle.
        g.fillRect(x, y, TAILLE, TAILLE);
    }
	*/
}


/**
 * Une classe pour représenter la zone contenant le bouton.
 *
 * Cette zone n'aura pas à être mise à jour et ne sera donc pas un observateur.
 * En revanche, comme la zone précédente, celle-ci est un panneau [JPanel].
 */
class VueCommandes extends JPanel {
    /**
     * Pour que le bouton puisse transmettre ses ordres, on garde une
     * référence au modèle.
     */
    private CModele modele;

    /** Constructeur. */
    public VueCommandes(CModele modele) {
	this.modele = modele;
	/**
	 * On crée un nouveau bouton, de classe [JButton], en précisant le
	 * texte qui doit l'étiqueter.
	 * Puis on ajoute ce bouton au panneau [this].
	 */
	JButton boutonAvance = new JButton("->");
	this.add(boutonAvance);
	/**
	 * Le bouton, lorsqu'il est cliqué par l'utilisateur, produit un
	 * événement, de classe [ActionEvent].
	 *
	 * On a ici une variante du schéma observateur/observé : un objet
	 * implémentant une interface [ActionListener] va s'inscrire pour
	 * "écouter" les événements produits par le bouton, et recevoir
	 * automatiquements des notifications.
	 * D'autres variantes d'auditeurs pour des événements particuliers :
	 * [MouseListener], [KeyboardListener], [WindowListener].
	 *
	 * Cet observateur va enrichir notre schéma Modèle-Vue d'une couche
	 * intermédiaire Contrôleur, dont l'objectif est de récupérer les
	 * événements produits par la vue et de les traduire en instructions
	 * pour le modèle.
	 * Cette strate intermédiaire est potentiellement riche, et peut
	 * notamment traduire les mêmes événements de différentes façons en
	 * fonction d'un état de l'application.
	 * Ici nous avons un seul bouton réalisant une seule action, notre
	 * contrôleur sera donc particulièrement simple. Cela nécessite
	 * néanmoins la création d'une classe dédiée.
	 */	
	Controleur ctrl = new Controleur(modele);
	/** Enregistrement du contrôleur comme auditeur du bouton. */
	boutonAvance.addActionListener(ctrl);
	
	/**
	 * Variante : une lambda-expression qui évite de créer une classe
         * spécifique pour un contrôleur simplissime.
         *
         JButton boutonAvance = new JButton(">");
         this.add(boutonAvance);
         boutonAvance.addActionListener(e -> { modele.avance(); });
         *
         */

    }
}
/** Fin de la vue. */

/**
 * Classe pour notre contrôleur rudimentaire.
 * 
 * Le contrôleur implémente l'interface [ActionListener] qui demande
 * uniquement de fournir une méthode [actionPerformed] indiquant la
 * réponse du contrôleur à la réception d'un événement.
 */
class Controleur implements ActionListener {
    /**
     * On garde un pointeur vers le modèle, car le contrôleur doit
     * provoquer un appel de méthode du modèle.
     * Remarque : comme cette classe est interne, cette inscription
     * explicite du modèle est inutile. On pourrait se contenter de
     * faire directement référence au modèle enregistré pour la classe
     * englobante [VueCommandes].
     */
    CModele modele;
    public Controleur(CModele modele) { this.modele = modele; }
    /**
     * Action effectuée à réception d'un événement : appeler la
     * méthode [avance] du modèle.
	 */
    public void actionPerformed(ActionEvent e) {
        modele.avance();
    }
}
/** Fin du contrôleur. */

