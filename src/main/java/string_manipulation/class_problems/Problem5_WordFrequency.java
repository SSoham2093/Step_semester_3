package string_manipulation.class_problems;

import java.util.*;

public class Problem5_WordFrequency {

    static void printFilteredWordFrequency(String feedback) {
        Set<String> stop = new HashSet<>(Arrays.asList("the","was","and","a","is","of","in"));
        String clean = feedback.toLowerCase().replace(",", "").replace(".", "");
        String[] words = clean.split("\\s+");
        Map<String, Integer> count = new HashMap<>();
        for (String w : words) {
            if (w.isEmpty() || stop.contains(w)) continue;
            count.put(w, count.getOrDefault(w, 0) + 1);
        }
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(count.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<String, Integer> e : entries) System.out.println(e.getKey() + ": " + e.getValue());
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}