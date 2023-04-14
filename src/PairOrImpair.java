import java.util.Scanner;

public class PairOrImpair {

    public static void PairOrImpair(int nbr){
        String message = "";
        boolean NbrPremier = true;

        for (int i = 2; i<= nbr/2; i++){
            if(nbr%i == 0){
                NbrPremier = false;
                break;
            }
        }
        switch(nbr % 2){
            case 0:
                message = "chiffre pair";
                break;
            default:
                message = "chiffre impair";
                break;
        }

        if(NbrPremier){
            message += " et premier";
        }

        System.out.println(message);
    }


    public static void main(String[] args) {

        System.out.println("Saisir chiffre :");
        Scanner input = new Scanner(System.in);
        int nbr = input.nextInt();

        PairOrImpair(nbr);

    }

}
