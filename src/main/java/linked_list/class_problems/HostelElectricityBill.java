package linked_list.class_problems;

import java.util.Scanner;

public class HostelElectricityBill {

    static final long METER_CHARGE = 50;

    static long bill(long units) {
        long energy;
        if (units <= 100) {
            energy = units * 3;
        } else if (units <= 200) {
            energy = 300 + (units - 100) * 5;
        } else {
            energy = 300 + 500 + (units - 200) * 8;
        }
        return energy + METER_CHARGE;
    }

    // Time: O(n), constant work per room. Space: O(1).
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int billed = 0;
        long total = 0;
        for (int i = 0; i < n; i++) {
            String room = sc.next();
            long units = sc.nextLong();
            if (units < 0) {
                System.out.println(room + ": invalid reading");
                continue;
            }
            long amount = bill(units);
            System.out.println(room + ": " + units + " units, bill " + amount);
            billed++;
            total += amount;
        }
        System.out.println("Rooms billed " + billed + ", total " + total);
    }
}
