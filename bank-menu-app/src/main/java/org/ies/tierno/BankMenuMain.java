package org.ies.tierno;


import java.util.Scanner;

public class BankMenuMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClientReader clientReader = new ClientReader(scanner);
        AccountReader accountReader = new AccountReader(scanner, clientReader);
        BankReader bankReader = new BankReader(scanner, accountReader);
        BankMenuApp bankMenuApp = new BankMenuApp(scanner, bankReader);
        bankMenuApp.run();
    }
}
