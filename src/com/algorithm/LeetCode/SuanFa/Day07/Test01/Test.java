package com.algorithm.LeetCode.SuanFa.Day07.Test01;

public class Test {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(2);

        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(1);

        treeNode1.left = treeNode2;
        treeNode2.left = treeNode4;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode5;

        treeNode6.left = treeNode7;

        Solution solution = new Solution();
        System.out.println(solution.isSubStructure(treeNode1, treeNode6));

    }
}

class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if (A == null || B == null) {
            return false;
        }
        if (A.val == B.val && dfs(A, B)) {
            return true;
        }

        return isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    public boolean dfs(TreeNode A, TreeNode B) {

        if (A == null || B == null) {
            return B == null;
        }

        if (A.val != B.val) {
            return false;
        }

        return dfs(A.left, B.left) && dfs(A.right, B.right);

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