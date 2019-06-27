package com.fan.dream.algorithm.array;

public class NumArray {

    int[] temp = null;
    int[] A = null;

    public NumArray(int[] nums) {
        A = nums;
        temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
            if (i >= 1) {
                temp[i] += temp[i - 1];
            }
        }
    }

    /***
     *
     *https://leetcode-cn.com/problems/range-sum-query-immutable/
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray na = new NumArray(nums);

        System.out.println(na.sumRange(0, 2));
        System.out.println(na.sumRange(2, 5));
        System.out.println(na.sumRange(0, 5));

    }

    public int sumRange(int i, int j) {
        return temp[j] - temp[i] + A[i];
    }
}
