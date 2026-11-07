package searching_sorting.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchInsertPosition {

    // Binary search: Time O(log n), Space O(1).
    static int searchInsertPosition(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
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
            System.out.println(searchInsertPosition(nums, Integer.parseInt(t.group(1))));
        }
    }
}
