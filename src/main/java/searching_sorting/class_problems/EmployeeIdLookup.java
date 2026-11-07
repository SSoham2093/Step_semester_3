package searching_sorting.class_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeIdLookup {

    // Time: O(n) once to build. Space: O(n).
    static Map<String, String> buildLookup(List<String[]> records) {
        Map<String, String> lookup = new HashMap<>();
        for (String[] record : records) {
            lookup.put(record[0], record[1]);
        }
        return lookup;
    }

    // Time: O(1) average per query.
    static String getDepartment(Map<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern record = Pattern.compile("\\(\\s*\"([^\"]+)\"\\s*,\\s*\"([^\"]+)\"\\s*\\)");
        Pattern quoted = Pattern.compile("\"([^\"]+)\"");
        List<String[]> records = new ArrayList<>();
        List<String> queries = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Matcher r = record.matcher(line);
            if (r.find()) {
                records.add(new String[]{r.group(1), r.group(2)});
                continue;
            }
            Matcher q = quoted.matcher(line);
            if (q.find()) queries.add(q.group(1));
        }
        Map<String, String> lookup = buildLookup(records);
        for (String id : queries) {
            System.out.println(getDepartment(lookup, id));
        }
    }
}
