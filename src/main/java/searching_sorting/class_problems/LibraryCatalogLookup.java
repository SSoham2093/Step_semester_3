package searching_sorting.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LibraryCatalogLookup {

    // Time: O(log n) per query. Space: O(1).
    static String findBook(String[][] catalog, String targetIsbn) {
        int lo = 0;
        int hi = catalog.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = catalog[mid][0].compareTo(targetIsbn);
            if (cmp == 0) return catalog[mid][1];
            if (cmp < 0) lo = mid + 1;
            else hi = mid - 1;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\\A");
        String text = sc.hasNext() ? sc.next() : "";
        Pattern record = Pattern.compile("\\(\\s*\"(\\d+)\"\\s*,\\s*\"([^\"]*)\"\\s*\\)");
        Pattern quoted = Pattern.compile("\"(\\d+)\"");
        List<String[]> records = new ArrayList<>();
        List<String> targets = new ArrayList<>();
        for (String line : text.split("\\R")) {
            Matcher r = record.matcher(line);
            if (r.find()) {
                records.add(new String[]{r.group(1), r.group(2)});
                continue;
            }
            Matcher q = quoted.matcher(line);
            if (q.find()) targets.add(q.group(1));
        }
        String[][] catalog = records.toArray(new String[0][]);
        for (String target : targets) {
            System.out.println(findBook(catalog, target));
        }
    }
}
