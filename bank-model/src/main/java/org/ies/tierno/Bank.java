package org.ies.tierno;

import java.util.Arrays;
import java.util.Objects;

public class Bank {
    private String nameBank;
    private Account[] accounts;

    public Bank(String nameBank, Account[] accounts) {
        this.nameBank = nameBank;
        this.accounts = accounts;
    }

    public void showAccounts() {
        for (Account account : accounts) {
            account.showInfo();
        }
    }

    public Account findAccount(String iban) {
        for (Account account : accounts) {
            if (account.getIban().equals(iban)) {
                showAccounts();
                return account;
            }
        }
        return null;
    }

    public void findAccountsClient(String nif) {
        for (Account account : accounts) {
            if (account.getClient().getNif().equals(nif)) {
                account.showInfo();
            }
        }
    }


    public void depositAccount(String iban, double amount) {
        Account account = findAccount(iban);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("No se encuentra la cuenta");
        }
    }

    public int findNumberAccount(String nif) {
        int number = 0;
        for (Account account : accounts) {
            if (account.getClient().getNif().equals(nif)) {
                number++;
            }
        }
        return number;
    }

    public Client findClient(String iban) {
        Account account = findAccount(iban);
        if (account == null) {
            return null;
        } else {
            return account.getClient();
        }
    }

    public boolean transference(String ibanOrigin, String ibanDestination, double amount) {
        var origin = findAccount(ibanOrigin);
        var destination = findAccount(ibanDestination);
        if (origin != null && destination != null) {
            if (origin.getBalance() >= amount) {
                origin.withdraw(amount);
                destination.deposit(amount);
                return true;
            } else {
                System.out.println("No hay suficiente saldo en el origen");
            }
        } else {
            System.out.println("No exista la cuenta de origen o destino");
        }
        return false;
    }
//    public void transference(String iban1, String iban2, double amount) {
//        if (findAccount(iban1) == null) {
//            System.out.println("No se encuentra esta cuenta para retirar");
//        } else if (findAccount(iban2) == null) {
//            System.out.println("No se encuentra esta cuenta para depositar");
//        } else {
//            Account accountWithdraw = findAccount(iban1);
//            Account accountDeposit = findAccount(iban2);
//            double balanceInitial = accountWithdraw.getBalance();
//            double balanceChange = accountWithdraw.withdraw(amount);
//            if (balanceInitial != balanceChange) {
//                accountDeposit.deposit(amount);
//            } else {
//                System.out.println("Parece que hubo un error y no se realizo la operacion");
//            }
//        }
//    }


    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(nameBank, bank.nameBank) && Objects.deepEquals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameBank, Arrays.hashCode(accounts));
    }

    @Override
    public String toString() {
        return "Bank{" +
                "nameBank='" + nameBank + '\'' +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }
}
