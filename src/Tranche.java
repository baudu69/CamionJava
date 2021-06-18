import java.util.ArrayList;
import java.util.Comparator;

public class Tranche {
    private int longueur;
    private int largeur;
    private int hauteur;
    private int largeurRestante;
    private final ArrayList<Bande> lesBandes;


    public Tranche(int longueur, int largeur, int hauteur) {
        this.longueur = longueur;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.largeurRestante = largeur;
        lesBandes = new ArrayList<>();
    }

    public void remplirTranche(ArrayList<Carton> lesCartonsRestants) {
        ArrayList<Carton> lesCartonsCompatibles = getCartonsCompatibles(lesCartonsRestants);
        while (lesCartonsCompatibles.size() != 0) {
            lesCartonsCompatibles.sort(Comparator.comparing(Carton::getVolume));
            Carton cartonAAjouter = lesCartonsCompatibles.get(lesCartonsCompatibles.size() - 1);
            Bande uneBande = new Bande(cartonAAjouter.getLongueur(), cartonAAjouter.getLargeur(), hauteur);
            largeurRestante -= uneBande.getLargeur();
            uneBande.remplirBande(lesCartonsCompatibles);
            lesCartonsRestants.removeAll(uneBande.getLesCartons());
            lesBandes.add(uneBande);
            lesCartonsCompatibles = getCartonsCompatibles(lesCartonsRestants);
        }
    }

    private ArrayList<Carton> getCartonsCompatibles(ArrayList<Carton> lesCartonsRestants) {
        ArrayList<Carton> lesCartonsCompatibles = new ArrayList<>();
        if (lesBandes.size() == 0) {
            longueur = this.longueur;
            largeur = this.largeur;
        } else {
            longueur = lesBandes.get(lesBandes.size() - 1).getLongueur();
            largeur = lesBandes.get(lesBandes.size() - 1).getLongueur();
        }
        for (Carton unCarton: lesCartonsRestants) {
            if ((unCarton.getLongueur() <= longueur) && (unCarton.getLargeur() <= largeurRestante)) {
                lesCartonsCompatibles.add(unCarton);
            }
        }
        return lesCartonsCompatibles;
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
