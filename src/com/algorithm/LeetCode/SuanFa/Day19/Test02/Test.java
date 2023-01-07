package com.algorithm.LeetCode.SuanFa.Day19.Test02;

public class Test {


}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;

        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);//说明p，q都在左子树
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);//说明p，q都在右子树

        return root;//一个在左，一个在右，那么当前就是最近的共同祖先

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