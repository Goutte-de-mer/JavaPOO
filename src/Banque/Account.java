package Banque;

import java.util.Random;

public class Account {

    private int numero;
    private double solde;
    private String proprietaire;

    public Account(double solde, String proprietaire) {
        this.solde = solde;
        this.proprietaire = proprietaire;
        this.numero = randomAccountNbr();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public String getSoldeFormatted() {
        return BankService.formatterEnEuros(solde);
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public void crediter(double montant) {
        solde += montant;
    }

    public void debiter(double montant) {
        solde -= montant;
    }


    private int randomAccountNbr() {
        Random random = new Random();
        int numero = random.nextInt(100000);
        return numero;
    }



}
