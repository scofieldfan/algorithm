package com.fan.dream.algorithm.dp;

public class Lesson3 {

    /**
     * A[i] == i ,被称为魔术索引，给定一个排序好的整数数组，他们各不相同 请找出那个魔术索引
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] array1 = {0, 1, 2, 3, 5, 6, 8, 10};
        int[] array2 = {1, 2, 2, 2, 2, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 16};
        Lesson3 lesson = new Lesson3();
        System.out.println("find the magic index:" + lesson.findMagicIndex(array1, 0, array1.length - 1));
    }


    public int findMagicIndex(int[] array, int start, int end) {

        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] < mid) {
            //左边
            return findMagicIndex(array, start, mid - 1);
        } else {
            //右边
            return findMagicIndex(array, mid + 1, end);
        }

    }
}
