package Banque;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class BankService {

    private List<Client> clients = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void ajouterClient(Client client) {
        clients.add(client);
    }


    public static String formatterEnEuros(double montant) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getCurrencyInstance(Locale.FRANCE);
        df.applyPattern("0.00 €");
        return df.format(montant);
    }



    public void demarrer(){
        afficherClients();

        //Saisi de son numéro client
        Client client = null;
        while (client == null) {
            System.out.println("Veuillez saisir votre numéro de client :");
            int numeroClient = scanner.nextInt();
            client = trouverClient(numeroClient);
            if (client == null) {
                System.out.println("Numéro de client invalide.");
            }
        }

        //Choix du compte sur lequel la/les opérations vont être effectuées
        System.out.println("Hello " + client.getNom() + " !");
        afficherComptes(client);
        Account compte = choixDuCompte(client);
        afficherOptions(compte);

        int choix;
        boolean continuer = true;

        //options de menu d'opérations
        while (continuer) {
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("Montant à débiter : ");
                    double montantDebit = scanner.nextDouble();
                    if (compte.getSolde() >= montantDebit) {
                        compte.debiter(montantDebit);
                        System.out.println("Le montant a bien été débité !");
                    } else {
                        System.out.println("Le solde du compte est insuffisant :( (You broke)");
                    }
                    afficherOptions(compte);
                    break;
                case 2:
                    System.out.println("Montant à créditer : ");
                    double montantCredit = scanner.nextDouble();
                    compte.crediter(montantCredit);
                    System.out.println("Le montant a bien été créditer ;)");
                    afficherOptions(compte);
                    break;
                case 3:
                    client.supprimerCompte(compte);
                    System.out.println("Le compte a bien été supprimé.");
                    afficherComptes(client);
                    compte = choixDuCompte(client);
                    afficherOptions(compte);
                    break;
                case 4:
                    transfererArgent(client, compte);
                    afficherOptions(compte);
                    break;
                case 5:
                    System.out.println("Solde du compte " + compte.getNumero() + " : " + compte.getSoldeFormatted());
                    afficherOptions(compte);
                    break;
                case 6:
                    afficherComptes(client);
                    compte = choixDuCompte(client);
                    afficherOptions(compte);
                    break;
                case 7:
                    demarrer();
                    break;
                case 8:
                    continuer = false;
                    quitter();
                    break;
                default:
                    System.out.println("Opération invalide.");
                    afficherOptions(compte);
            }
        }
    }
    private void afficherClients(){
        System.out.println("Liste des clients :");
        for (int i = 0; i<clients.size(); i++){
            System.out.println( "Nom : " + clients.get(i).getNom() + " - N° : " + clients.get(i).getClientNumber());
        }
    }

    private Client trouverClient(int numeroClient) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getClientNumber() == numeroClient) {
                return clients.get(i);
            }
        }
        return null;
    }

    public void afficherComptes(Client client) {
        List<Account> comptes = client.getaccountList();
        System.out.println("Comptes du client " + client.getNom() + " :");
        for (Account compte : comptes) {
            System.out.println("- " + compte.getNumero());
        }
    }

    private Account choixDuCompte(Client client) {
        Account compte = null;
        while (compte == null) {
            System.out.println("Sur quel compte souhaitez-vous effectuer des opérations ? (numéro de compte) : ");
            int numeroCompte = scanner.nextInt();
            compte = trouverCompteDuClient(client, numeroCompte);
            if (compte == null) {
                System.out.println("Numéro de compte invalide.");
            }
        }
        return compte;
    }

    private void afficherOptions(Account compte) {
        // Création du tableau des options
        String[] options = {"Débiter", "Créditer", "Supprimer compte", "Transférer de l'argent", "Voir le solde", "Retour", "Changer d'utilisateur", "Quitter"};

        // Affichage des options à l'utilisateur
        System.out.println("Quelle opération souhaitez-vous effectuer sur le compte " + compte.getNumero() + " ?");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + " - " + options[i]);
        }
    }

    public void afficherTousLesComptes() {
        for (Client client : clients) {
            afficherComptes(client);
        }
    }

    public List<Account> getAllAccounts() {
        List<Account> allAccounts = new ArrayList<>();
        for (Client client : clients) {
            allAccounts.addAll(client.getaccountList());
        }
        return allAccounts;
    }

    public Account trouverCompte(int numeroCompte) {
        List<Account> allAccounts = getAllAccounts();
        for (Account compte : allAccounts) {
            if (compte.getNumero() == numeroCompte) {
                return compte;
            }
        }
        return null;
    }

    public Account trouverCompteDuClient(Client client, int numeroCompte) {
        List<Account> comptes = client.getaccountList();
        for (Account compte : comptes) {
            if (compte.getNumero() == numeroCompte) {
                return compte;
            }
        }
        return null;
    }

    //Méthodes pour le transfert d'argent
    private double saisirMontantTransfert(Scanner scanner, Account compte) {
        double montantTransfert = 0.0;
        while (true) {
            System.out.println("Montant à transférer : ");
            if (scanner.hasNextDouble()) {
                montantTransfert = scanner.nextDouble();
                if (montantTransfert > compte.getSolde()) {
                    System.out.println("Le compte ne dispose pas d'assez de fonds pour effectuer ce transfert.");
                    continue;
                }
                break;
            } else {
                System.out.println("Montant invalide.");
                scanner.next();
            }
        }
        return montantTransfert;
    }

    private void effectuerTransfert(Account compte, Account compteDestinataire, double montantTransfert) {
        compte.debiter(montantTransfert);
        compteDestinataire.crediter(montantTransfert);
        if (montantTransfert>=100){
            System.out.println("Le montant de " + formatterEnEuros(montantTransfert) + " a bien été transféré ;) C'est généreux <3");
        } else {
            System.out.println("Le montant de " + formatterEnEuros(montantTransfert) + " a bien été transféré... C'est tout ?");
        }

    }

    private void transfererArgent(Client client, Account compte) {
        afficherTousLesComptes();
        System.out.println("N° de compte destinataire : ");
        int numeroCompteDestinataire = scanner.nextInt();
        Account compteDestinataire = trouverCompte(numeroCompteDestinataire);
        if (compteDestinataire == null) {
            System.out.println("N° de compte destinataire invalide.");
            return;
        }
        double montantTransfert = saisirMontantTransfert(scanner, compte);
        effectuerTransfert(compte, compteDestinataire, montantTransfert);
    }


    public void quitter() {
        System.out.println("Au revoir !");
        scanner.close();
        System.exit(0);
    }

}
