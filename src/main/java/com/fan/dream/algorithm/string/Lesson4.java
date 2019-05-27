package com.fan.dream.algorithm.string;

public class Lesson4 {

    /**
     * 利用字符串的出现次数编写一个方法，实现基本字符串压缩功能，'aabcccccaaa'，输出a2b1c5a2
     * 如果压缩后字符串的长度没有变短，则返回原始字符串
     *
     * @param args
     */
    public static void main(String[] args) {
        String case1 = "aabcccccaaa";
        Lesson4 l1 = new Lesson4();
        System.out.println(l1.compactString(case1));
    }

    public String compactString(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return "";
        }

        char[] inputArray = inputString.toCharArray();
        int i = 0;
        int count = 0;
        char lastChar = '\0';
        StringBuffer sb = new StringBuffer();
        while (i < inputArray.length) {
            char currentChar = inputArray[i];
            if (currentChar != lastChar && i > 0) {
                System.out.println("lastChar:" + lastChar + " count:" + count);
                sb.append(lastChar);
                sb.append(count);
                count = 0;
            }
            lastChar = currentChar;
            count++;
            i++;
        }
        sb.append(lastChar);
        sb.append(count);
        String ret = sb.toString();
        return ret.length() < inputString.length() ? ret : inputString;
    }
}
