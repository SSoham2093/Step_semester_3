package java_basics.class_problems;

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialCalculator {

    static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            System.out.println(factorial(sc.nextInt()));
        }
    }
}
