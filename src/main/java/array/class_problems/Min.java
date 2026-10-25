package array.class_problems;

public class Min {
    public static int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 5, 1, 2};
        int[] b = {4, 5, 6, 7, 0, 1, 2};
        int[] c = {11, 13, 15, 17};
        System.out.println(findMin(a));
        System.out.println(findMin(b));
        System.out.println(findMin(c));
    }
}