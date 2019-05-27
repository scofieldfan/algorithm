package com.fan.dream.algorithm.string;


import java.util.Arrays;
import java.util.BitSet;

public class Lesson1 {


    /**
     * 实现一个算法，确定一个字符串里所有的字符是否全都不同，假使不允许使用额外的数据，又该如何处理？
     *
     * @param args
     */


    public static void main(String[] args) {
        String case1 = "abcdef";
        String case2 = "abcdaf";
        Lesson1 l1 = new Lesson1();
        System.out.println(l1.checkRepeatChar(case1));
        System.out.println(l1.checkRepeatChar(case2));

        System.out.println("***********************");

        System.out.println(l1.checkRepeatCharWithSort(case1));
        System.out.println(l1.checkRepeatCharWithSort(case2));


    }

    /**
     * 方法1 使用bit set，如果bitset 中的值为1 则重复
     *
     * @param str1
     */
    public boolean checkRepeatChar(String str1) {
        boolean ret = false;
        if (str1 == null || str1.isEmpty()) {
            return ret;
        }

        BitSet bitSet = new BitSet(256);
        char[] charArray = str1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            byte index = (byte) charArray[i];
            if (bitSet.get(index)) {
                ret = true;
                break;
            } else {
                bitSet.set(index);
            }

        }
        return ret;
    }

    /**
     * 方法2 利用排序，如果出现重复字符则字符数组会出现相同的
     */

    public boolean checkRepeatCharWithSort(String str1) {
        boolean ret = false;
        if (str1 == null || str1.isEmpty()) {
            return ret;
        }
        char[] charArray = str1.toCharArray();
        Arrays.sort(charArray);
        char lastChar = '\0';
        for (int i = 0; i < charArray.length; i++) {
            char currentChar = charArray[i];
            if (lastChar == currentChar) {
                ret = true;
                break;
            }
            lastChar = currentChar;

        }
        return ret;
    }
}
