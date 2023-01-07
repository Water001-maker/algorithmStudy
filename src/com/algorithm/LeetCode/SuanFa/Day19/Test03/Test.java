package com.algorithm.LeetCode.SuanFa.Day19.Test03;

public class Test {

}

class Solution {

    private TreeNode ans;

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if ((left && right) || ((root.val == p.val || root.val == q.val) && (left || right))) {
            ans = root;
        }
        return left || right || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }


    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode l = lowestCommonAncestor1(root.left, p, q);
        TreeNode r = lowestCommonAncestor1(root.right, p, q);

        return l == null ? r : (r == null ? l : root);
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