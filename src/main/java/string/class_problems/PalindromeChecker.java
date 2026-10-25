package string.class_problems;

public class PalindromeChecker {

    public static void main(String[] args) {
        String[] testInputs = {"madam", "hello", "Racecar", "Java", "level", "A man a plan"};

        for (String input : testInputs) {
            
            String cleaned = normalize(input);

            boolean iterativeResult = isPalindromeIterative(cleaned);
            boolean recursiveResult = isPalindromeRecursive(cleaned);
            boolean arrayReversalResult = isPalindromeArrayReversal(cleaned);

            System.out.println("Input: \"" + input + "\"");
            System.out.println("Iterative: " + label(iterativeResult) +
                    " | Recursive: " + label(recursiveResult) +
                    " | Array Reversal: " + label(arrayReversalResult));

            boolean allAgree = (iterativeResult == recursiveResult) && (recursiveResult == arrayReversalResult);
            System.out.println("All approaches agree: " + allAgree);
            System.out.println("---------------------------------------------------------");
        }
    }

    private static String normalize(String text) {
        return text.replaceAll("\\s+", "").toLowerCase();
    }

    private static String label(boolean isPalindrome) {
        return isPalindrome ? "Palindrome" : "Not Palindrome";
    }

    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        
        if (text.length() <= 1) {
            return true;
        }

        char firstChar = text.charAt(0);
        char lastChar = text.charAt(text.length() - 1);

        if (firstChar != lastChar) {
            return false;
        }

        String middle = text.substring(1, text.length() - 1);
        return isPalindromeRecursive(middle);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return new String(original).equals(new String(reversed));
    }
}