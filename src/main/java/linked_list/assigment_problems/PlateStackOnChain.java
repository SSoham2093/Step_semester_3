package linked_list.assigment_problems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlateStackOnChain {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    // The top of the stack is the head of the chain.
    // push, pop, peek, isEmpty: O(1) time each, O(1) extra space per call.
    // An array stack is also O(1) per operation, but it has a fixed capacity and can
    // overflow (or needs an O(n) resize); the chain grows one node at a time and never
    // fills up, at the cost of one extra reference per element.
    static class PlateStack {
        private Node top;
        private int size;

        void push(String plate) {
            Node node = new Node(plate);
            node.next = top;
            top = node;
            size++;
            System.out.println("push " + plate + " -> top " + plate + ", size " + size);
        }

        void pop() {
            if (isEmpty()) {
                System.out.println("pop -> stack is empty");
                return;
            }
            String plate = top.data;
            top = top.next;
            size--;
            System.out.println("pop -> " + plate + ", size " + size);
        }

        void peek() {
            if (isEmpty()) {
                System.out.println("peek -> stack is empty");
                return;
            }
            System.out.println("peek -> " + top.data);
        }

        boolean isEmpty() {
            return top == null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder all = new StringBuilder();
        while (sc.hasNextLine()) {
            all.append(sc.nextLine()).append(' ');
        }
        PlateStack stack = new PlateStack();
        Matcher m = Pattern.compile("(push|pop|peek|isEmpty)\\(([^)]*)\\)").matcher(all);
        while (m.find()) {
            switch (m.group(1)) {
                case "push": stack.push(m.group(2).trim()); break;
                case "pop": stack.pop(); break;
                case "peek": stack.peek(); break;
                default: System.out.println("isEmpty -> " + stack.isEmpty());
            }
        }
    }
}
