package com.fan.dream.algorithm.linklist;

public class Lesson2 {

    /**
     * 找出单向链表的倒数第K个节点
     *
     * @param args
     */
    public static void main(String[] args) {
        Lesson2 lesson1 = new Lesson2();
        int[] vals = {3, 3, 3, 3, 3, 4, 2, 1, 5, 4, 3, 1, 2};
        Node head = Util.createLinkList(vals);

        Node kNode = lesson1.findLastKNode(head, 5);
        System.out.println("kNode:" + kNode.value);
    }

    public Node findLastKNode(Node head, int k) {

        Node kNode = null;
        Node p = head;
        while (p != null) {
            k--;
            if (k == 0) {
                kNode = head;
            } else {
                if (kNode != null) {
                    kNode = kNode.next;
                }
            }
            p = p.next;
        }
        return kNode;
    }
}
