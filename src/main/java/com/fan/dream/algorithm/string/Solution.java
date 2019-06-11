package com.fan.dream.algorithm.string;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.letterCasePermutation("a1b2"));
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
}
