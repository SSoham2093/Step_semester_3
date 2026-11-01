package polymorphism.assigment_problems;

import java.time.LocalDate;
import java.util.Scanner;

public class StreamingPlanRenewal {

    static abstract class Plan {
        String name;
        LocalDate startDate;

        Plan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        abstract int validityDays();

        LocalDate renewalDate() {
            return startDate.plusDays(validityDays());
        }
    }

    static class BasicPlan extends Plan {
        BasicPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        int validityDays() {
            return 30;
        }
    }

    static class StandardPlan extends Plan {
        StandardPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        int validityDays() {
            return 90;
        }
    }

    static class PremiumPlan extends Plan {
        PremiumPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        int validityDays() {
            return 365;
        }
    }

    static Plan create(String type, String name, LocalDate startDate) {
        switch (type) {
            case "BASIC": return new BasicPlan(name, startDate);
            case "STANDARD": return new StandardPlan(name, startDate);
            case "PREMIUM": return new PremiumPlan(name, startDate);
            default: throw new IllegalArgumentException("Unknown plan type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Plan p = create(sc.next(), sc.next(), LocalDate.parse(sc.next()));
            System.out.println(p.name + ": " + p.renewalDate());
        }
    }
}
