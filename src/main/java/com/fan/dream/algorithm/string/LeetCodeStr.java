package com.fan.dream.algorithm.string;

public class LeetCodeStr {

    public static void main(String[] args) {
        LeetCodeStr lc = new LeetCodeStr();
        //System.out.println(lc.reverseWords("Let's take LeetCode contest"));
        System.out.println('e' - 'l');
    }

    public String reverseWords(String s) {
        char[] inputs = s.toCharArray();
        int start = 0;

        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] == ' ') {
                reverseString(inputs, start, i - 1);
                start = i + 1;
            }
        }
        reverseString(inputs, start, inputs.length - 1);
        return new String(inputs);
    }

    private void reverseString(char[] A, int start, int end) {


        for (int i = start, j = end; i < j; i++, j--) {
            char temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }

    }
}
