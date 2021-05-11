import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Camion {
    private int longueur;
    private int largeur;
    private int hauteur;
    private final ArrayList<Tranche> lesTranches;

    public Camion(int longueur, int largeur, int hauteur) {
        this.longueur = hauteur;
        this.largeur = largeur;
        this.hauteur = hauteur;
        lesTranches = new ArrayList<>();
    }

    public Tranche ajouterTranche(ArrayList<Carton> lesCartonsRestants) {
        lesCartonsRestants.sort(Comparator.comparing(Carton::getVolume));
        Carton Carton1 = lesCartonsRestants.get(0);
        Tranche newTranche = new Tranche(this.largeur, Carton1.getLargeur(), hauteur);
        lesTranches.add(newTranche);
        return newTranche;
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

    public ArrayList<Tranche> getLesTranches() {
        return lesTranches;
    }
}
