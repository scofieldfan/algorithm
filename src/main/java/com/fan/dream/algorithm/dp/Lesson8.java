package com.fan.dream.algorithm.dp;

import java.util.Arrays;

public class Lesson8 {

    private int solutions = 0;

    /**
     * @param args
     */
    public static void main(String[] args) {

        int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        Lesson8 lesson = new Lesson8();
        lesson.printEightQueen(matrix, 0);
    }

    public boolean isCanPlace(int x, int y, int[][] matrix) {

        boolean ret = true;
        for (int i = 0; i < x; i++) {
            //System.out.println("x:" + x + " y:" + y);
            if (matrix[i][y] != 0) {
                return false;
            }
        }
        for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
            if (matrix[i][j] != 0) {
                return false;
            }
        }
        for (int i = x, j = y; j < matrix.length && i >= 0; i--, j++) {
            if (matrix[i][j] != 0) {

                return false;
            }
        }
        return ret;
    }

    public void printEightQueen(int[][] matrix, int n) {

        if (n == matrix.length) {
            for (int i = 0; i < matrix.length; i++) {
                System.out.println(Arrays.toString(matrix[i]));
            }
            solutions++;
            System.out.println("************************************** solutions:" + solutions);
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (isCanPlace(n, i, matrix)) {
                matrix[n][i] = 1;
                printEightQueen(matrix, n + 1);
                matrix[n][i] = 0;
            }
        }

    }
}
