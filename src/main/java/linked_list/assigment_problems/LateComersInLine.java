package linked_list.assigment_problems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LateComersInLine {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    // Time: O(1). Space: O(1).
    static Node addFirst(Node head, String name) {
        Node node = new Node(name);
        node.next = head;
        return node;
    }

    // Time: O(n), walks to the last node (O(1) on an empty line). Space: O(1).
    static Node addLast(Node head, String name) {
        Node node = new Node(name);
        if (head == null) return node;
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
        return head;
    }

    static void print(Node head) {
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data).append(" -> ");
        }
        System.out.println(sb + "null");
    }

    static Node parseLine(String text) {
        Node head = null;
        for (String part : text.split("->")) {
            String name = part.trim();
            if (name.isEmpty() || name.equals("null") || name.equals("(empty)")) continue;
            head = addLast(head, name);
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern op = Pattern.compile("(addFirst|addLast)\\(([^)]*)\\)");
        Node head = null;
        boolean started = false;
        while (sc.hasNextLine()) {
            String text = sc.nextLine().trim();
            if (text.isEmpty()) continue;
            if (text.toLowerCase().startsWith("line")) {
                if (started) print(head);
                head = parseLine(text.substring(text.indexOf('=') + 1));
                started = true;
                continue;
            }
            Matcher m = op.matcher(text);
            while (m.find()) {
                String name = m.group(2).trim();
                head = m.group(1).equals("addFirst") ? addFirst(head, name) : addLast(head, name);
            }
        }
        if (started) print(head);
    }
}
