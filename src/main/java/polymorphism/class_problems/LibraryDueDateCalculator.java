package polymorphism.class_problems;

import java.time.LocalDate;
import java.util.Scanner;

public class LibraryDueDateCalculator {

    static final LocalDate TODAY = LocalDate.of(2023, 10, 26);

    static abstract class LibraryItem {
        String title;

        LibraryItem(String title) {
            this.title = title;
        }

        abstract int borrowDays();

        LocalDate dueDate() {
            return TODAY.plusDays(borrowDays());
        }
    }

    static class Book extends LibraryItem {
        Book(String title) {
            super(title);
        }

        int borrowDays() {
            return 14;
        }
    }

    static class Dvd extends LibraryItem {
        Dvd(String title) {
            super(title);
        }

        int borrowDays() {
            return 7;
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title) {
            super(title);
        }

        int borrowDays() {
            return 3;
        }
    }

    static LibraryItem create(String type, String title) {
        switch (type) {
            case "BOOK": return new Book(title);
            case "DVD": return new Dvd(title);
            case "MAGAZINE": return new Magazine(title);
            default: throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim();
            if (title.length() >= 2 && title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }
            LibraryItem item = create(type, title);
            System.out.println(item.title + ": " + item.dueDate());
        }
    }
}
