package abstraction.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class MovieTicketCounter {

    static abstract class Ticket {
        static final double CONVENIENCE_FEE = 20;

        String seat;
        int count;

        Ticket(String seat, int count) {
            this.seat = seat;
            this.count = count;
        }

        abstract double price();

        final double amount() {
            return count * (price() + CONVENIENCE_FEE);
        }
    }

    static class RegularTicket extends Ticket {
        RegularTicket(int count) {
            super("REGULAR", count);
        }

        double price() {
            return 150;
        }
    }

    static class PremiumTicket extends Ticket {
        PremiumTicket(int count) {
            super("PREMIUM", count);
        }

        double price() {
            return 250;
        }
    }

    static class ReclinerTicket extends Ticket {
        ReclinerTicket(int count) {
            super("RECLINER", count);
        }

        double price() {
            return 400;
        }
    }

    static Ticket create(String seat, int count) {
        switch (seat) {
            case "REGULAR": return new RegularTicket(count);
            case "PREMIUM": return new PremiumTicket(count);
            case "RECLINER": return new ReclinerTicket(count);
            default: throw new IllegalArgumentException("Unknown seat type: " + seat);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            Ticket t = create(sc.next(), sc.nextInt());
            double amount = t.amount();
            total += amount;
            System.out.println(String.format(Locale.US, "%s: %.2f", t.seat, amount));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
