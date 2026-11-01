package polymorphism.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class CampusParkingCharge {

    static abstract class Vehicle {
        String type;
        int hours;

        Vehicle(String type, int hours) {
            this.type = type;
            this.hours = hours;
        }

        abstract double charge();
    }

    static class Bike extends Vehicle {
        Bike(int hours) {
            super("BIKE", hours);
        }

        double charge() {
            return 10 * hours;
        }
    }

    static class Car extends Vehicle {
        Car(int hours) {
            super("CAR", hours);
        }

        double charge() {
            return 30 + 20 * (hours - 1);
        }
    }

    static class Truck extends Vehicle {
        Truck(int hours) {
            super("TRUCK", hours);
        }

        double charge() {
            return Math.max(50 * hours, 100);
        }
    }

    static Vehicle create(String type, int hours) {
        switch (type) {
            case "BIKE": return new Bike(hours);
            case "CAR": return new Car(hours);
            case "TRUCK": return new Truck(hours);
            default: throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            Vehicle v = create(sc.next(), sc.nextInt());
            double charge = v.charge();
            total += charge;
            System.out.println(String.format(Locale.US, "%s: %.2f", v.type, charge));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
