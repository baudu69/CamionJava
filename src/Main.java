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
        assert lesCartons != null;
        int nbCartons = lesCartons.size();
        double volumeCarton = 0.0;
        for (Carton unCarton: lesCartons) {
            volumeCarton += unCarton.getVolume();
        }
        assert camion != null;
        camion.remplirCamion(lesCartons);
        double volumeCartonDansCamion = camion.getVolume() * camion.getTauxRemplissage();
        System.out.println("************************************");
        System.out.println("Pour le fichier : " + nomFichier + ", on a :");
        System.out.println("Taux de remplissage : " + Math.round(camion.getTauxRemplissage()*100) + "%");
        System.out.println(nbCartons-lesCartons.size() + "/" + nbCartons +" cartons sont dans le camion");
        System.out.println(Math.round((volumeCartonDansCamion/volumeCarton)*100) + "% du volume des cartons dans le camion");
        System.out.println("************************************");
    }
}
