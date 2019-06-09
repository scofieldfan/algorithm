package com.fan.dream.algorithm.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode {

    /**
     *
     *
     *
     */
    public static void main(String[] args) {
        LeetCode lc = new LeetCode();
        //System.out.println(lc.toLowerCase("Hello"));
//        String[] inputs = {"Hello", "Alaska", "Dad", "Peace"};
//        System.out.println(Arrays.toString(lc.findWords(inputs)));
//        System.out.println(lc.toUpperCase('A'));
//        System.out.println(lc.toUpperCase('B'));
//        System.out.println(lc.toUpperCase('a'));

        int[] width = {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        System.out.println(lc.numberOfLines(width, "bbbcccdddaaa"));
    }

    public List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<String>();
        int[][] map = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            char[] inputs = A[i].toCharArray();
            int[] mapStr = map[i];
            for (int j = 0; j < inputs.length; j++) {
                char c = inputs[j];
                mapStr[c - 'a']++;
            }

        }

        for (int j = 0; j < 26; j++) {

            boolean isOk = true;
            for (int i = 0; i < A.length - 1; i++) {
                if (map[i][j] != map[i + 1][j]) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                while (map[0][j]-- > 0) {
                    list.add(String.valueOf((char) ('a' + j)));
                }
            }
        }
        return list;
    }

    public String getHint(String secret, String guess) {
        int[] mapSecret = new int[10];
        int[] mapGuess = new int[10];
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                mapSecret[secret.charAt(i)]++;
                mapGuess[guess.charAt(i)]++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cows += Math.min(mapSecret[i], mapGuess[i]);
        }
        return bulls + "A" + cows + "B";

    }

    public int numUniqueEmails(String[] emails) {

        Set<String> set = new HashSet<>();
        for (String email : emails) {

            StringBuffer sb = new StringBuffer();
            boolean isDomain = false;
            boolean ignore = false;
            for (char c : email.toCharArray()) {
                if (c == '@') {
                    isDomain = true;
                }
                if (isDomain) {
                    sb.append(c);
                } else {
                    if (c == '+') {
                        ignore = true;
                    }
                    if (c != '.' && !ignore) {
                        sb.append(c);
                    }
                }
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public String toLowerCase(String str) {
        if (str == null) {
            return "";
        }
        char[] inputs = str.toCharArray();
        for (int i = 0; i < inputs.length; i++) {
            char currentChar = inputs[i];
            if (currentChar >= 'A' && currentChar <= 'Z') {
                char r = (char) ('a' + currentChar - 'A');
                inputs[i] = r;
            }
        }
        return new String(inputs);
    }

    /**
     * @param S
     * @return
     */
    public int[] diStringMatch(String S) {
        if (S == null) {
            return null;
        }
        char[] inputs = S.toCharArray();
        int[] outputs = new int[S.length() + 1];
        int min = 0;
        int max = inputs.length;
        for (int i = 0; i < inputs.length; i++) {
            char c = inputs[i];
            if (c == 'I') {
                outputs[i] = min;
                min++;
            } else {
                outputs[i] = max;
                max--;
            }
        }
        outputs[inputs.length] = min;
        return outputs;
    }

    /**
     * https://leetcode-cn.com/problems/keyboard-row/
     */
    public String[] findWords(String[] words) {
        char[] line1 = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'};
        char[] line2 = {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'};
        char[] line3 = {'Z', 'X', 'C', 'V', 'B', 'N', 'M'};
        Set<Character> set1 = fillSet(line1);
        Set<Character> set2 = fillSet(line2);
        Set<Character> set3 = fillSet(line3);
        List<String> ret = new ArrayList<>();
        for (String word : words) {

            int a = 0, b = 0, c = 0;
            for (int i = 0; i < word.length(); i++) {
                if (set1.contains(toUpperCase(word.charAt(i)))) {
                    a++;
                }
                if (set2.contains(toUpperCase(word.charAt(i)))) {
                    b++;
                }
                if (set3.contains(toUpperCase(word.charAt(i)))) {
                    c++;
                }
                if ((a > 0 && b > 0) || (b > 0 && c > 0) || (a > 0 && c > 0)) {
                    break;
                }
            }
            if (a == word.length() || b == word.length() || c == word.length()) {
                ret.add(word);
            }

        }
        return ret.toArray(new String[ret.size()]);
    }

    private char toUpperCase(char c) {
        if (c >= 'a' && c <= 'z') {
            return (char) ('A' + c - 'a');
        }
        return c;
    }

    private Set<Character> fillSet(char[] inputs) {
        Set<Character> set = new HashSet<>();
        for (char c : inputs) {
            set.add(c);
        }
        return set;
    }

    public int[] numberOfLines(int[] widths, String S) {

        int[] ret = new int[2];
        int width = 0;
        int lines = 0;
        for (char c : S.toCharArray()) {
            width += widths[c - 'a'];
            if (width > 100) {
                lines++;
                width = widths[c - 'a'];
            } else if (width == 100) {
                lines++;
                width = 0;
            }
        }
        ret[0] = lines + 1;
        ret[1] = width;
        //System.out.println(Arrays.toString(ret));
        return ret;
    }
}
