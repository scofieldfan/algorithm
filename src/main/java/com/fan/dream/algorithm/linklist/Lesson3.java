package com.fan.dream.algorithm.linklist;

public class Lesson3 {
    /**
     * 删除单向链表中的某个节点
     *
     * @param args
     */
    public static void main(String[] args) {
        Lesson3 lesson1 = new Lesson3();
        int[] vals = {30, 31, 32, 33, 34, 4, 2, 1, 5, 4, 3, 1, 2};
        Node head = Util.createLinkList(vals);
        lesson1.deleteNode(head.next.next);
        Util.printLinkList(head);
    }

    public void deleteNode(Node node) {

        if (node.next == null) {
            //当前linklist 只有一个节点，直接返回
            return;
        }
        Node prev = node;
        Node curr = node.next;
        while (curr.next != null) {
            prev.value = curr.value;
            prev = curr;
            curr = curr.next;
        }
        prev.value = curr.value;
        prev.next = null;
    }
}
