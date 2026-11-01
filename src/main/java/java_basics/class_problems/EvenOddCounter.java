package java_basics.class_problems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EvenOddCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int even = 0;
        int odd = 0;
        Matcher m = Pattern.compile("-?\\d+").matcher(sc.nextLine());
        while (m.find()) {
            int number = Integer.parseInt(m.group());
            if (number % 2 == 0) even++;
            else odd++;
        }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}
