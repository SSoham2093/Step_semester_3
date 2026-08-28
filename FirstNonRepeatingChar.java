import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

    private static final char NOT_FOUND = '\0';

    public static void main(String[] args) {
        String[] testInputs = {"swiss", "aabbcc", "teeter", "programming", "aA"};

        for (String input : testInputs) {
            char result = findFirstNonRepeatingChar(input);

            System.out.print("Input: \"" + input + "\" -> ");
            if (result == NOT_FOUND) {
                System.out.println("No Non-Repeating Character Found");
            } else {
                System.out.println("First Non-Repeating Character: '" + result + "'");
            }
        }
    }

    public static char findFirstNonRepeatingChar(String text) {
        
        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (frequencyMap.get(c) == 1) {
                return c; 
            }
        }

        return NOT_FOUND;
    }
}