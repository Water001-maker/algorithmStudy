package com.algorithm.LeetCode.SuanFa.Day06.Test03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.right = treeNode5;

        Solution solution = new Solution();
        List<List<Integer>> lists = solution.levelOrder(treeNode1);

        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }

    }

}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        int count = 1;//计数器（判断层数）
        Queue<TreeNode> queue = new LinkedList<TreeNode>();//存储队列
        ArrayList<List<Integer>> list = new ArrayList<>();//集合
        if (root != null) queue.add(root);//存放头结点
        while (!queue.isEmpty()) {//退出循环条件
            LinkedList<Integer> temp = new LinkedList<Integer>();//用来存放每层的元素
            for (int i = queue.size(); i > 0; i--) {//循环次数
                TreeNode node = queue.poll();//取得当前的root值
                if (count % 2 == 0) temp.addLast(node.val);//加到分层到链表尾部（逆序输出）
                else temp.addFirst(node.val);//加到分层到链表头部（正序输出）
                if (node.right != null) queue.add(node.right);
                if (node.left != null) queue.add(node.left);
            }
            list.add(temp);//把每层元素存放入队列
            count++;
        }
        return list;//返回结果集
    }

    //递归解法
    private List<List<Integer>> ret;

    public List<List<Integer>> levelOrder2(TreeNode root) {
        ret = new ArrayList<>();
        dfs(0, root);
        return ret;
    }

    private void dfs(int depth, TreeNode root) {
        if (root == null) {
            return;
        }

        if (ret.size() == depth) {
            ret.add(new ArrayList<>());
        }

        ret.get(depth).add(root.val);
        dfs(depth + 1, root.left);
        dfs(depth + 1, root.right);
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