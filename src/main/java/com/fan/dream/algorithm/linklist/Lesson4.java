package com.fan.dream.algorithm.linklist;

public class Lesson4 {

    /**
     * 给定x 为基准，将链表分割为亮部分，所有小于x的节点排在大于等于x的节点之前
     *
     * @param args
     */
    public static void main(String[] args) {
        Lesson4 lesson1 = new Lesson4();
        int[] vals = {30, 31, 2, 33, 34, 4, 20, 10, 5, 4, 3, 1, 2};
        Node head = Util.createLinkList(vals);
        Node newHead = lesson1.partition(head, 5);
        Util.printLinkList(newHead);
    }

    public Node partition(Node head, int val) {

        Node minPrev = null;
        Node prev = null;
        Node p = head;
        Node newHead = null;
        while (p != null) {

            if (p.value < val) {
                if (minPrev == null) {
                    prev.next = p.next;
                    minPrev = p;
                    minPrev.next = head;
                    newHead = minPrev;
                } else {
                    prev.next = p.next;

                    Node temp = minPrev.next;
                    minPrev.next = p;
                    p.next = temp;

                    minPrev = p;
                }
            }
            prev = p;
            p = p.next;
            Util.printLinkList(p);
            Util.printLinkList(head);
            System.out.println("****************");
        }
        return newHead;
    }
}
