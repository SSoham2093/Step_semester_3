package linked_list.class_problems;

import java.util.Locale;
import java.util.Scanner;

public class ClassReportCard {

    static class Student {
        private final String name;
        private int m1, m2, m3;

        Student(String name) {
            this.name = name;
        }

        boolean setMarks(int a, int b, int c) {
            if (!valid(a) || !valid(b) || !valid(c)) return false;
            m1 = a;
            m2 = b;
            m3 = c;
            return true;
        }

        private static boolean valid(int m) {
            return m >= 0 && m <= 100;
        }

        String getName() {
            return name;
        }

        int total() {
            return m1 + m2 + m3;
        }

        double average() {
            return total() / 3.0;
        }

        String grade() {
            double avg = average();
            if (avg >= 80) return "A";
            if (avg >= 70) return "B";
            if (avg >= 60) return "C";
            if (avg >= 40) return "D";
            return "F";
        }

        @Override
        public String toString() {
            return name + " total=" + total()
                    + " avg=" + String.format(Locale.US, "%.2f", average())
                    + " grade=" + grade();
        }
    }

    // Bubble sort, highest total first, stops when a pass makes no swap.
    // Returns the number of passes that made a swap.
    // Time: O(n) best case (already sorted), O(n^2) worst case. Space: O(1).
    static int sort(Student[] s, int count) {
        int passes = 0;
        for (int pass = 1; pass < count; pass++) {
            boolean swapped = false;
            for (int j = 0; j < count - pass; j++) {
                if (s[j].total() < s[j + 1].total()) {
                    Student temp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
            passes++;
        }
        return passes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] accepted = new Student[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            Student st = new Student(name);
            if (st.setMarks(sc.nextInt(), sc.nextInt(), sc.nextInt())) {
                accepted[count++] = st;
            } else {
                System.out.println(name + " skipped: marks must be 0 to 100");
            }
        }
        int passes = sort(accepted, count);
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + accepted[i]);
        }
        System.out.println("Sorted in " + passes + " passes");
    }
}
