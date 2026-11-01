package java_basics.class_problems;

import java.util.Scanner;

public class WordReverserPalindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String word = sc.next();
            String reversed = new StringBuilder(word).reverse().toString();
            String result = word.equals(reversed) ? "palindrome" : "not a palindrome";
            System.out.println(reversed + " - " + result);
        }
    }
}
