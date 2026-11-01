package polymorphism.class_problems;

import java.util.Locale;
import java.util.Scanner;

public class PaymentFeeCalculator {

    static abstract class Payment {
        String type;
        double amount;

        Payment(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }

        abstract double finalAmount();
    }

    static class CardPayment extends Payment {
        CardPayment(double amount) {
            super("CARD", amount);
        }

        double finalAmount() {
            return amount * 1.02;
        }
    }

    static class WalletPayment extends Payment {
        WalletPayment(double amount) {
            super("WALLET", amount);
        }

        double finalAmount() {
            return amount * 1.01;
        }
    }

    static class BankTransferPayment extends Payment {
        BankTransferPayment(double amount) {
            super("BANKTRANSFER", amount);
        }

        double finalAmount() {
            return amount;
        }
    }

    static Payment create(String type, double amount) {
        switch (type) {
            case "CARD": return new CardPayment(amount);
            case "WALLET": return new WalletPayment(amount);
            case "BANKTRANSFER": return new BankTransferPayment(amount);
            default: throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            Payment p = create(sc.next(), sc.nextDouble());
            double amount = p.finalAmount();
            total += amount;
            System.out.println(String.format(Locale.US, "%s: %.2f", p.type, amount));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
