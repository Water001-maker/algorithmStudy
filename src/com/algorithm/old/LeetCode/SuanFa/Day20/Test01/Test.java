package com.algorithm.old.LeetCode.SuanFa.Day20.Test01;

import java.util.HashMap;
import java.util.Map;

public class Test {


}

class Solution {

    private Map<Integer, Integer> inOrderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        inOrderIndexMap = new HashMap<>();//用来存储中序的值
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, inorder.length - 1, 0, preorder.length - 1);
    }

    /**
     *
     * @param preorder 前序数组
     * @param inLeft 中序的左
     * @param inRight 中序的右
     * @param PreLeft 前序的左
     * @param PreRight 前序的右
     * @return
     */
    public TreeNode buildTree(int[] preorder, int inLeft, int inRight, int PreLeft, int PreRight) {

        if (PreLeft > PreRight || inLeft > inRight) return null;

        int rootValue = preorder[PreLeft];

        TreeNode root = new TreeNode(rootValue);

        int pIndex = inOrderIndexMap.get(rootValue);

        root.left = buildTree(preorder, inLeft, pIndex - 1, PreLeft + 1, PreLeft + pIndex - inLeft);
        root.right = buildTree(preorder, pIndex + 1, inRight, PreLeft + pIndex - inLeft + 1, PreRight);

        return root;

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