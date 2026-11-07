package searching_sorting.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LibraryBookShelf {

    // Insertion sort. Time: O(n^2) worst case, O(n) if already sorted. Space: O(1).
    static void shelf(int[] books) {
        for (int i = 1; i < books.length; i++) {
            int book = books[i];
            int j = i - 1;
            while (j >= 0 && books[j] > book) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = book;
            System.out.println("After placing " + book + ": " + Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern list = Pattern.compile("\\[([^\\]]*)\\]");
        while (sc.hasNextLine()) {
            Matcher l = list.matcher(sc.nextLine());
            if (!l.find()) continue;
            Matcher numbers = Pattern.compile("-?\\d+").matcher(l.group(1));
            List<Integer> values = new ArrayList<>();
            while (numbers.find()) {
                values.add(Integer.parseInt(numbers.group()));
            }
            int[] books = new int[values.size()];
            for (int i = 0; i < books.length; i++) {
                books[i] = values.get(i);
            }
            shelf(books);
        }
    }
}
