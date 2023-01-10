package com.algorithm.newStudy.Tree;

/**
 * @author xuemiao
 * @date 2023/1/10 22:50
 * 判断是否是搜索二叉树（特点：左子树<根节点<右子树）
 * 方法一：中序遍历递增
 * 方法二：递归
 */
public class IsBinarySearchTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Info {
        public boolean isBST;
        public int max;
        public int min;

        public Info(boolean is, int ma, int mi) {
            isBST = is;
            max = ma;
            min = mi;
        }
    }

    public static Info process(TreeNode x) {
        if (x == null) {
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int max = x.val;
        int min = x.val;
        if (leftInfo != null) {
            max = Math.max(leftInfo.max, max);
            min = Math.min(leftInfo.min, min);
        }
        if (rightInfo != null) {
            max = Math.max(rightInfo.max, max);
            min = Math.min(rightInfo.min, min);
        }

        boolean isBST = true;
        boolean leftIsBst = leftInfo == null ? true : leftInfo.isBST;
        boolean rightIsBst = rightInfo == null ? true : rightInfo.isBST;
        boolean leftMin = leftInfo == null ? true : (leftInfo.max < x.val);
        boolean rightMax = rightInfo == null ? true : (rightInfo.max > x.val);
        if (!(leftIsBst && rightIsBst && leftMin && rightMax)) {
            isBST = false;
        }
        return new Info(isBST, max, min);
    }

}
