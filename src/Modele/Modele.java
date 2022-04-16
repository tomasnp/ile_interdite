package Modele;

public class Modele{
    private Ile ile;

    public Modele(int size) {
        ile = new Ile(size);
    }

    public Ile getIle() {
        return ile;
    }
}