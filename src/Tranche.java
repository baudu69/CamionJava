import java.util.ArrayList;
import java.util.Comparator;

public class Tranche {
    private int longueur;
    private int largeur;
    private int hauteur;
    private final ArrayList<Bande> lesBandes;


    public Tranche(int longueur, int largeur, int hauteur) {
        this.longueur = longueur;
        this.largeur = largeur;
        this.hauteur = hauteur;
        lesBandes = new ArrayList<>();
    }

    public void remplirTranche(ArrayList<Carton> lesCartonsRestants) {
        ArrayList<Carton> lesCartonsCompatibles = getCartonsCompatibles(lesCartonsRestants);
        while (lesCartonsCompatibles.size() != 0) {
            lesCartonsCompatibles.sort(Comparator.comparing(Carton::getVolume));
            Carton cartonAAjouter = lesCartonsCompatibles.get(lesCartonsCompatibles.size() - 1);
            Bande uneBande = new Bande(cartonAAjouter.getLongueur(), cartonAAjouter.getLargeur(), hauteur);
            uneBande.remplirBande(lesCartonsCompatibles);
            lesCartonsRestants.removeAll(uneBande.getLesCartons());
            lesBandes.add(uneBande);
        }
    }

    private ArrayList<Carton> getCartonsCompatibles(ArrayList<Carton> lesCartonsRestants) {
        ArrayList<Carton> lesCartonsCompatibles = new ArrayList<>();
        if (lesBandes.size() == 0) {
            longueur = this.longueur;
            largeur = this.largeur;
        } else {
            longueur = lesBandes.get(lesBandes.size() - 1).getLargeur();
            largeur = lesBandes.get(lesBandes.size() - 1).getLongueur();
        }
        for (Carton unCarton: lesCartonsRestants) {
            if ((unCarton.getLongueur() < largeur) && (unCarton.getLargeur() + getLongueurActuelle() < longueur)) {
                lesCartonsCompatibles.add(unCarton);
            }
        }
        return lesCartonsCompatibles;
    }

    private int getLongueurActuelle() {
        int longueurActuelle = 0;
        for (Bande uneBande: lesBandes) {
            longueurActuelle += uneBande.getLargeur();
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

    public ArrayList<Carton> getLesCartons() {
        ArrayList<Carton> lesCartons = new ArrayList<>();
        for (Bande uneBande: lesBandes) {
            lesCartons.addAll(uneBande.getLesCartons());
        }
        return lesCartons;
    }

    public ArrayList<Bande> getLesBandes() {
        return lesBandes;
    }
}
