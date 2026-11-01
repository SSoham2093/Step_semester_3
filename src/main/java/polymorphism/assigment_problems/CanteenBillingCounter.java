package polymorphism.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class CanteenBillingCounter {

    static abstract class Customer {
        String type;
        double amount;

        Customer(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }

        abstract double finalAmount();
    }

    static class Student extends Customer {
        Student(double amount) {
            super("STUDENT", amount);
        }

        double finalAmount() {
            return amount * 0.90;
        }
    }

    static class Staff extends Customer {
        Staff(double amount) {
            super("STAFF", amount);
        }

        double finalAmount() {
            return amount * 0.95;
        }
    }

    static class Guest extends Customer {
        Guest(double amount) {
            super("GUEST", amount);
        }

        double finalAmount() {
            return amount + 10;
        }
    }

    static Customer create(String type, double amount) {
        switch (type) {
            case "STUDENT": return new Student(amount);
            case "STAFF": return new Staff(amount);
            case "GUEST": return new Guest(amount);
            default: throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            Customer c = create(sc.next(), sc.nextDouble());
            double amount = c.finalAmount();
            total += amount;
            System.out.println(String.format(Locale.US, "%s: %.2f", c.type, amount));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
