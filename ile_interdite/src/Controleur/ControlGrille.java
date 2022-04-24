package Controleur;
import Modele.Modele;
import Modele.Zone;

public class ControlGrille{
    public Modele modele;

    public ControlGrille(Modele modele) {
        this.modele = modele;
    }

    public void clique(int x, int y, int sp){
        Zone z = modele.getZone(x, y);
        if(sp == 4){
            modele.getjoueurAct().deplace(z);
            
        }
        else if(sp == 44){
            Zone p = modele.getjoueurAct().getPosition();
            for(int i =0; i < modele.getjoueurs().size(); i++){
                if(modele.getjoueurs().get(i).getPosition() == p){
                    modele.getjoueurs().get(i).donneHelico();
                    modele.getjoueurs().get(i).deplace(z);
                }
            }
        }
        else if(sp == 5){
            modele.asseche(z);
        }
    }
    

    
}
