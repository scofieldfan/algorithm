package com.fan.dream.algorithm.linklist;

import java.util.HashSet;
import java.util.Set;

public class Lesson1 {
    /**
     * 一处未排序链表中的重复节点
     *
     * @param args
     */
    public static void main(String[] args) {
        Lesson1 lesson1 = new Lesson1();
        int[] vals = {3, 3, 3, 3, 3, 4, 2, 1, 5, 4, 3, 1, 2};
        Node head = Util.createLinkList(vals);
        Util.printLinkList(head);
        lesson1.removeDuplicateNode(head);
        Util.printLinkList(head);
    }

    public void quickSort(Node head, Node tail) {
        if (head == tail) {
            return;
        }
//        Node mid = partition(head, tail);

    }

    public Node partition(Node head, int val) {

        return null;
    }

    public void removeDuplicateNode(Node head) {
        Set<Integer> set = new HashSet<Integer>();
        Node prev = null;
        while (head != null) {
            if (set.contains(head.value)) {
                prev.next = head.next;
                System.out.println("x has " + head.value);
            } else {
                prev = head;
            }
            set.add(head.value);
            head = head.next;
        }
    }
}
