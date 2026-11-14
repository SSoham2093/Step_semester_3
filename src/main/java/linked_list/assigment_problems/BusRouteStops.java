package linked_list.assigment_problems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BusRouteStops {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    // Time: O(n), a tail pointer avoids walking the chain for every append. Space: O(n) for the nodes.
    static Node build(String[] stops) {
        Node head = null;
        Node tail = null;
        for (String stop : stops) {
            Node node = new Node(stop);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    // Time: O(n), one visit per node. Space: O(1).
    static void printRoute(Node head) {
        int count = 0;
        Node last = null;
        StringBuilder route = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            route.append(cur.data).append(" -> ");
            count++;
            last = cur;
        }
        System.out.println(route + "null");
        if (head != null) {
            System.out.println("Stops: " + count + ", First: " + head.data + ", Last: " + last.data);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern list = Pattern.compile("\\[([^\\]]*)\\]");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Matcher m = list.matcher(line);
            if (!m.find()) continue;
            String body = m.group(1).trim();
            if (body.isEmpty()) continue;
            String[] stops = body.split("\\s*,\\s*");
            printRoute(build(stops));
        }
    }
}
