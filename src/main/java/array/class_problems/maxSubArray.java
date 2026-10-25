package array.class_problems;

public class maxSubArray {
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            max = Math.max(max, cur);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] b = {-3, -1, -2};
        System.out.println(maxSubArray(a));
        System.out.println(maxSubArray(b));
    }
}