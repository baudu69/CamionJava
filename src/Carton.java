public class Carton {
    private int longueur;
    private int largeur;
    private int hauteur;
    private double volume;

    public Carton(int longueur, int largeur, int hauteur) {
        this.longueur = hauteur;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.volume = ((double)longueur/100)*((double)largeur/100)*((double)hauteur/100);
    }

    public void Tourner() {
        int lBis = largeur;
        largeur = longueur;
        longueur = lBis;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
