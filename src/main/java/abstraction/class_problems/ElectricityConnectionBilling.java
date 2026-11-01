package abstraction.class_problems;

import java.util.Locale;
import java.util.Scanner;

public class ElectricityConnectionBilling {

    static abstract class Connection {
        String type;
        int units;

        Connection(String type, int units) {
            this.type = type;
            this.units = units;
        }

        abstract double bill();
    }

    static class HomeConnection extends Connection {
        HomeConnection(int units) {
            super("HOME", units);
        }

        double bill() {
            if (units <= 100) return 5.0 * units;
            return 5.0 * 100 + 7.0 * (units - 100);
        }
    }

    static class ShopConnection extends Connection {
        ShopConnection(int units) {
            super("SHOP", units);
        }

        double bill() {
            return 8.0 * units + 100;
        }
    }

    static class FactoryConnection extends Connection {
        FactoryConnection(int units) {
            super("FACTORY", units);
        }

        double bill() {
            return Math.max(6.0 * units, 1000);
        }
    }

    static Connection create(String type, int units) {
        switch (type) {
            case "HOME": return new HomeConnection(units);
            case "SHOP": return new ShopConnection(units);
            case "FACTORY": return new FactoryConnection(units);
            default: throw new IllegalArgumentException("Unknown connection type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            Connection c = create(sc.next(), sc.nextInt());
            double bill = c.bill();
            total += bill;
            System.out.println(String.format(Locale.US, "%s: %.2f", c.type, bill));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
