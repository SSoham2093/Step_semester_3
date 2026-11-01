package java_basics.class_problems;

import java.util.Scanner;

public class VowelConsonantCounter {

    static boolean isVowel(char c) {
        return "aeiou".indexOf(Character.toLowerCase(c)) >= 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int vowels = 0;
        int consonants = 0;
        for (char c : word.toCharArray()) {
            if (!Character.isLetter(c)) continue;
            if (isVowel(c)) vowels++;
            else consonants++;
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
