package searching_sorting.class_problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransactionDuplicateCheck {

    // Time: O(n) average. Space: O(n).
    // Lower-memory alternative: sort a copy and compare neighbours, O(n log n) time, O(1) extra space if sorted in place.
    static boolean hasDuplicate(String[] transactionIds) {
        Set<String> seen = new HashSet<>();
        for (String id : transactionIds) {
            if (!seen.add(id)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern quoted = Pattern.compile("\"([^\"]*)\"");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.trim().isEmpty()) continue;
            List<String> ids = new ArrayList<>();
            Matcher m = quoted.matcher(line);
            while (m.find()) {
                ids.add(m.group(1));
            }
            System.out.println(hasDuplicate(ids.toArray(new String[0])));
        }
    }
}
