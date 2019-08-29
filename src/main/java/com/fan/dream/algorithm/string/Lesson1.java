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
//        System.out.println(l1.checkRepeatChar(case1));
//        System.out.println(l1.checkRepeatChar(case2));

        System.out.println("***********************");

//        System.out.println(l1.checkRepeatCharWithSort(case1));
//        System.out.println(l1.checkRepeatCharWithSort(case2));

        System.out.println(l1.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));

    }

    public String isIPV4(String IP) {
        String[] inputs = IP.split("\\.");
        if (inputs.length != 4) {
            return "Neither";
        }
        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            if (input.length() > 1 && input.charAt(0) == '0') {
                return "Neither";
            }
            int temp = Integer.parseInt(input);
            if (temp < 0 || temp > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    public String isIPV6(String IP) {
        String[] inputs = IP.split(":");
        if (inputs.length != 8) {
            return "Neither";
        }
        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            if (input.length() == 0 || input.length() > 4) {
                return "Neither";
            }
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                boolean isOk = false;
                if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f')) {
                    isOk = true;
                } else {
                    return "Neither";
                }
            }

        }
        return "IPv6";
    }

    public String validIPAddress(String IP) {
        if (IP.indexOf(".") != -1) {
            return isIPV4(IP);
        } else {
            return isIPV6(IP);
        }
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
