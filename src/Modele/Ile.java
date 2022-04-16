package Modele;

import Modele.Zone;


 // Ile

public class Ile {

    private Zone[][] plateau;
    private int taille;

    public Ile(int taille){
        this.taille = taille;
        this.plateau = new Zone[taille][taille];
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                Zone z = new Zone(i,j);
                this.plateau[i][j] = z;
                if (Math.abs(i - (taille - 1) / 2.) +
                        Math.abs(j - (taille - 1) / 2.) <= taille / 2.) {
                    this.plateau[i][j].setEtat(0);
                } else {
                    this.plateau[i][j].setEtat(2);
                }
                
            }
        }
    }

    public Zone[][] getIleEtat(){
        return plateau;
    }

    public Zone getZone(int i, int j) {
        return this.plateau[i][j];
    }

    public int getGridtaille() {
        return this.taille;
    }

    public void affiche(){
        for(int i = 0; i<6; i++ ){
            for(int j = 0; j<6;j++){

                System.out.print(this.getZone(i, j));
            }
            System.out.println();
        }
    }

/*     public ArrayList<Integer> getCoordLine(int y) {
        ArrayList<Integer> s = new ArrayList<Integer>();
        for (int index = 0; index < grid.taille(); index++) {
            if (grid.get(y).get(index) != null) {
                s.add(index);
            }
        }
        return s;
    } */
}
