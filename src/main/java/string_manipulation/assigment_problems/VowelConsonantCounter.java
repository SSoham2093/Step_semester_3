package string_manipulation.assigment_problems;

import java.util.Scanner;

public class VowelConsonantCounter {

    static void countVowelsAndConsonants(String text) {
        int vowels = 0, consonants = 0;
        String v = "aeiouAEIOU";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') continue;
            if (v.indexOf(c) != -1) vowels++;
            else consonants++;
        }
        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        countVowelsAndConsonants(text);
    }
}