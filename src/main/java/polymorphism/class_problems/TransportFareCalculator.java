package polymorphism.class_problems;

import java.util.Locale;
import java.util.Scanner;

public class TransportFareCalculator {

    static abstract class Journey {
        String type;
        double distance;

        Journey(String type, double distance) {
            this.type = type;
            this.distance = distance;
        }

        abstract double fare();
    }

    static class BusJourney extends Journey {
        BusJourney(double distance) {
            super("BUS", distance);
        }

        double fare() {
            return Math.min(2 + 0.10 * distance, 10);
        }
    }

    static class TrainJourney extends Journey {
        TrainJourney(double distance) {
            super("TRAIN", distance);
        }

        double fare() {
            return 3 + 0.15 * distance;
        }
    }

    static class MetroJourney extends Journey {
        double peakHourFactor;

        MetroJourney(double distance, double peakHourFactor) {
            super("METRO", distance);
            this.peakHourFactor = peakHourFactor;
        }

        double fare() {
            return (1.50 + 0.20 * distance) * peakHourFactor;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            Journey j;
            switch (type) {
                case "BUS": j = new BusJourney(distance); break;
                case "TRAIN": j = new TrainJourney(distance); break;
                case "METRO": j = new MetroJourney(distance, sc.nextDouble()); break;
                default: throw new IllegalArgumentException("Unknown transport type: " + type);
            }
            double fare = j.fare();
            total += fare;
            System.out.println(String.format(Locale.US, "%s: %.2f", j.type, fare));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
