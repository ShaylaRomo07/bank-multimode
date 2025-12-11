package org.ies.tierno;

import java.util.Scanner;

public class AccountReader {
    private final Scanner scanner;
    private final ClientReader clientReader;

    public AccountReader(Scanner scanner, ClientReader clientReader) {
        this.scanner = scanner;
        this.clientReader = clientReader;
    }

    public Account read() {
        System.out.println("Informacion de la cuenta:");
        System.out.println("IBAN");
        String iban = scanner.nextLine();
        System.out.println("Saldo");
        double balance = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Quien es el dueño de esta cuenta?");
        Client client = clientReader.read();
        return new Account(iban, balance, client);
    }
}
