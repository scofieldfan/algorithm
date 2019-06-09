package com.fan.dream.algorithm.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TreeAngle {

    public static void main(String[] args) {

        TreeAngle angle = new TreeAngle();
        //System.out.println(angle.generate(8));
        String[] testCase1 = {"5", "2", "C", "D", "+"};
        String[] testCase2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        // System.out.println(angle.calPoints(testCase1));
        //System.out.println(angle.calPoints(testCase2));
        System.out.println(angle.countPrimeSetBits(6, 10));
        System.out.println(angle.countPrimeSetBits(10, 15));
    }

    /**
     * https://leetcode-cn.com/problems/baseball-game/
     *
     * @param ops
     * @return
     */

    public int calPoints(String[] ops) {
        int sum = 0;
        int[] score = new int[ops.length];
        int i = 0;
        for (String op : ops) {
            if ((op.charAt(0) >= '0' && op.charAt(0) <= '9') || op.startsWith("-")) {
                score[i] = Integer.parseInt(op);
                sum += score[i];
                i++;
            } else if (op.equals("C")) {
                i--;
                sum -= score[i];
            } else if (op.equals("D")) {
                score[i] = score[i - 1] * 2;
                sum += score[i];
                i++;
            } else if (op.equals("+")) {
                score[i] = score[i - 1] + score[i - 2];
                sum += score[i];
                i++;
            }
        }
        return sum;
    }


    /**
     * 杨辉三角
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> lastRow = null;
        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(lastRow.get(j - 1) + lastRow.get(j));
                }
            }
            lastRow = row;
            list.add(row);
        }

        return list;
    }

    /**
     * https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/
     *
     * @param L
     * @param R
     * @return
     */
    public int countPrimeSetBits(int L, int R) {
        int[] map = {0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0};
        int sum = 0;
        for (int i = L; i <= R; i++) {
            int num = i;
            int timeOne = 0;
            while (num > 0) {
                num = num & (num - 1);
                timeOne++;
            }
            if (map[timeOne - 1] == 1) {
                sum++;
            }
        }
        return sum;
    }


    /**
     * https://leetcode-cn.com/problems/distribute-candies/
     *
     * @param candies1 1 1 2 2 4 4
     * @return
     */
    public int distributeCandies(int[] candies) {

        Set<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        return Math.min(candies.length / 2, set.size());
    }

    /**
     * https://leetcode-cn.com/problems/reshape-the-matrix/
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {

        if (nums.length * nums[0].length != r * c) {
            return nums;
        }
        int[][] result = new int[r][c];
        int row = 0;
        int column = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                result[row][column] = nums[i][j];
                column++;
                if (column == c - 1) {
                    r++;
                    column = 0;
                }
            }
        }

    }

}
