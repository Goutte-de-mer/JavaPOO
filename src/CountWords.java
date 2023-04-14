import java.util.Scanner;

public class CountWords {

    public static void HowManyWords(){
        System.out.println("Veuillez taper une phrase");
        Scanner input = new Scanner(System.in);

        String phrase = input.nextLine();
        String phraseOriginale = phrase;

        // Supprime la ponctuation et les caractères spéciaux
        phrase = phrase.replaceAll("[^a-zA-Z0-9 ]", "");

        String[] mots = phrase.trim().split("\\s+");
        int nbrMots = mots.length;

        System.out.println("Il y a " + nbrMots + " mots dans la phrase «" + phraseOriginale + "»");
    }

    public static void main(String[] args) {
        HowManyWords();
    }

}
