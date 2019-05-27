package com.fan.dream.algorithm.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lesson6 {

    /**
     * M*N的某个元素为0，则将其所在的行与列清零
     *
     * @param args
     */
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {0, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 0}
        };
        Lesson6 l1 = new Lesson6();
        l1.clearZeroMatrix(matrix);
        l1.printMatrix(matrix);
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public void clearZeroMatrix(int[][] matrix) {

        if (matrix == null) {
            return;
        }
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> columns = new HashSet<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                int ele = row[j];
                if (ele == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        setMatrix(matrix, rows, columns);
    }

    public void setMatrix(int[][] matrix, Set<Integer> rows, Set<Integer> columns) {
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            boolean setZero = false;
            if (rows.contains(i)) {
                setZero = true;
            }
            for (int j = 0; j < row.length; j++) {
                if (setZero || columns.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
