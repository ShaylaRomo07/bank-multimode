package org.ies.tierno;


import java.util.Scanner;

public class BankApp1 {

    private final Scanner scanner;
    private final BankReader bankReader;

    public BankApp1(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {
        Bank bank = bankReader.read();
        String iban1 = "ES0001";
        String iban2 = "ES0002";
        if (bank.findAccount(iban1) == null) {
            System.out.println("La cuenta no existe");
        } else {
            bank.depositAccount(iban1, 500);
        }
        if (bank.findAccount(iban2) == null) {
            System.out.println("La cuenta no existe");
        } else {
            bank.findAccount(iban2).withdraw(30);
        }
        bank.findAccount(iban1).showInfo();
        bank.findAccount(iban2).showInfo();
        boolean done = bank.transference(iban1, iban2, 500);
        if (done) {
            System.out.println("Transferencia realizada con exito");
        } else {
            System.out.println("Ha habido algun fallo");
        }

    }
}
