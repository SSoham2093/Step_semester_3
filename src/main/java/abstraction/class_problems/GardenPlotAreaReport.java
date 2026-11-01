package abstraction.class_problems;

import java.util.Locale;
import java.util.Scanner;

public class GardenPlotAreaReport {

    static abstract class Plot {
        String owner;
        String shape;

        Plot(String owner, String shape) {
            this.owner = owner;
            this.shape = shape;
        }

        abstract double area();
    }

    static class CirclePlot extends Plot {
        double radius;

        CirclePlot(String owner, double radius) {
            super(owner, "CIRCLE");
            this.radius = radius;
        }

        double area() {
            return Math.PI * radius * radius;
        }
    }

    static class RectanglePlot extends Plot {
        double length;
        double width;

        RectanglePlot(String owner, double length, double width) {
            super(owner, "RECTANGLE");
            this.length = length;
            this.width = width;
        }

        double area() {
            return length * width;
        }
    }

    static class TrianglePlot extends Plot {
        double base;
        double height;

        TrianglePlot(String owner, double base, double height) {
            super(owner, "TRIANGLE");
            this.base = base;
            this.height = height;
        }

        double area() {
            return 0.5 * base * height;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            Plot p;
            switch (shape) {
                case "CIRCLE": p = new CirclePlot(owner, sc.nextDouble()); break;
                case "RECTANGLE": p = new RectanglePlot(owner, sc.nextDouble(), sc.nextDouble()); break;
                case "TRIANGLE": p = new TrianglePlot(owner, sc.nextDouble(), sc.nextDouble()); break;
                default: throw new IllegalArgumentException("Unknown shape: " + shape);
            }
            double area = p.area();
            total += area;
            System.out.println(String.format(Locale.US, "%s (%s): %.2f", p.owner, p.shape, area));
        }
        System.out.println(String.format(Locale.US, "Total Area: %.2f", total));
    }
}
