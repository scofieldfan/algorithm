package com.fan.dream.algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class Lesson2 {


    /**
     * 给定两个字符串，确定一个字符串重新排列后，是否能变成另外一个字符串
     *
     * @param args
     */
    public static void main(String[] args) {
        String case1 = "abcdefaaa";
        String case2 = "adefabcaav";
        Lesson2 l1 = new Lesson2();
        System.out.println(l1.checkIsPermute(case1, case2));
    }

    public boolean checkIsPermute(String str1, String str2) {
        if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty()) {
            return false;
        }

        boolean ret = true;
        Map<Byte, Integer> map = new HashMap<Byte, Integer>();
        char[] charArray1 = str1.toCharArray();
        for (int i = 0; i < charArray1.length; i++) {
            int num = map.get((byte) charArray1[i]) == null ? 0 : map.get((byte) charArray1[i]);
            map.put((byte) charArray1[i], num + 1);
        }

        char[] charArray2 = str2.toCharArray();
        int count = 0;
        for (int i = 0; i < charArray2.length; i++) {
            int num = map.get((byte) charArray2[i]) == null ? 0 : map.get((byte) charArray2[i]);
            if (num > 0) {
                count++;
                map.put((byte) charArray2[i], num - 1);
            } else {
                ret = false;
                break;
            }
        }
        return ret && count == str1.length();

    }

}
