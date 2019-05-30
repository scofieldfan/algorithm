package com.fan.dream.algorithm.dp;

public class Lesson5 {

    /**
     * 打印所有n对括号的全部有效组合
     *
     * @param args
     */
    public static void main(String[] args) {

        Lesson5 lesson = new Lesson5();
        lesson.genBrackets("", 3, 3);
    }

    private void genBrackets(String prefix, int left, int right) {

        if (left > 0) {
            genBrackets(prefix + "(", left - 1, right);
        }
        if (right > 0 && left < right) {
            genBrackets(prefix + ")", left, right - 1);
        }
        if (left == 0 && right == 0) {
            System.out.println(prefix);
        }

    }
}
