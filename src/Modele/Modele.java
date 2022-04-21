package Modele;

public class Modele{
    private Ile ile;

    public Modele(int size) {
        ile = new Ile(size);
    }

    public Ile getIle() {
        return ile;
    }

   

    public void FinTour(){
        this.getIle().randomZone().noie();
        
        this.getIle().randomZone().noie();
        this.getIle().randomZone().noie();
    }
}