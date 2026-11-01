package abstraction.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class CityCabFareMeter {

    interface NightService {
        double NIGHT_SURCHARGE = 0.20;
    }

    static abstract class Cab {
        static final double MIN_FARE = 100;

        String type;

        Cab(String type) {
            this.type = type;
        }

        abstract double ratePerKm();

        final double fare(double km) {
            return Math.max(km * ratePerKm(), MIN_FARE);
        }
    }

    static class Mini extends Cab {
        Mini() {
            super("MINI");
        }

        double ratePerKm() {
            return 10;
        }
    }

    static class Sedan extends Cab implements NightService {
        Sedan() {
            super("SEDAN");
        }

        double ratePerKm() {
            return 14;
        }
    }

    static class Suv extends Cab implements NightService {
        Suv() {
            super("SUV");
        }

        double ratePerKm() {
            return 18;
        }
    }

    static Cab create(String type) {
        switch (type) {
            case "MINI": return new Mini();
            case "SEDAN": return new Sedan();
            case "SUV": return new Suv();
            default: throw new IllegalArgumentException("Unknown cab type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            Cab cab = create(sc.next());
            double km = sc.nextDouble();
            boolean night = sc.next().equals("NIGHT");
            double fare = cab.fare(km);
            if (night) {
                if (!(cab instanceof NightService)) {
                    System.out.println(cab.type + ": night service not available");
                    continue;
                }
                fare *= 1 + NightService.NIGHT_SURCHARGE;
            }
            total += fare;
            System.out.println(String.format(Locale.US, "%s: %.2f", cab.type, fare));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
