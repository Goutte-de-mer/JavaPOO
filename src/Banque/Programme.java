package Banque;

import java.util.ArrayList;
import java.util.List;

public class Programme {

    public static void main(String[] args) {
        // Création des comptes
        Account compte1 = new Account(1000.50, "Eloi");
        Account compte2 = new Account(2307.02, "Eloi");
        Account compte3 = new Account(501, "Lucie");
        Account compte4 = new Account(3013.26, "Lucie");
        Account compte5 = new Account(1500, "Prune");

        // Création des listes de comptes pour chaque client
        List<Account> comptesJean = new ArrayList<>();
        comptesJean.add(compte1);
        comptesJean.add(compte2);

        List<Account> comptesLucie = new ArrayList<>();
        comptesLucie.add(compte3);
        comptesLucie.add(compte4);

        List<Account> comptesPrune = new ArrayList<>();
        comptesPrune.add(compte5);


        // Création des clients avec leur liste de comptes
        Client Eloi = new Client("Eloi", comptesJean);
        Client Lucie = new Client("Lucie", comptesLucie);
        Client Prune = new Client("Prune", comptesPrune);

        // Ajout d'un deuxième compte pour Prune
        Prune.ajouterCompte(500);

        BankService bankService = new BankService();
        // Ajoute les clients à la banque
        bankService.ajouterClient(Eloi);
        bankService.ajouterClient(Lucie);
        bankService.ajouterClient(Prune);

        //Lancement de l'application console
        bankService.demarrer();
    }

}
