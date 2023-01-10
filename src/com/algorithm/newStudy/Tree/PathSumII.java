package com.algorithm.newStudy.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuemiao
 * @date 2023/1/10 23:33
 * 收集达标路径和
 * https://leetcode.com/problems/path-sum-ii
 */
public class PathSumII {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }


    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ArrayList<Integer> path = new ArrayList<>();
        process(root, path, 0, sum, ans);
        return ans;
    }

    private static void process(TreeNode x, ArrayList<Integer> path, int preSum, int sum, List<List<Integer>> ans) {

        //叶子节点
        if (x.left == null && x.right == null) {
            if (x.val + preSum == sum) {
                path.add(x.val);
                ans.add(copy(path));//将刚刚获取的达标路径和保存，此处不能直接存储，因为path集合之后会改变，需要拷贝后存储
                path.remove(path.size() - 1);//递归返回到上一层时，不应该存在刚刚加的元素
            }
            return;
        }

        //非叶子节点
        path.add(x.val);
        preSum += x.val;
        if (x.right != null) {
            process(x.right, path, preSum, sum, ans);
        }
        if (x.left != null) {
            process(x.left, path, preSum, sum, ans);
        }
        path.remove(path.size() - 1);//递归返回到上一层时，不应该存在刚刚加的元素，把自己删掉
    }


    public static List<Integer> copy(List<Integer> path) {
        List<Integer> copy = new ArrayList<>();
        for (Integer num : path) {
            copy.add(num);
        }
        return copy;
    }

}
