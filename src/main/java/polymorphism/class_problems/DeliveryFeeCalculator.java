package polymorphism.class_problems;

import java.util.Locale;
import java.util.Scanner;

public class DeliveryFeeCalculator {

    static abstract class Delivery {
        String type;
        double weight;
        double distance;

        Delivery(String type, double weight, double distance) {
            this.type = type;
            this.weight = weight;
            this.distance = distance;
        }

        abstract double fee();
    }

    static class StandardDelivery extends Delivery {
        StandardDelivery(double weight, double distance) {
            super("STANDARD", weight, distance);
        }

        double fee() {
            return 5 + 0.50 * weight + 0.10 * distance;
        }
    }

    static class ExpressDelivery extends Delivery {
        ExpressDelivery(double weight, double distance) {
            super("EXPRESS", weight, distance);
        }

        double fee() {
            return 15 + 1.00 * weight + 0.20 * distance;
        }
    }

    static class InternationalDelivery extends Delivery {
        double customsFee;

        InternationalDelivery(double weight, double distance, double customsFee) {
            super("INTERNATIONAL", weight, distance);
            this.customsFee = customsFee;
        }

        double fee() {
            return 25 + 2.00 * weight + 0.50 * distance + customsFee;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            Delivery d;
            switch (type) {
                case "STANDARD": d = new StandardDelivery(weight, distance); break;
                case "EXPRESS": d = new ExpressDelivery(weight, distance); break;
                case "INTERNATIONAL": d = new InternationalDelivery(weight, distance, sc.nextDouble()); break;
                default: throw new IllegalArgumentException("Unknown delivery type: " + type);
            }
            double fee = d.fee();
            total += fee;
            System.out.println(String.format(Locale.US, "%s: %.2f", d.type, fee));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
