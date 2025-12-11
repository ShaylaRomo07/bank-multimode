package org.ies.tierno;




import java.util.Scanner;

public class BankApp2 {

    private final Scanner scanner;
    private final BankReader bankReader;

    public BankApp2(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {
        Bank bank = bankReader.read();
        bank.showAccounts();
        Account account1 = bank.findAccount("ES0003");
        if (account1 == null) {
            System.out.println("No se encontro la cuenta");
        } else {
            account1.withdraw(50);
        }
        bank.findAccountsClient("000X");
        Account account2 = bank.findAccount("ES0004");
        if (account2 == null) {
            System.out.println("No se encontro la cuenta");
        } else {
            account2.deposit(300);
        }
        Account account3 = bank.findAccount("ES0001");
        if (account3 == null) {
            System.out.println("No se encontro la cuenta");
        } else {
            account3.getClient().showInfo();
        }
    }
}
