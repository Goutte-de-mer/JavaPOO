import java.util.Scanner;

public class ThePriceIsRight {

    public static void GuessNbr() {
        int RightNbr = 1 + (int) (Math.random() * ((500 - 1) + 1));
        int coups = 0;
        boolean proposition = false;

        System.out.println("Le chiffre à deviner se trouve entre 1 et 500 (inclus)");
        Scanner input = new Scanner(System.in);

        while (!proposition) {
            coups++;
            System.out.println("Saisissez un chiffre");
            int nbr = input.nextInt();
            if (nbr > 500 || nbr < 1) {
                System.out.println("Vous devez deviner un chiffre entre 1 et 500");
            } else if (nbr < RightNbr) {
                System.out.println("Trop petit");
            } else if (nbr > RightNbr) {
                System.out.println("Trop grand");
            } else {
                System.out.println("Correct ! Vous avez devinez en " + coups + " coups.");
                proposition = true;
            }
        }
        input.close();
    }


    public static void main(String[] args) {
        GuessNbr();
    }

}
