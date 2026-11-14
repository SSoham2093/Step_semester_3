package linked_list.assigment_problems;

import java.util.Scanner;

public class CancelBooking {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    // Time: O(1) when the booking is at the head, O(n) when it is at the end or missing. Space: O(1).
    static Node removeFirst(Node head, String booking) {
        if (head == null) {
            System.out.println(booking + " not found");
            return null;
        }
        if (head.data.equals(booking)) return head.next;
        Node cur = head;
        while (cur.next != null && !cur.next.data.equals(booking)) {
            cur = cur.next;
        }
        if (cur.next == null) {
            System.out.println(booking + " not found");
        } else {
            cur.next = cur.next.next;
        }
        return head;
    }

    static Node parse(String text) {
        Node head = null;
        Node tail = null;
        for (String part : text.split("->")) {
            String name = part.trim();
            if (name.isEmpty() || name.equals("null") || name.equals("(empty)")) continue;
            Node node = new Node(name);
            if (head == null) head = node; else tail.next = node;
            tail = node;
        }
        return head;
    }

    static void print(Node head) {
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data).append(" -> ");
        }
        System.out.println(sb + "null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String text = sc.nextLine().trim();
            int comma = text.lastIndexOf(',');
            if (comma < 0) continue;
            String chain = text.substring(text.indexOf('=') + 1, comma);
            String booking = text.substring(text.indexOf('=', comma) + 1).trim();
            print(removeFirst(parse(chain), booking));
        }
    }
}
