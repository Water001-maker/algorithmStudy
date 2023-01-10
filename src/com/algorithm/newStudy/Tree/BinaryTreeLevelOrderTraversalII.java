package com.algorithm.newStudy.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xuemiao
 * @date 2023/1/10 21:59
 * 二叉树按层遍历并收集结点
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii
 */
public class BinaryTreeLevelOrderTraversalII {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curRes = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                curRes.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            res.add(0,curRes);//因为要倒着手机结果，所以将每一层的数据都加到0位置上
        }
        return res;
    }

}
