package linked_list.class_problems;

import java.util.Scanner;

public class LibraryReturnDesk {

    static final int CAPACITY = 3;

    // Array stack. push, pop: O(1) time each. Space: O(1) extra.
    static class Pile {
        private final String[] items = new String[CAPACITY];
        private int top = -1;

        void returnBook(String book) {
            if (top == CAPACITY - 1) {
                System.out.println(book + " rejected: pile is full");
                return;
            }
            items[++top] = book;
            System.out.println(book + " placed on pile");
        }

        void shelve() {
            if (top == -1) {
                System.out.println("pile is empty");
                return;
            }
            System.out.println("shelved " + items[top--]);
        }
    }

    // Circular array queue. enqueue, dequeue: O(1) time each. Space: O(1) extra.
    static class Line {
        private final String[] items = new String[CAPACITY];
        private int front = 0;
        private int rear = -1;
        private int size = 0;

        void join(String student) {
            if (size == CAPACITY) {
                System.out.println(student + " rejected: line is full");
                return;
            }
            rear = (rear + 1) % CAPACITY;
            items[rear] = student;
            size++;
            System.out.println(student + " joined the line");
        }

        void serve() {
            if (size == 0) {
                System.out.println("no one waiting");
                return;
            }
            System.out.println("served " + items[front]);
            front = (front + 1) % CAPACITY;
            size--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder all = new StringBuilder();
        while (sc.hasNextLine()) {
            all.append(sc.nextLine()).append(',');
        }
        Pile pile = new Pile();
        Line line = new Line();
        for (String part : all.toString().split(",")) {
            String command = part.trim();
            if (command.isEmpty()) continue;
            String[] w = command.split("\\s+", 2);
            String arg = w.length > 1 ? w[1] : "";
            switch (w[0].toUpperCase()) {
                case "RETURN": pile.returnBook(arg); break;
                case "SHELVE": pile.shelve(); break;
                case "WAIT": line.join(arg); break;
                case "SERVE": line.serve(); break;
                default: System.out.println("unknown command: " + command);
            }
        }
    }
}
