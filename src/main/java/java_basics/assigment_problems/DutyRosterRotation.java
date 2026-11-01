package java_basics.assigment_problems;

import java.util.Arrays;
import java.util.Scanner;

public class DutyRosterRotation {

    // Time: O(n). Additional space: O(n) for the rotated roster.
    static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int shift = (int) (k % n);
        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().replaceAll("[\\[\\]]", "").trim();
        String[] names = line.split("[,\\s]+");
        long k = sc.nextLong();
        System.out.println(Arrays.toString(rotateRoster(names, k)));
    }
}
