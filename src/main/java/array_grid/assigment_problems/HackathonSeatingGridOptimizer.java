package array_grid.assigment_problems;

public class HackathonSeatingGridOptimizer {

    private static double rowAverage(int[] row) {
        int sum = 0;
        for (int i = 0; i < row.length; i++) {
            sum += row[i];
        }
        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String result = avg < threshold ? "Quiet Zone" : "Buzzing Zone";
            if (i > 0) sb.append(" | ");
            sb.append("Row ").append(i).append(": ").append(result);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] seatingScores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        System.out.println(classifyRows(seatingScores, 60));
    }
}