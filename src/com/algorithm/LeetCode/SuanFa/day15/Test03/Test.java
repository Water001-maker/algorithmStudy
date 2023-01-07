package com.algorithm.LeetCode.SuanFa.day15.Test03;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(5);

        root.left = root1;
        root.right = root4;
        root1.left = root2;
        root1.right = root3;

        Solution solution = new Solution();
        int i = solution.kthLargest(root, 2);

        System.out.println(i);

    }

}


class Solution {

    private int res = 0, count = 0;

    public int kthLargest(TreeNode root, int k) {
        order(root, k);
        return res;
    }

    public void order(TreeNode node, int k) {
        if (node.right != null) order(node.right, k);

        if (++count == k) {
            res = node.val;
            return;
        }

        if (node.left != null) order(node.left, k);
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