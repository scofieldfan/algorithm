package com.fan.dream.algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class LeetCodeStr {

    public static void main(String[] args) {
        LeetCodeStr lc = new LeetCodeStr();
        //System.out.println(lc.reverseWords("Let's take LeetCode contest"));
//        System.out.println('e' - 'l');
        System.out.println(lc.romanToInt("IV"));
        System.out.println(lc.romanToInt("LVIII"));
        System.out.println(lc.romanToInt("MCMXCIV"));
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

    public int romanToInt(String s) {
        int[] map = new int[256];
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("IV", 4);
        map2.put("IX", 9);
        map2.put("XL", 40);
        map2.put("XC", 90);
        map2.put("CD", 400);
        map2.put("CM", 900);

        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (i + 1 < s.length()) {
                if (map[c] < map[s.charAt(i + 1)]) {
                    String key = String.valueOf(new char[]{s.charAt(i), s.charAt(i + 1)});
                    sum += map2.get(key);
                    i += 2;
                } else {
                    sum += map[c];
                    i++;
                }
            } else {
                sum += map[c];
                i++;
            }

        }
        return sum;
    }
}
