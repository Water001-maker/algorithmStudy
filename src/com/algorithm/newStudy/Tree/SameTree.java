package com.algorithm.newStudy.Tree;

/**
 * @author xuemiao
 * @date 2023/1/10 20:24
 * <p>
 * 判断两棵树结构是否相等
 * https://leetcode.com/problems/same-tree
 */
public class SameTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static boolean sameTree(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null ^ treeNode2 == null) {
            return false;
        }
        if (treeNode1 == null && treeNode2 == null) {
            return false;
        }
        return treeNode1.val == treeNode2.val && sameTree(treeNode1.left, treeNode2.left) && sameTree(treeNode1.right, treeNode2.right);
    }


}
