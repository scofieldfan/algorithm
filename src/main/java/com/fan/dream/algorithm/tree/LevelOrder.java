package com.fan.dream.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    /**
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                list.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            ret.addFirst(list);
        }
        return ret;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum);
    }

    public boolean dfs(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.val == sum) {
            return true;
        }
        if (sum - root.val < 0) {
            return false;
        }
        return dfs(root.left, sum - root.val) || dfs(root.right, sum - root.val);
    }
}
