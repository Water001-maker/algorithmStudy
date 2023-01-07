package com.algorithm.LeetCode.SuanFa.day15.Test02;

import javax.swing.plaf.IconUIResource;

public class Test {

    public static void main(String[] args) {

        Node root = new Node(4);
        Node root1 = new Node(2);
        Node root2 = new Node(1);
        Node root3 = new Node(3);
        Node root4 = new Node(5);

        root.left = root1;
        root.right = root4;
        root1.left = root2;
        root1.right = root3;

        Solution solution = new Solution();
        Node node = solution.treeToDoublyList(root);

        System.out.println(node);

    }

}


class Solution {

    Node head,pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        threade(root);
        //前驱结点指向头结点
        pre.right = head;
        //头结点的左指针指向前驱结点
        head.left = pre;

        return head;
    }

    //中序线索化
    public void threade(Node node) {
        //如果node为空，不能线索化
        if (node == null) return;

        //线索化左子树
        threade(node.left);

        //处理当前节点
        //若头节点为空
        if (head == null) {
            //将头结点指向前驱结点
            head = node;
            //前驱结点指向当前结点
            pre = node;
        } else {//若头节点不为空
            //前驱结点的右指针指向当前结点
            pre.right = node;
            //让当前节点的左指针指向指向前驱节点
            node.left = pre;
            //前驱结点指向当前结点
            pre = node;
        }

        //线索化右子树
        threade(node.right);
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};