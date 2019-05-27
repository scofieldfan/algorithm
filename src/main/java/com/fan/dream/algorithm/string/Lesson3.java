package com.fan.dream.algorithm.string;

public class Lesson3 {

    /**
     * 编写一个方法，将字符串的空格全部替换为20%，
     */
    public static void main(String[] args) {
        String case1 = "Mr John Smith ";
        Lesson3 l1 = new Lesson3();
        System.out.println(l1.encodeSpace(case1, 20));
    }

    public String encodeSpace(String input, int length) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        char[] inputArray = input.toCharArray();
        char[] outputArray = new char[length];
        int i = inputArray.length - 1;
        int j = length - 1;
        while (i >= 0 && j >= 0) {

            char currentChar = inputArray[i];
            if (currentChar == ' ') {
                outputArray[j] = '0';
                outputArray[j - 1] = '2';
                outputArray[j - 2] = '%';
                j -= 3;
            } else {
                outputArray[j] = currentChar;
                j--;
            }
            i--;
        }

        if (i != -1 || j != -1) {
            return "error!!!!!! i:" + i + " J:" + j;
        }
        return new String(outputArray);
    }
}
