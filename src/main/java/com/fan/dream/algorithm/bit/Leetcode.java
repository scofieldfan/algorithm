package com.fan.dream.algorithm.bit;


public class Leetcode {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Leetcode lc = new Leetcode();
//        System.out.println(lc.hammingDistance(1, 5));
//        System.out.println(lc.hammingDistance(1, 4));
        System.out.println(lc.findComplement(5));
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
