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

    public void remplirCamion(ArrayList<Carton> lesCartons) {
        ArrayList<Carton> lesCartonsCompatibles = getLesCartonsCompatibles(lesCartons);
        while (lesCartonsCompatibles.size() != 0) {
            lesCartonsCompatibles.sort(Comparator.comparing(Carton::getVolume));
            Carton carton1 = lesCartonsCompatibles.get(lesCartonsCompatibles.size() - 1);
            Tranche uneTranche = new Tranche(carton1.getLargeur(), carton1.getLongueur(), hauteur);
            uneTranche.remplirTranche(lesCartons);
            lesTranches.add(uneTranche);
            lesCartonsCompatibles = getLesCartonsCompatibles(lesCartons);
        }

    }

    private ArrayList<Carton> getLesCartonsCompatibles(ArrayList<Carton> lesCartons) {
        ArrayList<Carton> lesCartonsCompatibles = new ArrayList<>();
        for (Carton unCarton: lesCartons) {
            if (unCarton.getLongueur() + getLongueurActuelle() < longueur) {
                lesCartonsCompatibles.add(unCarton);
            }
        }
        return lesCartonsCompatibles;
    }

    private int getLongueurActuelle() {
        int longueurActuelle = 0;
        for (Tranche uneTranche: lesTranches) {
            longueurActuelle += uneTranche.getLargeur();
        }
        return longueurActuelle;
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

    public ArrayList<Carton> getLesCartons() {
        ArrayList<Carton> lesCartons = new ArrayList<>();
        for (Tranche uneTranche: lesTranches) {
            lesCartons.addAll(uneTranche.getLesCartons());
        }
        return lesCartons;
    }
}
