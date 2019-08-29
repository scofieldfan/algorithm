package com.fan.dream.algorithm.searching;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Orange {

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};
    Map<Integer, Integer> map = new HashMap<>();
    Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Orange orange = new Orange();
        int[][] grid = {
                {1},
                {2}
        };
        System.out.println(orange.orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    int index = i * grid[0].length + j;
                    queue.add(index);
                    map.put(index, 0);
                }
            }
        int depth = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = code / grid[0].length;
            int c = code % grid[0].length;
            for (int k = 0; k < 4; k++) {
                int newr = r + dr[k];
                int newc = c + dc[k];
                if (newr >= 0 && newr < grid.length && newc >= 0 && newc < grid[0].length && grid[newr][newc] == 1) {
                    int index = newr * grid.length + newc;
                    grid[newr][newc] = 2;
                    queue.add(index);
                    map.put(index, map.get(code) + 1);
                    depth = map.get(index);
                }
            }
        }
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        return depth;
    }
}
