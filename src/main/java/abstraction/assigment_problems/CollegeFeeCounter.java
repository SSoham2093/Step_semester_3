package abstraction.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class CollegeFeeCounter {

    interface BusUser {
        double TRANSPORT_FEE = 12000;
    }

    static abstract class Student {
        String name;

        Student(String name) {
            this.name = name;
        }

        abstract double baseFee();

        double totalFee() {
            return baseFee() + (this instanceof BusUser ? BusUser.TRANSPORT_FEE : 0);
        }
    }

    static class DayScholar extends Student implements BusUser {
        DayScholar(String name) {
            super(name);
        }

        double baseFee() {
            return 40000;
        }
    }

    static class Hosteller extends Student {
        Hosteller(String name) {
            super(name);
        }

        double baseFee() {
            return 40000 + 60000;
        }
    }

    static class ScholarshipStudent extends Student implements BusUser {
        ScholarshipStudent(String name) {
            super(name);
        }

        double baseFee() {
            return 40000 / 2;
        }
    }

    static Student create(String type, String name) {
        switch (type) {
            case "DAY_SCHOLAR": return new DayScholar(name);
            case "HOSTELLER": return new Hosteller(name);
            case "SCHOLAR": return new ScholarshipStudent(name);
            default: throw new IllegalArgumentException("Unknown student type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            Student s = create(sc.next(), sc.next());
            double fee = s.totalFee();
            total += fee;
            System.out.println(String.format(Locale.US, "%s: %.2f", s.name, fee));
        }
        System.out.println(String.format(Locale.US, "Total Collected: %.2f", total));
    }
}
