package Banque;

import java.util.List;
import java.util.Random;

public class Client {

    private String nom;
    private int clientNumber;
    private List<Account> accountList;

    public Client(String nom, List<Account> accountList) {
        this.nom = nom;
        this.accountList = accountList;
        this.clientNumber = generateClientNumber();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public List<Account> getaccountList() {
        return accountList;
    }

    public void setaccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public void ajouterCompte(float solde) {
        Account compte = new Account(solde, this.getNom());
        accountList.add(compte);
    }


    public void supprimerCompte(Account compte) {
        accountList.remove(compte);
    }
    private int generateClientNumber() {
        Random random = new Random();
        return random.nextInt(1000000);
    }

}
