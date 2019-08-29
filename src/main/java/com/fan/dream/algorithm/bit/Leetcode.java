package com.fan.dream.algorithm.bit;


import java.util.ArrayList;
import java.util.List;

public class Leetcode {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Leetcode lc = new Leetcode();
//        System.out.println(lc.hammingDistance(1, 5));
//        System.out.println(lc.hammingDistance(1, 4));
//        System.out.println(lc.findComplement(5));
//        System.out.println(5 & -5);
//        System.out.println(5 & 4);
        List<Integer> list = new ArrayList<>();
//        int[] nums = {2, 1, 2, 3, 4, 1};
//        int[] nums2 = {1, 2, 1, 3, 2, 5};
//        System.out.println(Arrays.toString(lc.singleNumber(nums)));
//        System.out.println(Arrays.toString(lc.singleNumber(nums2)));
        list.add(1);
        System.out.println(list.toString());
    }

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int mask = xor ^ (xor & (xor - 1));
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & mask) == 0) {
                result[0] ^= nums[i];
            } else {
                result[1] ^= nums[i];
            }
        }
        return result;
    }

    public int hammingDistance(int x, int y) {
        int ret = x ^ y;
        int times = 0;
        while (ret > 0) {
            if ((ret & 1) > 0) {
                times++;
            }
            ret = ret >> 1;
        }
        return times;
    }

    /**
     * https://leetcode-cn.com/problems/number-complement/
     */

    public int findComplement(int num) {
        int count = 0;
        int temp = num;
        while (temp > 0) {
            count = (count << 1) + 1;
            temp = temp >> 1;
        }
        return count ^ num;
    }

    public int findComplement2(int num) {
        int ret = 0;
        int times = 0;
        while (num > 0) {
            if ((num & 1) == 0) {
                ret = ret | 1 << times;
            }
            times++;
            num = num >> 1;
        }
        return ret;
    }
}
