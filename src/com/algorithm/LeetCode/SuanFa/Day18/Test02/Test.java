package com.algorithm.LeetCode.SuanFa.Day18.Test02;

public class Test {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);

        root.right = root1;
        root.left = root2;
        root2.left = root4;
        root2.right = root3;

        Solution solution = new Solution();

        boolean balanced = solution.isBalanced(root);

        System.out.println(balanced);

    }

}

class Solution {
    public boolean isBalanced(TreeNode root) {
        return root == null || (Math.abs(maxDepth(root.right) - maxDepth(root.left)) <= 1 && isBalanced(root.right) && isBalanced(root.left));
    }

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /*
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
    */

    public boolean isBalanced2(TreeNode root) {
        return dfs(root) == -1 ? false : true;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);

        if (left == -1) return -1;
        if (right == -1) return -1;

        return Math.abs(right - left) < 2 ? Math.max(left, right) + 1 : -1;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}