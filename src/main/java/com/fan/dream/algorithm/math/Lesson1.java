package com.fan.dream.algorithm.math;

import java.util.*;

public class Lesson1 {


    public Lesson1() {
    }

    public static void main(String[] args) {

        Lesson1 lesson1 = new Lesson1();
        //lesson1.combin(4, 2, "");
        //System.out.println(lesson1.readBinaryWatch(1));
        /*
        int a = -3;
        for (int i = 0; i < 32; i++) {
            int t = (a & 0x80000000 >>> i) >>> (31 - i);
            System.out.print(t);
        }*/
//        System.out.println(lesson1.getSum(2, 3));
//        System.out.println(lesson1.reverse(1534236469));
//        System.out.println(Integer.MAX_VALUE);
        int[] num = {1, 2, 3, 4};
        System.out.println(lesson1.permute(num));
        PriorityQueue queue = new PriorityQueue();
        Map<String, Integer> map = new HashMap<>();


    }

    public void dfs(int[] nums, int index, List<List<Integer>> result) {
        if (index == 0) {

            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            result.add(list);
            return;
        }
        dfs(nums, index - 1, result);
        int cur = nums[index];
        int size = result.size();
        List<List<Integer>> newResult = new ArrayList<>(result);
        result.clear();
        for (int i = 0; i < size; i++) {
            List<Integer> item = newResult.get(i);
            int p = item.size(), j = 0;
            while (j <= p) {
                List<Integer> temp = new ArrayList<>(item);
                temp.add(j, cur);
                result.add(temp);
                j++;
            }
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(nums, nums.length - 1, list);
        return list;
    }

    public int reverse(int x) {
        long ret = 0;
        int n = x;
        while (n != 0) {
            int temp = n % 10;
            ret = ret + temp;
            if (ret > Integer.MAX_VALUE) {
                return 0;
            }
            n = n / 10;
            if (n != 0)
                ret *= 10;

        }
        return (int) ret;
    }

    public int getSum(int a, int b) {
        int jinwei = a & b;
        int num = a ^ b;
        while (jinwei != 0) {
            jinwei = jinwei << 1;
            int newNum = jinwei ^ num;
            jinwei = jinwei & num;
            num = newNum;

        }
        return num;
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


    private void combine(int hour, int minute, int num, int index, List<String> result) {

        if (hour > 11 || minute > 59) {
            return;
        }

        if (num == 0) {
            result.add(hour + ":" + String.format("%02d", minute));
        }
        for (int i = index; i < 10; i++) {
            int temp = 0;
            if (i <= 5) {
                temp = 1 << i;
                combine(hour, minute | temp, num - 1, i + 1, result);
            } else {
                temp = 1 << (i - 6);
                combine(hour | temp, minute, num - 1, i + 1, result);
            }

        }


    }

    public List<String> readBinaryWatch(int num) {

        List<String> list = new ArrayList<>();
        combine(0, 0, num, 0, list);
        return list;
    }
}
