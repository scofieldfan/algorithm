package com.fan.dream.algorithm.array;

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
        sl.construct(grid);
        char c = 'm';
        String test = "a1b2" + c;
        System.out.println(test.substring(0 + 1));
        System.out.println(test.substring(0, 0));

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
