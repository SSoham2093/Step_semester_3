package string_manipulation.class_problems;

public class IsbnValidator {

    static String normalizeCode(String raw) {
        String t = raw.trim();
        return t.substring(0, 3).toUpperCase() + t.substring(3);
    }

    static String validateAndFormat(String code) {
        if (code.length() != 13) return "Invalid: length must be 13 characters";
        for (int i = 0; i < 3; i++) if (!Character.isLetter(code.charAt(i))) return "Invalid: publisher code must be 3 letters";
        for (int i = 3; i < 13; i++) if (!Character.isDigit(code.charAt(i))) return "Invalid: remaining 10 characters must be digits";
        String pub = code.substring(0, 3);
        String year = code.substring(3, 7);
        String cat = code.substring(7, 13);
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pub).append("] YEAR: ").append(year).append(" | CATALOG: ").append(cat);
        return sb.toString();
    }

    public static void main(String[] args) {
        String code = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(code));
        System.out.println(validateAndFormat("12N2026004251"));
    }
}