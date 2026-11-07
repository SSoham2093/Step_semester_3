package searching_sorting.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpiralOrderTraversal {

    // Time: O(m * n). Output space: O(m * n); extra space beyond the output: O(1).
    static List<Integer> spiralOrder(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        if (grid.length == 0) return result;
        int top = 0;
        int bottom = grid.length - 1;
        int left = 0;
        int right = grid[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) result.add(grid[top][j]);
            top++;
            for (int i = top; i <= bottom; i++) result.add(grid[i][right]);
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) result.add(grid[bottom][j]);
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) result.add(grid[i][left]);
                left++;
            }
        }
        return result;
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
            Matcher numbers = Pattern.compile("-?\\d+").matcher(chunk);
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
        System.out.println(spiralOrder(grid));
    }
}
