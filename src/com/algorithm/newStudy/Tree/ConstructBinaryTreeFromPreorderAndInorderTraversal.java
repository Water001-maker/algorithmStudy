package com.algorithm.newStudy.Tree;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;

/**
 * @author xuemiao
 * @date 2023/1/10 21:12
 * 用先序和中序重建一个树
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        return f(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public static TreeNode f(int[] pre, int L1, int R1, int[] in, int L2, int R2) {
        if (L1 > R1) {//避免子树为空
            return null;
        }
        TreeNode head = new TreeNode(pre[1]);//通过先序获取根节点
        if (L1 == R1) {
            return head;
        }
        int find = L2;//用来标记中序中根节点的位置
        while (in[find] != pre[L1]) {
            find++;
        }
        //先：1 245 367
        //中：425 1 637
        head.left = f(pre, L1 + 1, L1 + find - L2, in, L2, find - 1);//L1 + find - L2  =》 x - (L1+1) = find-1 - L2
        head.right = f(pre, L1 + find - L2 + 1, R1, in, find + 1, R2);
        return head;
    }

    public static TreeNode buildTree2(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        HashMap<Integer, Integer> valueIndexMap = new HashMap<>();//标记根节点的位置
        for (int i = 0; i < in.length; i++) {
            valueIndexMap.put(in[i], i);
        }
        return g(pre, 0, pre.length - 1, in, 0, in.length - 1, valueIndexMap);
    }


    // 去除掉遍历查找根节点的行为
    public static TreeNode g(int[] pre, int L1, int R1, int[] in, int L2, int R2,
                             HashMap<Integer, Integer> valueIndexMap) {
        if (L1 > R1) {
            return null;
        }
        TreeNode head = new TreeNode(pre[L1]);
        if (L1 == R1) {
            return head;
        }
        int find = valueIndexMap.get(pre[L1]);
        head.left = g(pre, L1 + 1, L1 + find - L2, in, L2, find - 1, valueIndexMap);
        head.right = g(pre, L1 + find - L2 + 1, R1, in, find + 1, R2, valueIndexMap);
        return head;
    }


}
