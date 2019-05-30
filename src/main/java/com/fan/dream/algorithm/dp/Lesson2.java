package com.fan.dream.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

public class Lesson2 {

    private Map<Point, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        Lesson2 lesson = new Lesson2();
        int[][] matrix = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        System.out.println(lesson.move(matrix, 2, 2));
    }

    public int move(int[][] matrix, int x, int y) {
        if (x == 0 && y == 0) {
            return 1;
        }
        if (x > matrix[0].length - 1 || x < 0 || y < 0 || y > matrix.length - 1) {
            return 0;
        }
        Point point = new Point(x, y);
        if (map.get(point) != null) {
            return map.get(point);
        }
        int ret = move(matrix, x - 1, y) + move(matrix, x, y - 1);
        map.put(point, ret);
        return ret;
    }

    /**
     * 摄像有个机器人坐在X*Y网格的左上角，只能向右，向下移动，请问机器人有多少种走法
     *
     * @param args
     */
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
