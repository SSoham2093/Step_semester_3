package array.class_problems;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int lo = i + 1, hi = n - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                    lo++;
                    hi--;
                } else if (sum < 0) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        int[] b = {0, 0, 0};
        System.out.println(threeSum(a));
        System.out.println(threeSum(b));
    }
}