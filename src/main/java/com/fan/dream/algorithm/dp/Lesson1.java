package com.fan.dream.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

public class Lesson1 {

    public static void main(String[] args) {

        Lesson1 lesson1 = new Lesson1();
        System.out.println(lesson1.climbStair(3, new HashMap<>()));
    }

    /**
     * 有N节楼梯，小明一次可以上1阶，2阶，或者3阶，请问小孩一共有多少上楼梯的方法
     */
    public int climbStair(int n, Map<Integer, Integer> map) {
        if (map.get(n) != null) {
            return map.get(n);
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        int ret = climbStair(n - 1, map) + climbStair(n - 2, map) + climbStair(n - 3, map);
        map.put(n, ret);
        return ret;
    }
}
