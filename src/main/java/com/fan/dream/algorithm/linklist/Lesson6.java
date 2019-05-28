package com.fan.dream.algorithm.linklist;

import java.util.Stack;

public class Lesson6 {
    /**
     * 编写一个函数，检查链表是否为回文
     *
     * @param args
     */
    public static void main(String[] args) {
        Lesson6 lesson6 = new Lesson6();
        int[] val1 = {1, 2, 3, 4, 3, 2, 1};
        Node head = Util.createLinkList(val1);
        Util.printLinkList(head);
        System.out.println(lesson6.isEchoLinkList(head));
    }

    public boolean isEchoLinkList(Node head) {

        Node node = head;
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.value);
            node = node.next;
        }
//        System.out.println(stack.toString());
        Node node2 = head;
        while (node2 != null) {
            int val = stack.pop();
            if (node2.value != val) {
                return false;
            }
            node2 = node2.next;
        }
        return true;
    }
}
