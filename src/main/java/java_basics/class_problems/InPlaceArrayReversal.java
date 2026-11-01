package java_basics.class_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InPlaceArrayReversal {

    static void reverse(int[] tokens) {
        int left = 0;
        int right = tokens.length - 1;
        while (left < right) {
            int temp = tokens[left];
            tokens[left] = tokens[right];
            tokens[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> values = new ArrayList<>();
        Matcher m = Pattern.compile("-?\\d+").matcher(sc.nextLine());
        while (m.find()) {
            values.add(Integer.parseInt(m.group()));
        }
        int[] tokens = new int[values.size()];
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = values.get(i);
        }
        reverse(tokens);
        System.out.println(Arrays.toString(tokens));
    }
}
