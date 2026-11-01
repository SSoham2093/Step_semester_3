package polymorphism.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class FestivalBonusCalculator {

    static abstract class Employee {
        String name;
        double monthlySalary;

        Employee(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        abstract double bonus();
    }

    static class FullTimeEmployee extends Employee {
        FullTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        double bonus() {
            return monthlySalary * 0.10;
        }
    }

    static class PartTimeEmployee extends Employee {
        PartTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        double bonus() {
            return monthlySalary * 0.05;
        }
    }

    static class Intern extends Employee {
        Intern(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        double bonus() {
            return 2000;
        }
    }

    static Employee create(String type, String name, double salary) {
        switch (type) {
            case "FULLTIME": return new FullTimeEmployee(name, salary);
            case "PARTTIME": return new PartTimeEmployee(name, salary);
            case "INTERN": return new Intern(name, salary);
            default: throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            Employee e = create(sc.next(), sc.next(), sc.nextDouble());
            double bonus = e.bonus();
            total += bonus;
            System.out.println(String.format(Locale.US, "%s: %.2f", e.name, bonus));
        }
        System.out.println(String.format(Locale.US, "Total Bonus: %.2f", total));
    }
}
