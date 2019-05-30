package com.fan.dream.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

public class Lesson4 {


    private static int[] array = {1, 2, 3, 4, 5};

    /**
     * 打印字符串的排列组合
     *
     * @param args
     */
    public static void main(String[] args) {

        Lesson4 lesson = new Lesson4();
        int[] used = new int[array.length];
        List<String> list = lesson.permutate(array.length, used);
        System.out.println(list.toString());

        List<String> combs = lesson.combination(4);
        System.out.println(combs.toString());
    }


    public List<String> combination(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) {
            list.add("");
            return list;
        }
        List<String> combs = combination(n - 1);
        list.addAll(combs);
        for (String str : combs) {
            list.add(str + String.valueOf(array[n - 1]));
        }
        return list;
    }

    public List<String> permutate(int n, int[] used) {

        List<String> list = new ArrayList<>();
        if (n == 0) {
            return list;
        }
        for (int i = 0; i < array.length; i++) {
            if (used[i] == 0) {
                used[i] = 1;
                List<String> nResult = permutate(n - 1, used);
                if (nResult.size() == 0) {
                    list.add(String.valueOf(array[i]));
                } else
                    for (String str : nResult) {
                        list.add(str + String.valueOf(array[i]));
                    }
                used[i] = 0;
            }
        }
        return list;
    }
}
