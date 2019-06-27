package com.fan.dream.algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution so = new Solution();
//        System.out.println(so.letterCasePermutation("a1b2"));
//        String order = "hlabcdefgijkmnopqrstuvwxyz";
//        String[] words = {"step", "steps", "stripe", "stepple"};
//        System.out.println(so.shortestCompletingWord("1s3 PSt", words));
////        System.out.println(so.isAlienSorted(words, order));
//        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        queue.add(1);
//        queue.add(5);
//        queue.add(2);
//        queue.add(-1);
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        char[] test = new char[256];
//        System.out.println(new String());
//        System.out.println(so.countAndSay(6));
//        System.out.println(so.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(so.lengthOfLongestSubstring("bbbbbb"));
//        System.out.println(so.lengthOfLongestSubstring("pwwkew"));
//        System.out.println(so.lengthOfLongestSubstring("tmmzuxt"));
//        System.out.println(so.lengthOfLongestSubstring(" "));
        System.out.println(so.addStrings("123", "456"));
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuffer sb = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        int c = 0;
        while (i >= 0 || j >= 0) {
            int temp1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int temp2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = temp1 + temp2 + c;
            c = sum / 10;
            stack.push((char) ((sum % 10) + '0'));
            i--;
            j--;
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] > 0) {
                start = Math.max(map[s.charAt(i)], start);
            }

            max = Math.max(i - start + 1, max);
            map[s.charAt(i)] = i + 1;
        }
        return max;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int elem;
        for (int i = 0; i < nums.length; i++) {
            elem = nums[i] - 1;
            while (elem < 0) {
                elem += nums.length;
            }
            nums[elem] = nums[elem] - nums.length;
        }
        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 0) {
                ans.add(j + 1);
            }
        }
        return ans;
    }

    public String countAndSay(int n) {
        String str = "1";
        for (int i = 1; i < n; i++) {

            StringBuffer sb = new StringBuffer();
            int num = 0;
            int times = 0;
            for (int j = 0; j < str.length(); j++) {
                int currentNum = str.charAt(j) - '0';
                if (j == 0) {
                    times = 1;
                } else if (currentNum != num) {
                    sb.append(String.valueOf(times) + String.valueOf(num));
                    times = 1;
                } else {
                    times++;
                }
                num = currentNum;
            }
            sb.append(String.valueOf(times) + String.valueOf(num));
            str = sb.toString();
        }
        return str;
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] map = new int[256];

        int min = 0;
        int minStrLength = Integer.MAX_VALUE;
        String minStr = "";
        for (int i = 0; i < licensePlate.length(); i++) {
            int c = Character.toLowerCase(licensePlate.charAt(i));
            if (c >= 'a' && c <= 'z') {
                map[c]++;
                min++;
            }
        }
        for (String word : words) {

            int[] temp = Arrays.copyOf(map, map.length);

            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                int c = Character.toLowerCase(word.charAt(i));
                int times = temp[c];
                if (times > 0) {
                    count++;
                    temp[c]--;
                }
            }
            if (count == min) {
                if (word.length() < minStrLength) {
                    minStrLength = word.length();
                    minStr = word;
                }
            }
        }
        return minStr;
    }

    private void permutate(List<String> result, StringBuffer S, int index) {

        for (int i = index; i < S.length(); i++) {
            char c = S.charAt(i);
            if (Character.isLetter(c)) {
                S.setCharAt(i, Character.toLowerCase(c));
                permutate(result, S, i + 1);
                S.setCharAt(i, Character.toUpperCase(c));
                permutate(result, S, i + 1);
                return;
            }
        }
        result.add(S.toString());
    }


    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        permutate(list, new StringBuffer(S), 0);
        return list;
    }

    /**
     * https://leetcode-cn.com/problems/goat-latin/
     *
     * @param S
     * @return
     */
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        StringBuffer sb = new StringBuffer();
        int wordTimes = 1;
        for (int j = 0; j < words.length; j++) {
            String word = words[j];
            char c = Character.toLowerCase(word.charAt(0));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                sb.append(word);
                sb.append("ma");

            } else {
                StringBuffer wordSb = new StringBuffer(word);
                wordSb.deleteCharAt(0);
                wordSb.append(word.charAt(0));
                wordSb.append("ma");
                sb.append(wordSb.toString());
            }
            for (int i = 0; i < wordTimes; i++) {
                sb.append("a");
            }
            if (j < words.length - 1) {
                sb.append(" ");
            }
            wordTimes++;
        }
        return sb.toString();
    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[256];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i)] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isWordInOrder(map, words[i], words[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public boolean isWordInOrder(int[] map, String word1, String word2) {
        int length = word1.length() < word2.length() ? word1.length() : word2.length();
        for (int i = 0; i < length; i++) {
            if (map[word1.charAt(i)] < map[word2.charAt(i)]) {
                return true;
            } else if (map[word1.charAt(i)] > map[word2.charAt(i)]) {
                return false;
            }
        }
        return true;
    }
}
