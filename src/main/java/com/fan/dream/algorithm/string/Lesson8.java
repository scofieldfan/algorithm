package com.fan.dream.algorithm.string;

public class Lesson8 {

    /**
     * 翻转一个字符串 reverse
     *
     * @param args
     */
    public static void main(String[] args) {

        Lesson8 lesson8 = new Lesson8();
        System.out.println(lesson8.reverse("abcedfggg88"));
    }

    public String reverse(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < Math.floor(charArray.length / 2); i++) {
            char temp = charArray[i];
            charArray[i] = charArray[charArray.length - 1 - i];
            charArray[charArray.length - 1 - i] = temp;
        }
        return new String(charArray);
    }
}
