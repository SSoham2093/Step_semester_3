package abstraction.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class ParcelShippingDesk {

    interface Insurable {
        double declaredValue();

        default double insurance() {
            return declaredValue() * 0.02;
        }
    }

    static abstract class Parcel {
        String type;
        double weightKg;
        double declaredValue;

        Parcel(String type, double weightKg, double declaredValue) {
            this.type = type;
            this.weightKg = weightKg;
            this.declaredValue = declaredValue;
        }

        public double declaredValue() {
            return declaredValue;
        }

        double standardCharge() {
            return 40 + 10 * weightKg;
        }

        abstract double charge();
    }

    static class StandardParcel extends Parcel {
        StandardParcel(double weightKg, double declaredValue) {
            super("STANDARD", weightKg, declaredValue);
        }

        double charge() {
            return standardCharge();
        }
    }

    static class ExpressParcel extends Parcel implements Insurable {
        ExpressParcel(double weightKg, double declaredValue) {
            super("EXPRESS", weightKg, declaredValue);
        }

        double charge() {
            return 80 + 15 * weightKg;
        }
    }

    static class FragileParcel extends Parcel implements Insurable {
        FragileParcel(double weightKg, double declaredValue) {
            super("FRAGILE", weightKg, declaredValue);
        }

        double charge() {
            return standardCharge() + 50;
        }
    }

    static Parcel create(String type, double weightKg, double declaredValue) {
        switch (type) {
            case "STANDARD": return new StandardParcel(weightKg, declaredValue);
            case "EXPRESS": return new ExpressParcel(weightKg, declaredValue);
            case "FRAGILE": return new FragileParcel(weightKg, declaredValue);
            default: throw new IllegalArgumentException("Unknown parcel type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            Parcel p = create(sc.next(), sc.nextDouble(), sc.nextDouble());
            double charge = p.charge();
            double insurance = (p instanceof Insurable) ? ((Insurable) p).insurance() : 0;
            double total = charge + insurance;
            grandTotal += total;
            System.out.println(String.format(Locale.US, "%s: Charge=%.2f Insurance=%.2f Total=%.2f", p.type, charge, insurance, total));
        }
        System.out.println(String.format(Locale.US, "Grand Total: %.2f", grandTotal));
    }
}
