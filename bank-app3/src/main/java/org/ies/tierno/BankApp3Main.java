package org.ies.tierno;




import java.util.Scanner;

public class BankApp3Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClientReader clientReader = new ClientReader(scanner);
        AccountReader accountReader = new AccountReader(scanner, clientReader);
        BankReader bankReader = new BankReader(scanner, accountReader);
        var bankApp = new BankApp3(scanner, bankReader);
        bankApp.run();
    }
}
