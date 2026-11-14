package linked_list.class_problems;

import java.math.BigDecimal;
import java.util.Scanner;

public class CampusStaffSalary {

    static class Staff {
        private final String name;
        private final double baseSalary;

        Staff(String name, double baseSalary) {
            this.name = name;
            this.baseSalary = baseSalary;
        }

        double getBonus() {
            return 0;
        }

        String getType() {
            return "Staff";
        }

        double getTotal() {
            return baseSalary + getBonus();
        }

        String details() {
            return name + " (" + getType() + "): base " + num(baseSalary)
                    + ", bonus " + num(getBonus()) + ", total " + num(getTotal());
        }
    }

    static class Teacher extends Staff {
        Teacher(String name, double baseSalary) {
            super(name, baseSalary);
        }

        @Override
        double getBonus() {
            return 5000;
        }

        @Override
        String getType() {
            return "Teacher";
        }
    }

    static class LabAssistant extends Staff {
        LabAssistant(String name, double baseSalary) {
            super(name, baseSalary);
        }

        @Override
        double getBonus() {
            return 2000;
        }

        @Override
        String getType() {
            return "LabAssistant";
        }
    }

    static String num(double d) {
        BigDecimal b = BigDecimal.valueOf(d);
        if (b.scale() < 1) b = b.setScale(1);
        return b.toPlainString();
    }

    static Staff create(String type, String name, double base) {
        switch (type.toLowerCase()) {
            case "teacher": return new Teacher(name, base);
            case "labassistant": return new LabAssistant(name, base);
            default: return new Staff(name, base);
        }
    }

    // Time: O(n), one pass over the array. Space: O(n) for the array.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Staff[] staff = new Staff[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double base = sc.nextDouble();
            staff[i] = create(type, name, base);
        }
        double grand = 0;
        for (Staff s : staff) {
            System.out.println(s.details());
            grand += s.getTotal();
        }
        System.out.println("Grand Total Salary: " + num(grand));
    }
}
