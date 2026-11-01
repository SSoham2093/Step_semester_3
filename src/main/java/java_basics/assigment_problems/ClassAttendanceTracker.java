package java_basics.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassAttendanceTracker {

    // Time: O(n), single pass. Additional space: O(1).
    static int[] attendanceSummary(int[] days) {
        int present = 0;
        int longest = 0;
        int current = 0;
        for (int day : days) {
            if (day == 1) {
                present++;
                current++;
                if (current > longest) longest = current;
            } else {
                current = 0;
            }
        }
        return new int[]{present, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\\A");
        String text = sc.hasNext() ? sc.next() : "";
        List<Integer> values = new ArrayList<>();
        Matcher m = Pattern.compile("\\d+").matcher(text);
        while (m.find()) {
            values.add(Integer.parseInt(m.group()));
        }
        int[] days = new int[values.size()];
        for (int i = 0; i < days.length; i++) {
            days[i] = values.get(i);
        }
        int[] result = attendanceSummary(days);
        System.out.println("Present: " + result[0] + ", Longest streak: " + result[1]);
    }
}
