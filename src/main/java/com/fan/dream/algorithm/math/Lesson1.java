package com.fan.dream.algorithm.math;

public class Lesson1 {


    public static void main(String[] args) {

        Lesson1 lesson1 = new Lesson1();
        lesson1.combin(4, 2, "");
    }

    /**
     * 组合
     *
     * @param args
     */

    private void combin(int n, int m, String sb) {

        if (m == 0) {
            System.out.println(sb);
            return;
        }
        if (n <= 0) {
            return;
        }
        if (n >= 1) {
            combin(n - 1, m, sb);
            combin(n - 1, m - 1, sb + String.valueOf(n));
        }
    }
}
