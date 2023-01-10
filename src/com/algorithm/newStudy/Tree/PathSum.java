package com.algorithm.newStudy.Tree;

/**
 * @author xuemiao
 * @date 2023/1/10 23:15
 * <p>
 * 能否组成路径和
 * https://leetcode.com/problems/path-sum
 */
public class PathSum {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSum = false;

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        isSum = false;
        process(root, 0, sum);
        return isSum;
    }

    public static void process(TreeNode x, int preSum, int sum) {
        if (x.left == null && x.right == null) {
            if (x.val + preSum == sum) {
                isSum = true;
            }
            return;
        }

        preSum += x.val;
        if (x.right != null) {
            process(x.right, preSum, sum);
        }
        if (x.left != null) {
            process(x.left, preSum, sum);
        }
    }

}
