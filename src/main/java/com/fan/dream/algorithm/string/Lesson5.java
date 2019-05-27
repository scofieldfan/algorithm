package com.fan.dream.algorithm.string;

import java.util.Arrays;

public class Lesson5 {
    /**
     * 将N*N的矩阵旋转90°
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };
        Lesson5 l1 = new Lesson5();
        l1.rotateMatrix90(matrix);
        l1.printMatrix(matrix);
    }

    /**
     * 计算出这个矩阵的转置
     *
     * @param matrix
     */
    public void transpose(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int N = matrix.length;
        for (int i = 0; i < N; i++)
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
    }

    public void moveStartEnd(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < Math.floor(N / 2); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N - j - 1];
                matrix[i][N - j - 1] = temp;
            }
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public void rotateMatrix90(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        transpose(matrix);
        moveStartEnd(matrix);

    }
}
