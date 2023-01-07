package com.algorithm.LeetCode.SuanFa.day15.Test01;

import java.util.*;

public class Test {

/**/    public static void main(String[] args) {

        TreeNode root = new TreeNode(-2);
        TreeNode node1 = new TreeNode(-3);
/*        TreeNode node2 = new TreeNode(11);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(13);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(1);*/

        root.right = node1;
/*        node1.left=node2;
        node2.left=node3;
        node2.right=node4;
        root.right=node5;
        node5.left=node6;
        node5.right=node7;
        node7.left=node8;
        node7.right=node9;*/

        Solution solution = new Solution();
        List<List<Integer>> lists = solution.pathSum(root, -2);

        String string = Arrays.toString(lists.toArray());

        System.out.println(string);

    }

}

class Solution {

    List<List<Integer>> res = new ArrayList<List<Integer>>();//初始化
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return res;
    }

    public void dfs(TreeNode root, int target) {
        if (root == null) return;
        list.add(root.val);
        target -= root.val;
        //回溯
        if (root.left == null && root.right == null && target==0) {
            res.add(new ArrayList<>(list));
        }
        //递归前把路径值放入列表中
        dfs(root.left, target);
        dfs(root.right, target);
        //还原现场
        list.remove(list.size() - 1);
        return;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}