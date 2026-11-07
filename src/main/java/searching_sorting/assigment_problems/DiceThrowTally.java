package searching_sorting.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiceThrowTally {

    // Counting sort. Time: O(n + k) with k = 6. Space: O(k) for the counts plus the O(n) result.
    static int[] diceSort(int[] rolls) {
        int[] count = new int[7];
        for (int roll : rolls) {
            count[roll]++;
        }
        StringBuilder line = new StringBuilder("Counts:");
        for (int v = 1; v <= 6; v++) {
            line.append(" ").append(v).append(":").append(count[v]);
        }
        System.out.println(line);

        int[] sorted = new int[rolls.length];
        int index = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sorted[index++] = v;
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern list = Pattern.compile("\\[([^\\]]*)\\]");
        while (sc.hasNextLine()) {
            Matcher l = list.matcher(sc.nextLine());
            if (!l.find()) continue;
            Matcher numbers = Pattern.compile("\\d+").matcher(l.group(1));
            List<Integer> values = new ArrayList<>();
            while (numbers.find()) {
                values.add(Integer.parseInt(numbers.group()));
            }
            int[] rolls = new int[values.size()];
            for (int i = 0; i < rolls.length; i++) {
                rolls[i] = values.get(i);
            }
            System.out.println("Sorted: " + Arrays.toString(diceSort(rolls)));
        }
    }
}
