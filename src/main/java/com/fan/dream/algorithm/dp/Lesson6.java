package com.fan.dream.algorithm.dp;

import java.util.Arrays;

public class Lesson6 {

    public static void main(String[] args) {

        COLOR[][] matrix = {
                {COLOR.BLUE, COLOR.GREEN, COLOR.GREEN, COLOR.GREEN, COLOR.GREEN},
                {COLOR.BLUE, COLOR.GREEN, COLOR.GREEN, COLOR.GREEN, COLOR.GREEN},
                {COLOR.BLUE, COLOR.GREEN, COLOR.GREEN, COLOR.GREEN, COLOR.GREEN},
                {COLOR.BLUE, COLOR.GREEN, COLOR.GREEN, COLOR.GREEN, COLOR.GREEN},
        };
        Lesson6 lesson = new Lesson6();
        lesson.fillColor(matrix, 2, 3, COLOR.GREEN, COLOR.RED);
        for (COLOR[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void fillColor(COLOR[][] matrix, int x, int y, COLOR oldColor, COLOR destColor) {

        if (x > matrix.length - 1 || x < 0 || y > matrix[0].length - 1 || y < 0 || matrix[x][y] != oldColor) {
            return;
        }
        matrix[x][y] = destColor;
        fillColor(matrix, x + 1, y, oldColor, destColor);
        fillColor(matrix, x - 1, y, oldColor, destColor);
        fillColor(matrix, x, y + 1, oldColor, destColor);
        fillColor(matrix, x, y - 1, oldColor, destColor);
    }

    /**
     * 填充颜色 填充颜色
     *
     * @param args
     */
    enum COLOR {
        RED, BLUE, GREEN, YELLOW, PINK

    }
}
