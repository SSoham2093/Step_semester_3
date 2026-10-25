package string_manipulation.assigment_problems;

import java.util.Scanner;

public class BankReferenceValidator {

    static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed.toUpperCase();
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) return "Invalid: length must be 14";
        for (int i = 0; i < 3; i++)
            if (!Character.isLetter(reference.charAt(i))) return "Invalid: bank code must be 3 letters";
        for (int i = 3; i < 14; i++)
            if (!Character.isDigit(reference.charAt(i))) return "Invalid: body must be digits";

        String bank = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String seq = reference.substring(9, 14);
        String dd = date.substring(0, 2), mm = date.substring(2, 4), yy = date.substring(4, 6);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bank).append("] DATE: ").append(dd).append("/").append(mm).append("/").append(yy);
        sb.append(" | SEQ: ").append(seq);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String raw = sc.nextLine();
        System.out.println(validateAndFormat(normalizeReference(raw)));
    }
}