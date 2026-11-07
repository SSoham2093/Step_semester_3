package searching_sorting.class_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveSortedDuplicates {

    // Two pointers: Time O(n), additional space O(1) (the array itself is modified, no second array).
    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int unique = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[unique - 1]) {
                nums[unique] = nums[i];
                unique++;
            }
        }
        return unique;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\\A");
        String text = sc.hasNext() ? sc.next() : "";
        Matcher numbers = Pattern.compile("-?\\d+").matcher(text);
        List<Integer> values = new ArrayList<>();
        while (numbers.find()) {
            values.add(Integer.parseInt(numbers.group()));
        }
        int[] nums = new int[values.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = values.get(i);
        }
        int length = removeDuplicates(nums);
        System.out.println("length = " + length);
        System.out.println("nums[0.." + (length - 1) + "] = " + Arrays.toString(Arrays.copyOf(nums, length)));
    }
}
