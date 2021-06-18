import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        tester("entree");
        tester("entree1");
        tester("entree2");
    }

    public static void tester(String nomFichier) {
        Camion camion = Lecture.getCamion(nomFichier);
        ArrayList<Carton> lesCartons = Lecture.getCarton(nomFichier);
        assert camion != null;
        camion.remplirCamion(lesCartons);
        System.out.println("************************************");
        System.out.println("Pour le fichier : " + nomFichier + ", on a :");
        System.out.println("Taux de remplissage : " + camion.getTauxRemplissage());
        assert lesCartons != null;
        System.out.println("Il reste " + lesCartons.size() + " cartons qui ne sont pas rentres");
        System.out.println("************************************");
    }
}
