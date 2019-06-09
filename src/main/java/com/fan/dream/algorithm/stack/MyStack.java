package com.fan.dream.algorithm.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public MyStack() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue1.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int result = 0;
        while (!queue1.isEmpty()) {
            int num = queue1.remove();
            if (queue1.isEmpty()) {
                result = num;
                break;
            }
            queue2.add(num);
        }

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return result;
    }

    /**
     * Get the top element.
     */
    public int top() {

        int result = 0;
        while (!queue1.isEmpty()) {
            int num = queue1.remove();
            queue2.add(num);
            result = num;
        }

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return result;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
