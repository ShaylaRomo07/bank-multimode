package org.ies.tierno;

import org.ies.tierno.model.Client;

import java.util.Scanner;

public class ClientReader {
    private final Scanner scanner;

    public ClientReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Client read() {
        System.out.println("Informacion del cliente");
//        scanner.nextLine();
        System.out.println("Cual es su nif");
        String nif = scanner.nextLine();
        System.out.println("Nombre/s:");
        String name = scanner.nextLine();
        System.out.println("Apellidos");
        String surname = scanner.nextLine();
        return new Client(nif, name, surname);
    }
}
