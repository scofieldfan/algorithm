package com.fan.dream.algorithm.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Logger {


    /**
     * Initialize your data structure here.
     */

    LinkedList<String> queue = new LinkedList<String>();
    Map<String, String> map = new HashMap<>();

    public Logger() {

    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {

            System.out.print("**");
            if (i % 100 == 0) {
                System.out.println("");
            }
        }
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {

        queue.addLast(message);
        return true;
    }
}
