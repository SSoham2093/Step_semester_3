package polymorphism.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class HostelElectricityBill {

    static abstract class Room {
        String type;
        int units;

        Room(String type, int units) {
            this.type = type;
            this.units = units;
        }

        abstract double bill();
    }

    static class SingleRoom extends Room {
        SingleRoom(int units) {
            super("SINGLE", units);
        }

        double bill() {
            return 8.0 * units;
        }
    }

    static class SharedRoom extends Room {
        int occupants;

        SharedRoom(int units, int occupants) {
            super("SHARED", units);
            this.occupants = occupants;
        }

        double bill() {
            return 6.0 * units / occupants;
        }
    }

    static class AcRoom extends Room {
        AcRoom(int units) {
            super("AC", units);
        }

        double bill() {
            return 10.0 * units + 200;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Room r;
            switch (type) {
                case "SINGLE": r = new SingleRoom(units); break;
                case "SHARED": r = new SharedRoom(units, sc.nextInt()); break;
                case "AC": r = new AcRoom(units); break;
                default: throw new IllegalArgumentException("Unknown room type: " + type);
            }
            double bill = r.bill();
            total += bill;
            System.out.println(String.format(Locale.US, "%s: %.2f", r.type, bill));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
