import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Camion camion = Lecture.getCamion("entree");
        ArrayList<Carton> lesCartons = Lecture.getCarton("entree");
        camion.remplirCamion(lesCartons);
        System.out.println(camion.getLesCartons().size());

    }
}
