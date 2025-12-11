package org.ies.tierno.app;



import org.ies.tierno.Account;
import org.ies.tierno.Bank;
import org.ies.tierno.BankReader;

import java.util.Scanner;

public class BankApp3 {

    private final Scanner scanner;
    private final BankReader bankReader;

    public BankApp3(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {
        Bank bank = bankReader.read();
        Account account = bank.findAccount("ES0001");
        if (account == null) {
            System.out.println("Parece que la cuenta no existe");
        } else {
            account.showInfo();
            bank.transference(account.getIban(), "ES0002", account.getBalance());
            System.out.println("Informacion del banco");
            System.out.println("Nombre: " + bank.getNameBank());
            bank.showAccounts();
        }
    }
}
