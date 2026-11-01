package java_basics.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExamScoreBandCounter {

    static int firstAtLeast(int[] scores, int target) {
        int lo = 0;
        int hi = scores.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (scores[mid] >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    static int firstGreater(int[] scores, int target) {
        int lo = 0;
        int hi = scores.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (scores[mid] > target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    // Time: O(log n). Additional space: O(1). (Linear scan: O(n) time, O(1) space.)
    static int countInBand(int[] scores, int low, int high) {
        return firstGreater(scores, high) - firstAtLeast(scores, low);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Matcher m = Pattern.compile("-?\\d+").matcher(sc.nextLine());
        List<Integer> values = new ArrayList<>();
        while (m.find()) {
            values.add(Integer.parseInt(m.group()));
        }
        int[] scores = new int[values.size()];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = values.get(i);
        }
        int low = sc.nextInt();
        int high = sc.nextInt();
        System.out.println(countInBand(scores, low, high));
    }
}
