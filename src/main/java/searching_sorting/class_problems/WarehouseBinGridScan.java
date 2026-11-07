package searching_sorting.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WarehouseBinGridScan {

    // Time: O(m * n). Additional space: O(1).
    static int[] warehouseSummary(int[][] grid) {
        int total = 0;
        int maxValue = -1;
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
                if (grid[i][j] > maxValue) {
                    maxValue = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        return new int[]{total, maxRow, maxCol};
    }

    static List<int[]> parseRows(String text) {
        List<String> chunks = new ArrayList<>();
        Matcher brackets = Pattern.compile("\\[([^\\[\\]]+)\\]").matcher(text);
        while (brackets.find()) {
            chunks.add(brackets.group(1));
        }
        if (chunks.isEmpty()) {
            for (String line : text.split("\\R")) {
                if (!line.trim().isEmpty()) chunks.add(line);
            }
        }
        List<int[]> rows = new ArrayList<>();
        for (String chunk : chunks) {
            Matcher numbers = Pattern.compile("\\d+").matcher(chunk);
            List<Integer> values = new ArrayList<>();
            while (numbers.find()) {
                values.add(Integer.parseInt(numbers.group()));
            }
            int[] row = new int[values.size()];
            for (int i = 0; i < row.length; i++) {
                row[i] = values.get(i);
            }
            rows.add(row);
        }
        return rows;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\\A");
        int[][] grid = parseRows(sc.hasNext() ? sc.next() : "").toArray(new int[0][]);
        int[] result = warehouseSummary(grid);
        System.out.println("total = " + result[0] + ", maxCoordinate = (" + result[1] + ", " + result[2] + ")");
    }
}
