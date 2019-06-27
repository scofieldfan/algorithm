package com.fan.dream.algorithm.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCodeStr {

    public static void main(String[] args) {
        LeetCodeStr lc = new LeetCodeStr();
        //System.out.println(lc.reverseWords("Let's take LeetCode contest"));
//        System.out.println('e' - 'l');
//        System.out.println(lc.romanToInt("IV"));
//        System.out.println(lc.romanToInt("LVIII"));
//        System.out.println(lc.romanToInt("MCMXCIV"));
//        System.out.println(lc.convertToBase7(100));
//        System.out.println(lc.convertToBase7(-7));
//        System.out.println(lc.convertToBase7(14));
//        System.out.println(lc.convertToBase7(0));
        //System.out.println(lc.removeStr("ab#c"));
//        System.out.println(lc.reverseVowels("a.b,."));

//        System.out.println(lc.repeatedSubstringPattern("aabaaba"));
//        System.out.println(lc.repeatedSubstringPattern("abac"));
//        System.out.println(lc.repeatedSubstringPattern("aba"));
//        System.out.println(lc.repeatedSubstringPattern("abab"));
//        System.out.println(lc.repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(' ' >= 'a' && ' ' <= 'z');
        System.out.println(' ' >= '0' && ' ' <= '0');
//        System.out.println(lc.isPalindrome("A man, a plan, a canal: Panama"));
        //System.out.println(lc.strStr("hello", "ll"));
        //System.out.println(lc.strStr("a", "a"));
        System.out.println(lc.strStr("mississippi", "mississippi"));
    }

    public int strStr(String haystack, String needle) {
        int key = 0;
        for (int i = 0; i < needle.length(); i++) {
            key += needle.charAt(i);
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {

            int sum = 0;
            for (int j = i; j < i + needle.length(); j++) {
                sum += haystack.charAt(j);
            }
            if (sum == key) {
                if (isEquals(haystack, needle, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean isEquals(String a, String b, int start) {

        int i = start, j = 0;
        while (i < start + b.length() && j < b.length()) {
            if (a.charAt(i) != b.charAt(j)) {
                return false;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char c1 = Character.toLowerCase(s.charAt(start));
            char c2 = Character.toLowerCase(s.charAt(end));
            if ((c1 >= 'a' && c1 <= 'z') || (c1 >= '0' && c1 <= '9')) {

                if ((c2 >= 'a' && c2 <= 'z') || (c2 >= '0' && c2 <= '9')) {

                    if (c1 == c2) {
                        start++;
                        end--;
                    } else {
                        return false;
                    }
                } else {
                    end--;
                }
            } else {
                start++;
            }
        }
        return true;
    }

    public boolean repeatedSubstringPattern(String s) {

        for (int i = 0; i < s.length() / 2; i++) {

            int start = 0;
            int j = 0;
            boolean isOk = true;
            for (j = i + 1; j < s.length(); j++) {
                if (s.charAt(start) != s.charAt(j)) {
                    isOk = false;
                    break;
                } else {
                    if (start >= i) {
                        start = 0;
                    } else {
                        start++;
                    }
                }
            }
            if (j == s.length() && isOk && start == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public String reverseVowels(String s) {
        char[] inputs = s.toCharArray();

        int i = 0, j = inputs.length - 1;
        while (i < j) {
            while (!isVowel(inputs[i]) && i < j) {
                i++;
            }
            while (!isVowel(inputs[j]) && i < j) {
                j--;
            }
            if (i < j) {
                char temp = inputs[i];
                inputs[i] = inputs[j];
                inputs[j] = temp;
                i++;
                j--;
            }

        }
        return new String(inputs, 0, inputs.length);
    }

    public String removeStr(String S) {
        char[] inputs = S.toCharArray();
        int j = 0;
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] != '#') {
                inputs[j++] = inputs[i];
            } else {
                j--;
            }
        }
        return new String(inputs, 0, j);
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


    public String convertToBase7(int num) {
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(num % 7);
            num = num / 7;
        }
        StringBuffer ret = new StringBuffer();
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i < list.size() - 1) {
                ret.append(Math.abs(list.get(i)));
            } else {
                ret.append(list.get(i));
            }
        }
        return ret.toString();
    }
}
