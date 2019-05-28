package com.fan.dream.algorithm.string;

public class Lesson2 {


    /**
     * 给定两个字符串，确定一个字符串重新排列后，是否能变成另外一个字符串
     *
     * @param args
     */
    public static void main(String[] args) {
        String case1 = "abcdefaaa";
        String case2 = "adefabcaa";
        Lesson2 l1 = new Lesson2();
        System.out.println(l1.checkIsPermute(case1, case2));
    }

    public boolean checkIsPermute(String str1, String str2) {
        if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty()) {
            return false;
        }
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] map = new int[256];
        char[] charArray1 = str1.toCharArray();
        for (int i = 0; i < charArray1.length; i++) {
            map[charArray1[i]] += 1;
        }
        char[] charArray2 = str2.toCharArray();
        for (int i = 0; i < charArray2.length; i++) {
            map[charArray2[i]] -= 1;
            if (map[charArray2[i]] < 0) {
                return false;
            }
        }
        return true;

    }

}
