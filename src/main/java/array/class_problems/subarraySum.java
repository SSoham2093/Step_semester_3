package array.class_problems;

import java.util.*;

public class subarraySum {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int sum = 0, res = 0;
        for (int num : nums) {
            sum += num;
            res += count.getOrDefault(sum - k, 0);
            count.put(sum, count.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1};
        int[] b = {1, -1, 0};
        System.out.println(subarraySum(a, 2));
        System.out.println(subarraySum(b, 0));
    }
}