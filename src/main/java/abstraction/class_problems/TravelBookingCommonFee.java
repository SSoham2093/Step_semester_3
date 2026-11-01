package abstraction.class_problems;

import java.util.Locale;
import java.util.Scanner;

public class TravelBookingCommonFee {

    static abstract class Booking {
        static final double BOOKING_FEE = 50;

        String mode;
        double distanceKm;

        Booking(String mode, double distanceKm) {
            this.mode = mode;
            this.distanceKm = distanceKm;
        }

        abstract double baseFare();

        final double total() {
            return baseFare() + BOOKING_FEE;
        }
    }

    static class BusBooking extends Booking {
        BusBooking(double distanceKm) {
            super("BUS", distanceKm);
        }

        double baseFare() {
            return 2.0 * distanceKm;
        }
    }

    static class TrainBooking extends Booking {
        TrainBooking(double distanceKm) {
            super("TRAIN", distanceKm);
        }

        double baseFare() {
            return 1.5 * distanceKm;
        }
    }

    static class FlightBooking extends Booking {
        FlightBooking(double distanceKm) {
            super("FLIGHT", distanceKm);
        }

        double baseFare() {
            return 2500 + 4.0 * distanceKm;
        }
    }

    static Booking create(String mode, double distanceKm) {
        switch (mode) {
            case "BUS": return new BusBooking(distanceKm);
            case "TRAIN": return new TrainBooking(distanceKm);
            case "FLIGHT": return new FlightBooking(distanceKm);
            default: throw new IllegalArgumentException("Unknown mode: " + mode);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Booking b = create(sc.next(), sc.nextDouble());
            System.out.println(String.format(Locale.US, "%s: %.2f", b.mode, b.total()));
        }
    }
}
