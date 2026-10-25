package string.assigment_problems;

import java.util.*;

public class FirstNonRepeatingChar {
    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (char c : text.toCharArray()) {
            if (freq.get(c) == 1) return c;
        }
        return '\0';
    }

    public static void main(String[] args) {
        String[] tests = {"swiss", "aabbcc"};
        for (String text : tests) {
            char result = findFirstNonRepeatingChar(text);
            if (result == '\0') {
                System.out.println("No Non-Repeating Character Found");
            } else {
                System.out.println("First Non-Repeating Character: '" + result + "'");
            }
        }
    }
}