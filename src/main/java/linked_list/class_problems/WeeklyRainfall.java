package linked_list.class_problems;

import java.util.Locale;
import java.util.Scanner;

public class WeeklyRainfall {

    // Time: O(7) = O(1) for a fixed week, O(n) in general. Space: O(1) beyond the input array.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] rain = new double[7];
        for (int i = 0; i < 7; i++) {
            rain[i] = sc.nextDouble();
        }

        double total = 0;
        int wettest = 0;
        int dry = 0;
        StringBuilder line = new StringBuilder("Rainfall (mm):");
        for (int i = 0; i < 7; i++) {
            line.append(" ").append(rain[i]);
            total += rain[i];
            if (rain[i] > rain[wettest]) wettest = i;
            if (rain[i] == 0) dry++;
        }

        System.out.println(line);
        System.out.println();
        System.out.println("Total Rainfall: " + total + " mm");
        System.out.println("Average Rainfall: " + String.format(Locale.US, "%.2f", total / 7) + " mm");
        System.out.println("Wettest Day: Day " + (wettest + 1) + " (" + rain[wettest] + " mm)");
        System.out.println("Total Dry Days: " + dry);
    }
}
