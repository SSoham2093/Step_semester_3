package linked_list.assigment_problems;

import java.util.Scanner;

public class BookCopyFinder {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    // One walk. Time: O(n). Space: O(1).
    // A chain has no index arithmetic: each node only knows the next one, so reaching
    // the middle means following next references from the head, which costs O(n), not O(1).
    static String find(Node head, String id) {
        int position = 0;
        int copies = 0;
        int first = -1;
        for (Node cur = head; cur != null; cur = cur.next) {
            position++;
            if (cur.data.equals(id)) {
                copies++;
                if (first == -1) first = position;
            }
        }
        if (copies == 0) return id + " not found";
        return id + " first at position " + first + ", copies: " + copies;
    }

    static Node parse(String text) {
        Node head = null;
        Node tail = null;
        for (String part : text.split("->")) {
            String name = part.trim();
            if (name.isEmpty() || name.equals("null")) continue;
            Node node = new Node(name);
            if (head == null) head = node; else tail.next = node;
            tail = node;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String text = sc.nextLine().trim();
            int comma = text.lastIndexOf(',');
            int idAt = text.indexOf("id");
            if (comma < 0 || idAt < 0) continue;
            String chain = text.substring(text.indexOf('=') + 1, comma);
            String id = text.substring(text.indexOf('=', idAt) + 1).trim();
            System.out.println(find(parse(chain), id));
        }
    }
}
