import java.util.ArrayList;

public class Tranche {
    private int longueur;
    private int largeur;
    private int hauteur;
    private final ArrayList<Carton> lesCartons;

    public Tranche(int longueur, int largeur, int hauteur) {
        this.longueur = hauteur;
        this.largeur = largeur;
        this.hauteur = hauteur;
        lesCartons = new ArrayList<>();
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

    public ArrayList<Carton> getLesCartons() {
        return lesCartons;
    }
}
