import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Lecture {

    public static Camion getCamion(String nomFichier) {
        File file = new File(nomFichier + ".txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            if( (line = br.readLine()) != null) {
                String[] lineSplit = line.split(" ");
                return new Camion(Integer.parseInt(lineSplit[0]), Integer.parseInt(lineSplit[1]), Integer.parseInt(lineSplit[2]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Carton> getCarton(String nomFichier) {
        File file = new File(nomFichier + ".txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();

            ArrayList<Carton> cartons = new ArrayList<>();
            while( (line = br.readLine()) != null) {
                String[] lineSplit = line.split(" ");

                Carton c = new Carton(Integer.parseInt(lineSplit[0]), Integer.parseInt(lineSplit[1]), Integer.parseInt(lineSplit[2]));
                cartons.add(c);
            }

            return cartons;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
