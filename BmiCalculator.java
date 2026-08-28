import java.util.Random;

public class BmiCalculator {

    public static void main(String[] args) {
        int teamSize = 10;

        double[] heights = new double[teamSize]; 
        double[] weights = new double[teamSize]; 

        generateRandomTeamData(heights, weights);

        printWellnessReport(heights, weights);
    }

    private static void generateRandomTeamData(double[] heights, double[] weights) {
        Random random = new Random();

        for (int i = 0; i < heights.length; i++) {
            heights[i] = round(1.50 + random.nextDouble() * (1.95 - 1.50), 2);
            weights[i] = round(50 + random.nextDouble() * (100 - 50), 1);
        }
    }

    private static double round(double value, int decimalPlaces) {
        double factor = Math.pow(10, decimalPlaces);
        return Math.round(value * factor) / factor;
    }

    public static double calculateBmi(double heightMeters, double weightKg) {
        return weightKg / (heightMeters * heightMeters);
    }

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("=====================================================================");
        System.out.printf("%-10s%-14s%-14s%-10s%-15s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("=====================================================================");

        for (int i = 0; i < heights.length; i++) {
            double bmi = calculateBmi(heights[i], weights[i]);
            String status = getBmiStatus(bmi);

            System.out.printf("%-10s%-14.2f%-14.1f%-10.2f%-15s%n",
                    "Person " + (i + 1), heights[i], weights[i], bmi, status);
        }
        System.out.println("=====================================================================");
    }
}