import java.util.ArrayList;
import java.util.Comparator;

public class Bande {
    private int longueur;
    private int largeur;
    private int hauteur;
    private int hauteurRestante;
    private final ArrayList<Carton> lesCartons;

    public Bande(int longueur, int largeur, int hauteur) {
        this.longueur = longueur;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.hauteurRestante = hauteur;
        lesCartons = new ArrayList<>();
    }

    public void remplirBande(ArrayList<Carton> lesCartonsRestants) {
        ArrayList<Carton> lesCartonsCompatibles = getCartonCompatible(lesCartonsRestants);
        while (lesCartonsCompatibles.size() != 0) {
            lesCartonsCompatibles.sort(Comparator.comparing(Carton::getVolume));
            Carton cartonAAjouter = lesCartonsCompatibles.get(lesCartonsCompatibles.size() - 1);
            lesCartons.add(cartonAAjouter);
            hauteurRestante -= cartonAAjouter.getHauteur();
            lesCartonsRestants.remove(cartonAAjouter);
            lesCartonsCompatibles = getCartonCompatible(lesCartonsRestants);
        }

    }

    private ArrayList<Carton> getCartonCompatible(ArrayList<Carton> lesCartonsRestants) {
        ArrayList<Carton> lesCartonsCompatibles = new ArrayList<>();
        int longueur, largeur;
        if (lesCartons.size() == 0) {
            longueur = this.longueur;
            largeur = this.largeur;
        } else {
            longueur = lesCartons.get(lesCartons.size() - 1).getLongueur();
            largeur = lesCartons.get(lesCartons.size() - 1).getLargeur();
        }
        for (Carton unCarton: lesCartonsRestants) {
            if ((unCarton.getLargeur() <= largeur) && (unCarton.getLongueur() <= longueur) && (unCarton.getHauteur() <= hauteurRestante)) {
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
        return lesCartons;
    }
}
