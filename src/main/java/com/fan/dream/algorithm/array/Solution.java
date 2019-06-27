package com.fan.dream.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {


    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0}
        };
        Solution sl = new Solution();
//        sl.construct(grid);
        char c = '0';
        List<Integer> list = new ArrayList<>();
        String test = "a1b2" + c;
//        System.out.println(test.substring(0 + 1));
//        System.out.println(test.substring(0, 0));
        int[] nums = {1, 2, 2, 3, 1};
        //System.out.println(sl.findS808201hortestSubArray(nums));

    }


    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int maxTimes = 0;
        for (int i = 0; i < nums.length; i++) {
            int times = map.get(nums[i]) == null ? 0 : map.get(nums[i]);
            map.put(nums[i], ++times);
            if (times > maxTimes) {
                maxTimes = times;
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) != maxTimes) {
                map.put(key, 0);
            }
        }
        int minLen = nums.length;
        for (int key : map.keySet()) {
            if (map.get(key) != 0) {
                int len = findLongestWidth(nums, key);
                if (len < minLen) {
                    minLen = len;
                }
            }
        }
        return minLen;

    }

    public int findLongestWidth(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (nums[i] != target && i < j) {
            i++;
        }
        while (nums[j] != target && i < j) {
            j--;
        }
        if (i < j) {
            return j - i + 1;
        }
        return -1;
    }

    public Node construct(int[][] grid, int x1, int x2, int y1, int y2) {
        boolean isALlEquals = true;

        if (x1 == x2 && y1 == y2) {
            isALlEquals = true;
        } else {
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    if (grid[i][j] != grid[x1][y1]) {
                        isALlEquals = false;
                        break;
                    }
                }
            }
        }

        Node node = null;
        if (isALlEquals) {
            return new Node(grid[x1][y1] == 1, true, null, null, null, null);
        } else {

            node = new Node();
            node.val = false;
            node.isLeaf = false;
            node.topLeft = construct(grid, x1, (x1 + x2) / 2, y1, (y1 + y2) / 2);
            node.topRight = construct(grid, x1, (x1 + x2) / 2, (y1 + y2) / 2 + 1, y2);
            node.bottomLeft = construct(grid, (x1 + x2) / 2 + 1, x2, y1, (y1 + y2) / 2);
            node.bottomRight = construct(grid, (x1 + x2) / 2 + 1, x2, (y1 + y2) / 2 + 1, y2);
        }
        return node;

    }

    public Node construct(int[][] grid) {
        return construct(grid, 0, grid[0].length - 1, 0, grid.length - 1);
    }

    /**
     * https://leetcode-cn.com/problems/remove-element/
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        while (i < nums.length) {

            if (nums[i] != val && j != i) {
                nums[j++] = nums[i++];
            } else {
                i++;
            }
        }
        return j + 1;
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }
}
