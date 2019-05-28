package com.fan.dream.algorithm.linklist;

public class Util {
    public static void printLinkList(Node head) {
        StringBuffer sb = new StringBuffer();
        while (head != null) {
            sb.append(head.value);
            if (head.next != null) {
                sb.append("=>");
            }
            head = head.next;
        }
        System.out.println(sb.toString());
    }

    public static Node createLinkList(int[] vals) {
        Node head = new Node(vals[0]);
        Node prev = head;
        for (int i = 1; i < vals.length; i++) {
            Node node = new Node(vals[i]);
            prev.next = node;
            prev = node;
        }
        return head;
    }
}
