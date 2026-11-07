package searching_sorting.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrizeTable {

    // Selection sort (descending). Time: O(n^2) always. Space: O(1). At most n - 1 swaps.
    static int prizeTable(int[] marks) {
        int swaps = 0;
        for (int i = 0; i < marks.length - 1; i++) {
            int largest = i;
            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] > marks[largest]) largest = j;
            }
            if (largest != i) {
                int temp = marks[i];
                marks[i] = marks[largest];
                marks[largest] = temp;
                swaps++;
            }
        }
        return swaps;
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
            int[] marks = new int[values.size()];
            for (int i = 0; i < marks.length; i++) {
                marks[i] = values.get(i);
            }
            int swaps = prizeTable(marks);
            System.out.println(Arrays.toString(marks) + " swaps = " + swaps);
        }
    }
}
