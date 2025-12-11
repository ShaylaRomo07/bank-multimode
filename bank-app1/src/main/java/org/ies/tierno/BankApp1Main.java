package org.ies.tierno;

import org.ies.tierno.app.BankApp1;

import java.util.Scanner;

public class BankApp1Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClientReader clientReader = new ClientReader(scanner);
        AccountReader accountReader = new AccountReader(scanner, clientReader);
        BankReader bankReader = new BankReader(scanner, accountReader);
        var bankApp = new BankApp1(scanner, bankReader);
        bankApp.run();
    }
}
