package abstraction.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class HomeApplianceEnergyReport {

    static final double RATE_PER_UNIT = 8;

    interface SaverMode {
        default double applySaver(double units) {
            return units * 0.75;
        }
    }

    static abstract class Appliance {
        String name;

        Appliance(String name) {
            this.name = name;
        }

        abstract double powerWatts();

        double units(double hours) {
            return powerWatts() * hours / 1000;
        }
    }

    static class Fridge extends Appliance {
        Fridge() {
            super("FRIDGE");
        }

        double powerWatts() {
            return 150;
        }
    }

    static class AirConditioner extends Appliance implements SaverMode {
        AirConditioner() {
            super("AC");
        }

        double powerWatts() {
            return 1500;
        }
    }

    static class Tv extends Appliance {
        Tv() {
            super("TV");
        }

        double powerWatts() {
            return 100;
        }
    }

    static class WashingMachine extends Appliance implements SaverMode {
        WashingMachine() {
            super("WASHER");
        }

        double powerWatts() {
            return 500;
        }
    }

    static Appliance create(String type) {
        switch (type) {
            case "FRIDGE": return new Fridge();
            case "AC": return new AirConditioner();
            case "TV": return new Tv();
            case "WASHER": return new WashingMachine();
            default: throw new IllegalArgumentException("Unknown appliance: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            Appliance a = create(parts[0]);
            double hours = Double.parseDouble(parts[1]);
            boolean saver = parts.length > 2 && parts[2].equals("SAVER");
            double units = a.units(hours);
            if (saver) {
                if (!(a instanceof SaverMode)) {
                    System.out.println(a.name + ": saver mode not supported");
                    continue;
                }
                units = ((SaverMode) a).applySaver(units);
            }
            double cost = units * RATE_PER_UNIT;
            total += cost;
            System.out.println(String.format(Locale.US, "%s: Units=%.2f Cost=%.2f", a.name, units, cost));
        }
        System.out.println(String.format(Locale.US, "Total Cost: %.2f", total));
    }
}
