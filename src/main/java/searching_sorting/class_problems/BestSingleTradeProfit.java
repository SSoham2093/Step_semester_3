package searching_sorting.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BestSingleTradeProfit {

    // Single pass: Time O(n), Space O(1). (Checking every pair of days is O(n^2).)
    static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int best = 0;
        for (int price : prices) {
            if (price < minPrice) minPrice = price;
            else if (price - minPrice > best) best = price - minPrice;
        }
        return best;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern list = Pattern.compile("\\[([^\\]]*)\\]");
        while (sc.hasNextLine()) {
            Matcher l = list.matcher(sc.nextLine());
            if (!l.find()) continue;
            Matcher numbers = Pattern.compile("\\d+").matcher(l.group(1));
            List<Integer> values = new ArrayList<>();
            while (numbers.find()) {
                values.add(Integer.parseInt(numbers.group()));
            }
            int[] prices = new int[values.size()];
            for (int i = 0; i < prices.length; i++) {
                prices[i] = values.get(i);
            }
            System.out.println(maxProfit(prices));
        }
    }
}
