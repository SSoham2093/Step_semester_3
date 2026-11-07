package searching_sorting.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PairSumSorted {

    // Two pointers: Time O(n), Space O(1). (Ignoring the sorted order: O(n^2) brute force, or O(n) time with O(n) hash set.)
    static int[] pairSumSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) return new int[]{nums[left], nums[right]};
            if (sum < target) left++;
            else right--;
        }
        return null;
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
            int[] pair = pairSumSorted(nums, Integer.parseInt(t.group(1)));
            System.out.println(pair == null ? "Not Found" : "(" + pair[0] + ", " + pair[1] + ")");
        }
    }
}
