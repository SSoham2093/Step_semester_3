package java_basics.class_problems;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentResultCard {

    static class Student {
        String name;
        int[] marks;

        Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        double average() {
            int sum = 0;
            for (int m : marks) {
                sum += m;
            }
            return (double) sum / marks.length;
        }

        char grade() {
            double avg = average();
            if (avg >= 90) return 'A';
            else if (avg >= 75) return 'B';
            else if (avg >= 60) return 'C';
            else if (avg >= 40) return 'D';
            else return 'F';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String name = line.substring(0, line.indexOf('[')).trim();
            int[] marks = new int[3];
            Matcher m = Pattern.compile("\\d+").matcher(line.substring(line.indexOf('[')));
            for (int i = 0; i < marks.length && m.find(); i++) {
                marks[i] = Integer.parseInt(m.group());
            }
            Student s = new Student(name, marks);
            System.out.println(String.format(Locale.US, "%s: Average %.1f, Grade %c", s.name.toUpperCase(), s.average(), s.grade()));
        }
    }
}
