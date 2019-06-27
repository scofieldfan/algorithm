package com.fan.dream.algorithm.array;

public class Solution2 {

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 2, 5, 2, 3, 7};
        int[] b = {418, 204, 77, 278, 239, 457, 284, 263, 372, 279, 476, 416, 360, 18};
        Solution2 s2 = new Solution2();
//        System.out.println(s2.findLHS(a));
//        System.out.println(s2.numPairsDivisibleBy60(b));
//        int[] c = {9};
//        System.out.println(s2.plusOne(c));
//        Random random = new Random();
//        System.out.println((char) random.nextInt());
        int[] d = {4, 5, 0, -2, -3, 1};
        System.out.println(s2.subarraysDivByK(d, 5));
    }

    public int subarraysDivByK(int[] A, int K) {
        int sum = 0;
        int[] dp = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= i; j++) {

                dp[j] += A[i];
                if (dp[j] % K == 0) {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    public int[] plusOne(int[] digits) {

        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] > 10) {
                digits[i - 1]++;
                digits[i] = digits[i] - 10;
            }
        }
        if (digits[0] > 10) {

            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            digits[0] = digits[0] - 10;
            for (int i = 0; i < digits.length; i++) {
                ret[i + 1] = digits[i];
            }
            return ret;
        }

        return digits;

    }

    public int numPairsDivisibleBy60(int[] time) {
        int[] map = new int[61];
        int count = 0;
        for (int i = 0; i < time.length; i++) {
            count += map[60 - (time[i] % 60)];
            map[time[i] % 60]++;
        }
        return count;
    }

    public int findLHS(int[] nums) {

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (Math.abs(nums[i] - nums[j]) == 1) {
                return j - i + 1;
            } else if (Math.abs(nums[i] - nums[i + 1]) > 1) {
                i++;
            } else if (Math.abs(nums[j] - nums[j - 1]) > 1) {
                j--;
            }
        }
        return -1;

    }
}
