package linked_list.class_problems;

import java.math.BigDecimal;
import java.util.Scanner;

public class PaymentProcessing {

    interface PaymentMode {
        double processPayment(double amount);

        double getFee();

        String getName();
    }

    static class CashPayment implements PaymentMode {
        private double fee;

        public double processPayment(double amount) {
            fee = 0;
            return amount + fee;
        }

        public double getFee() {
            return fee;
        }

        public String getName() {
            return "Cash";
        }
    }

    static class CardPayment implements PaymentMode {
        private double fee;

        public double processPayment(double amount) {
            fee = amount * 0.02;
            return amount + fee;
        }

        public double getFee() {
            return fee;
        }

        public String getName() {
            return "Card";
        }
    }

    static class UpiPayment implements PaymentMode {
        private double fee;

        public double processPayment(double amount) {
            fee = 0;
            return amount + fee;
        }

        public double getFee() {
            return fee;
        }

        public String getName() {
            return "UPI";
        }
    }

    static String num(double d) {
        BigDecimal b = BigDecimal.valueOf(d);
        if (b.scale() < 1) b = b.setScale(1);
        return b.toPlainString();
    }

    static PaymentMode create(String mode) {
        switch (mode.toLowerCase()) {
            case "card": return new CardPayment();
            case "upi": return new UpiPayment();
            default: return new CashPayment();
        }
    }

    // Time: O(n), one processPayment call per payment. Space: O(n) for the array.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PaymentMode[] payments = new PaymentMode[n];
        double[] amounts = new double[n];
        for (int i = 0; i < n; i++) {
            payments[i] = create(sc.next());
            amounts[i] = sc.nextDouble();
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double processed = payments[i].processPayment(amounts[i]);
            System.out.println(payments[i].getName() + ": amount " + num(amounts[i])
                    + ", fee " + num(payments[i].getFee()) + ", processed " + num(processed));
            total += processed;
        }
        System.out.println("Total Amount Processed: " + num(total));
    }
}
