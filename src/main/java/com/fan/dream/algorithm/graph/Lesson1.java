package com.fan.dream.algorithm.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Lesson1 {

    /**
     * DFS
     * BFS
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    public void visited(int x, int y) {
    }

    public void DFS(int[][] matrix, int x, int y, int[][] visited) {

        List<Point> neighbors = genPoints();
        for (Point neighbor : neighbors) {
            int pointX = neighbor.x;
            int pointY = neighbor.y;
            if (visited[pointX][pointY] != 1) {
                visited[pointX][pointY] = 1;
                DFS(matrix, pointX, pointY, visited);
                visited[pointX][pointX] = 0;
            }
        }
    }

    public List<Point> genPoints() {
        return new ArrayList<Point>();
    }

    public void BFS(int[][] matrix, int x, int y, int[][] visited) {
        Queue<Point> queue = new LinkedBlockingQueue<>();
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point point = queue.remove();
            visited[x][y] = 1;
            queue.addAll(genPoints());//添加当前节点的所有neighbors
        }
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
