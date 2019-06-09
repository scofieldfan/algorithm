package com.fan.dream.algorithm.linklist;

public class Leetcode {

    /**
     * https://leetcode-cn.com/problems/reverse-linked-list/
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode node = head;
        while (node != null) {
            ListNode temp = node;
            node = node.next;
            temp.next = newHead;
            newHead = temp;
        }
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
