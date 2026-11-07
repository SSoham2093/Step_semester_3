package searching_sorting.class_problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PairWithTargetSum {

    // Approach 1 (hash set): Time O(n), Space O(n).
    static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int x : nums) {
            if (seen.contains(target - x)) return true;
            seen.add(x);
        }
        return false;
    }

    // Approach 2 (brute force): Time O(n^2), Space O(1).
    static boolean hasPairBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern list = Pattern.compile("\\[([^\\]]*)\\]");
        Pattern target = Pattern.compile("target\\s*=\\s*(-?\\d+)");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Matcher l = list.matcher(line);
            Matcher t = target.matcher(line);
            if (!l.find() || !t.find()) continue;
            Matcher numbers = Pattern.compile("-?\\d+").matcher(l.group(1));
            List<Integer> values = new ArrayList<>();
            while (numbers.find()) {
                values.add(Integer.parseInt(numbers.group()));
            }
            int[] nums = new int[values.size()];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = values.get(i);
            }
            System.out.println(hasPairWithSum(nums, Integer.parseInt(t.group(1))));
        }
    }
}
