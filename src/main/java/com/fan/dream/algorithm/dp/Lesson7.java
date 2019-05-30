package com.fan.dream.algorithm.dp;

public class Lesson7 {

    /**
     * 给定数量不限定的硬币，币值为 25,10,5,1,求问一共有N分，有多少中表示方法
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] money = {1, 5, 10, 25};
        Lesson7 lesson = new Lesson7();
        System.out.println(lesson.findMoneyComb(money, 4, 10));
    }

    public int findMoneyComb(int[] money, int n, int sum) {

        if (sum == 0) {
            return 1;
        }
        if (n <= 0 || sum < 0) {
            return 0;
        }

        return findMoneyComb(money, n, sum - money[n - 1]) + findMoneyComb(money, n - 1, sum);
    }
}
