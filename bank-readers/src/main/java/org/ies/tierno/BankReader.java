package org.ies.tierno;

import org.ies.tierno.model.Account;
import org.ies.tierno.model.Bank;

import java.util.Scanner;

public class BankReader {
    private final Scanner scanner;
    private final AccountReader accountReader;

    public BankReader(Scanner scanner, AccountReader accountReader) {
        this.scanner = scanner;
        this.accountReader = accountReader;
    }

    public org.ies.tierno.Bank read() {
        System.out.println("Información del banco");
        System.out.println("Nombre del banco");
        String nameBack = scanner.nextLine();
        System.out.println("Cuantas cuentas tiene");
        int numberOfAccounts = scanner.nextInt();
        scanner.nextLine();
        Account[] accounts = new Account[numberOfAccounts];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = accountReader.read();
        }
        return new Bank(nameBack, accounts);
    }
}
