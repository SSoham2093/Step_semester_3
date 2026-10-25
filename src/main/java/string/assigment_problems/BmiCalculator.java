package string.assigment_problems;

import java.util.*;

public class BmiCalculator {
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.println((i + 1) + " | " + heights[i] + " | " + weights[i] + " | " +
                    Math.round(bmi * 100.0) / 100.0 + " | " + getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int n = 10;
        double[] heights = new double[n];
        double[] weights = new double[n];
        for (int i = 0; i < n; i++) {
            heights[i] = Math.round((1.5 + rand.nextDouble() * 0.5) * 100.0) / 100.0;
            weights[i] = 50 + rand.nextInt(50);
        }
        printWellnessReport(heights, weights);
    }
}