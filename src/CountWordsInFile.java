import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountWordsInFile {

    public static void countWordsInFile() {

        System.out.println("Veuillez taper le chemin du fichier");
        Scanner input = new Scanner(System.in);
        String chemin = input.nextLine();
        input.close();

        File file = new File(chemin);

        int nbrMots = 0;

        try {
            Scanner scanner = new Scanner(file);

            while(scanner.hasNext()){
                String mot = scanner.next().replaceAll("[^a-zA-Z0-9]", "");
                if(mot.length() > 0){
                    nbrMots++;
                }
            }
            scanner.close();

            System.out.println("Il y a " + nbrMots + " mots dans le fichier.");
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'a pas été trouvé.");
        }
    }


    public static void main(String[] args){
        countWordsInFile();
    }

}
