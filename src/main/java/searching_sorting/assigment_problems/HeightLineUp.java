package searching_sorting.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HeightLineUp {

    // Bubble sort. Time: O(n^2) worst case, O(n) if already sorted. Space: O(1).
    static void lineUp(int[] heights) {
        int n = heights.length;
        for (int pass = 1; pass <= n - 1; pass++) {
            boolean swapped = false;
            for (int j = 0; j < n - pass; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern list = Pattern.compile("\\[([^\\]]*)\\]");
        while (sc.hasNextLine()) {
            Matcher l = list.matcher(sc.nextLine());
            if (!l.find()) continue;
            Matcher numbers = Pattern.compile("-?\\d+").matcher(l.group(1));
            List<Integer> values = new ArrayList<>();
            while (numbers.find()) {
                values.add(Integer.parseInt(numbers.group()));
            }
            int[] heights = new int[values.size()];
            for (int i = 0; i < heights.length; i++) {
                heights[i] = values.get(i);
            }
            lineUp(heights);
        }
    }
}
