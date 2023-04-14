import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SaveStringInFile {

    public static void SaveSentence() {
        String filePath = "C:\\Users\\Utilisateur\\Desktop\\Cours\\CDEV\\JavaPoo\\phrase.txt";
        Path path = Paths.get(filePath);
        File file = new File(filePath);

        // Vérifie si le fichier existe et peut être écrit
        if (!file.exists() || !file.canWrite()) {
            System.err.println("Impossible d'écrire dans le fichier " + filePath);
            return;
        }

        System.out.println("Veuillez taper une phrase");
        Scanner input = new Scanner(System.in);
        String phrase = input.nextLine();
        input.close();

        try {
            Files.writeString(path, phrase, StandardCharsets.UTF_8);
            System.out.println("La phrase a été enregistrée dans le fichier " + filePath);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'enregistrement de la phrase dans le fichier " + filePath + ": " + e.getMessage());
        }
    }


    public static void main (String[] args){
        SaveSentence();
    }


}
