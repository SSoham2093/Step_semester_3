package abstraction.class_problems;

import java.util.Locale;
import java.util.Scanner;

public class LibraryLateFineCounter {

    static abstract class LibraryItem {
        String title;
        int daysLate;

        LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        abstract double fine();
    }

    static class Book extends LibraryItem {
        Book(String title, int daysLate) {
            super(title, daysLate);
        }

        double fine() {
            return 2.0 * daysLate;
        }
    }

    static class Dvd extends LibraryItem {
        Dvd(String title, int daysLate) {
            super(title, daysLate);
        }

        double fine() {
            return Math.min(5.0 * daysLate, 50);
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title, int daysLate) {
            super(title, daysLate);
        }

        double fine() {
            return 1.0 * daysLate;
        }
    }

    static LibraryItem create(String type, String title, int daysLate) {
        switch (type) {
            case "BOOK": return new Book(title, daysLate);
            case "DVD": return new Dvd(title, daysLate);
            case "MAGAZINE": return new Magazine(title, daysLate);
            default: throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            LibraryItem item = create(sc.next(), sc.next(), sc.nextInt());
            double fine = item.fine();
            total += fine;
            System.out.println(String.format(Locale.US, "%s: %.2f", item.title, fine));
        }
        System.out.println(String.format(Locale.US, "Total Fines: %.2f", total));
    }
}
