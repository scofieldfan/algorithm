package com.fan.dream.algorithm.string;

public class Lesson7 {

    /**
     * 判断一个字符串是否为另外一个字符串旋转而成 s1 ,s2
     * waterbottle 是 erbottlewat 旋转而成,可以使用isSubString 子函数
     *
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        Lesson7 lesson7 = new Lesson7();
        System.out.println(lesson7.isRotate(s1, s2));
    }

    public boolean isRotate(String s1, String s2) {
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
            return false;
        }
        String temp = s1 + s1;
        return isSubString(temp, s2);
    }

    public boolean isSubString(String s1, String s2) {
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
            return false;
        }
        return s1.contains(s2);
    }
}
