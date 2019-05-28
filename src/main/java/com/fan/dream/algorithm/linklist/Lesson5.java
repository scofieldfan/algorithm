package com.fan.dream.algorithm.linklist;

public class Lesson5 {


    public static void main(String[] args) {

        Lesson5 lesson1 = new Lesson5();
        lesson1.testCase1();
        lesson1.testCase2();

    }


    public void testCase1() {
        Lesson5 lesson1 = new Lesson5();
        int[] val1 = {6, 1, 7};
        int[] val2 = {4, 9, 5};
        Node head1 = Util.createLinkList(val1);
        Node head2 = Util.createLinkList(val2);
        Node head = lesson1.add(head1, head2);
        if (head.value > 10) {
            Node node = new Node(head.value / 10);
            head.value = head.value % 10;
            node.next = head;
            head = node;
        }
        Util.printLinkList(head);
    }

    public void testCase2() {

        Lesson5 lesson1 = new Lesson5();
        int[] val1 = {7, 1, 6};
        int[] val2 = {5, 9, 2};
        Node head1 = Util.createLinkList(val1);
        Node head2 = Util.createLinkList(val2);
        Node result = lesson1.addInOrder(head1, head2);
        Util.printLinkList(result);
    }

    /**
     * 链表相加 7->1->6 + 5->9->2 = 617 + 295
     *
     * @param args
     */
    public Node add(Node link1, Node link2) {

        if (link1 == null && link2 == null) {
            return null;
        }
        Node node = add(link1.next, link2.next);
        int val = 0;
        if (node != null) {
            val = node.value;
            node.value = val % 10;
        }
        int result = link1.value + link2.value + val / 10;
        Node currentNode = new Node(result);
        currentNode.next = node;
        return currentNode;
    }

    /**
     * 链表相加 6->1->7 + 2->9->5 = 617 + 295 = 912
     *
     * @param args
     */

    public Node addInOrder(Node link1, Node link2) {

        int val = 0;
        Node head = null;
        Node prev = null;
        while (link1 != null && link2 != null) {
            int currentVal = link1.value + link2.value + val;
            val = currentVal / 10;
            Node node = new Node(currentVal % 10);
            if (head == null) {
                head = node;
                prev = head;
            } else {
                prev.next = node;
                prev = node;
            }
            link1 = link1.next;
            link2 = link2.next;

        }
        return head;
    }
}
