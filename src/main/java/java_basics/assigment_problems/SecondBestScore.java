package java_basics.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondBestScore {

    // Time: O(n), single pass. Additional space: O(1).
    static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;
        for (int s : scores) {
            if (s > highest) {
                second = highest;
                highest = s;
            } else if (s < highest && s > second) {
                second = s;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\\A");
        String text = sc.hasNext() ? sc.next() : "";
        List<Integer> values = new ArrayList<>();
        Matcher m = Pattern.compile("\\d+").matcher(text);
        while (m.find()) {
            values.add(Integer.parseInt(m.group()));
        }
        int[] scores = new int[values.size()];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = values.get(i);
        }
        System.out.println(secondHighest(scores));
    }
}
