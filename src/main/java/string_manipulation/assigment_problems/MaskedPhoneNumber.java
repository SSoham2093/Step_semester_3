package string_manipulation.assigment_problems;

import java.util.Scanner;

public class MaskedPhoneNumber {

    static String maskPhoneNumber(String phone) {
        if (phone.length() != 10 || !phone.matches("\\d+")) return "Invalid phone number";
        StringBuilder sb = new StringBuilder("XXXXXX");
        sb.append("-").append(phone.substring(6));
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String phone = sc.nextLine();
        System.out.println(maskPhoneNumber(phone));
    }
}