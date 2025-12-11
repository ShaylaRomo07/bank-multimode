package org.ies.tierno;

import java.util.Objects;

public class Account {
    private String iban;
    private double balance;
    private Client client;

    public Account(String iban, double balance, Client client) {
        this.iban = iban;
        this.balance = balance;
        this.client = client;
    }

    public void showInfo() {
        System.out.println("DATOS CUENTA");
        System.out.println("IBAN: " + iban);
        System.out.println("Saldo: " + balance);
        System.out.println("Clientes participantes:" + client);
//            System.out.println("Enter para continuar....");
//            Scanner scanner = new Scanner(System.in);
//            scanner.nextLine();
    }


    public double deposit(double amount) {
        balance = balance + amount;
        return balance;
    }

    public double withdraw(double amount) {
        double balanceChange = balance - amount;
        if (balance < 0) {
            System.out.println("No hay saldo suficiente");
        } else {
            balance = balanceChange;
        }
        return balance;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(balance, account.balance) == 0 && Objects.equals(iban, account.iban) && Objects.equals(client, account.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, balance, client);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}




