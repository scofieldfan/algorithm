package com.fan.dream.algorithm.tree;

import java.util.*;

public class Lesson1 {


    public static void main(String[] args) {

    }

    public int rangeSumBST(TreeNode root, int L, int R) {

        if (root == null) {
            return 0;
        }
        int mid = 0;
        int left = rangeSumBST(root.left, L, R);
        if (root.val >= L && root.val <= R) {
            mid += root.val;
        }
        int right = rangeSumBST(root.right, L, R);
        return left + mid + right;
    }

    public List<Integer> postorder(Node root) {

        List<Integer> list = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        Stack<Boolean> isVisited = new Stack<>();
        stack.push(root);
        isVisited.push(false);
        while (!stack.isEmpty()) {
            Node node = stack.peek();
            if (isVisited.peek() == true || node.children == null) {
                list.add(node.val);
                stack.pop();
                isVisited.pop();
            } else if (isVisited.peek() == false) {
                isVisited.pop();
                isVisited.push(true);
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                    isVisited.push(false);
                }
            }
        }
        return list;
    }


    public List<Integer> postorder2(Node root) {

        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        for (Node node : root.children) {
            list.addAll(postorder(node));
        }
        list.add(root.val);
        return list;
    }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            if (node.children != null)
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
        }
        return list;
    }

    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        for (Node node : root.children) {
            list.addAll(preorder(node));
        }
        return list;

    }


    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                if (node.children != null)
                    for (Node child : node.children) {

                        queue.add(child);
                    }
            }
            result.add(list);
        }
        return result;
    }

    /**
     * 1 2 3 => 3 2 1
     * <p>
     * 1 2
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        int min = p.val < q.val ? p.val : q.val;
        int max = p.val < q.val ? q.val : p.val;
        if (root.val > min && root.val < max) {
            return root;
        } else if (root.val <= min) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > max) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return null;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
