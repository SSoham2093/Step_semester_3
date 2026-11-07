package searching_sorting.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueueOrderCheck {

    // Time: O(n), single pass. Space: O(1).
    static int firstBreak(int[] tokens) {
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) return i;
        }
        return -1;
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
            int[] tokens = new int[values.size()];
            for (int i = 0; i < tokens.length; i++) {
                tokens[i] = values.get(i);
            }
            System.out.println(firstBreak(tokens));
        }
    }
}
