package org.ies.tierno.app;

import org.ies.tierno.Account;
import org.ies.tierno.Bank;
import org.ies.tierno.BankReader;
import org.ies.tierno.Client;

import java.util.Scanner;

public class BankMenuApp {
    private final Scanner scanner;
    private final BankReader bankReader;

    public BankMenuApp(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {
        Bank bank = bankReader.read();
        int option;
        do {
            System.out.println("Elige una opcion");
            System.out.println("    1.Mostrar las cuentas del banco");
            System.out.println("    2. Mostrar datos de una cuenta");
            System.out.println("    3.Mostrar los datos de las cuentas de un cliente");
            System.out.println("    4.Ingresar dinero en cuenta");
            System.out.println("    5.Sacar dinero de una cuenta");
            System.out.println("    6.Contar cuentas de cliente");
            System.out.println("    7.Mostrar cliente de cuenta");
            System.out.println("    8.Realizar transferencia");
            System.out.println("    9.Salir");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                showAccounts(bank);
            } else if (option == 2) {
                showOneAccount(bank);
            } else if (option == 3) {
                showAccountsClient(bank);
            } else if (option == 4) {
                deposit(bank);
            } else if (option == 5) {
                withdraw(bank);
            } else if (option == 6) {
                numberAccounts(bank);
            } else if (option == 7) {
                showClient(bank);
            } else if (option == 8) {
                transference(bank);
            } else if (option == 9) {
                System.out.println("Saliendo.....");
            } else {
                System.out.println("Opcion invalida");
                enter();
            }
        } while (option != 9);
    }

    public void showAccounts(Bank bank) {
        bank.showAccounts();
        enter();
    }

    public void showOneAccount(Bank bank) {
        String iban = askIban();
        Account account = bank.findAccount(iban);
        if (account == null) {
            System.out.println("No existe la cuenta");
        } else {
            account.showInfo();
        }
        enter();
    }

    public void showAccountsClient(Bank bank) {
        String nif = askNif();
        bank.findAccountsClient(nif);
        enter();
    }

    public void deposit(Bank bank) {
        String iban = askIban();
        System.out.println("Cuanto desdea ingresar?");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        Account account = bank.findAccount(iban);
        if (account == null) {
            System.out.println("No existe la cuenta");
        } else {
            account.deposit(amount);
            account.showInfo();
        }
        enter();
    }

    public void withdraw(Bank bank) {
        String iban = askIban();
        System.out.println("Cuanto desdea retirar?");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        Account account = bank.findAccount(iban);
        if (account == null) {
            System.out.println("No existe la cuenta");
        } else {
            account.withdraw(amount);
            account.showInfo();
        }
        enter();
    }

    public void numberAccounts(Bank bank) {
        String nif = askNif();
        int number = bank.findNumberAccount(nif);
        System.out.println("El cliente " + nif + " tiene " + number + " cuentas");
        enter();
    }

    public void showClient(Bank bank) {
        Client client = bank.findClient(askIban());
        client.showInfo();
        enter();
    }

    public void transference(Bank bank) {
        System.out.println("A quien vas a depositar");
        String iban1 = askIban();
        System.out.println("A quien vas ingresar");
        String iban2 = askIban();
        System.out.println("Cuanto desdea ingresar?");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        bank.transference(iban1, iban2, amount);
        enter();
    }

    public String askNif() {
        System.out.println("Introduzca su nif");
        return scanner.nextLine();
    }

    public String askIban() {
        System.out.println("Introduzca un iban");
        return scanner.nextLine();
    }

    public void enter() {
        System.out.println();
        System.out.print("Enter para continuar....");
        scanner.nextLine();
    }
}

