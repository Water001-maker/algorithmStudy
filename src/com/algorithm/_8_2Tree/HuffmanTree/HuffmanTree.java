package com.algorithm._8_2Tree.HuffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//赫夫曼树
public class HuffmanTree {

    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};

        Node node = creatHuffmanTree(arr);

        preOrder(node);

    }

    //编写一个前序遍历的方法
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空树");
        }
    }

    //创建赫夫曼树的方法
    public static Node creatHuffmanTree(int[] arr) {
        //第一步为了操作方便
        //1.遍历arr数组
        //2.将arr的每个元素构成一个Node
        //3.将Node放入到ArrayList中
        List<Node> nodes = new ArrayList<Node>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {//最终只剩下一个最大的结点
            //排序（从小到大）,必须让Node实现Comparable接口
            Collections.sort(nodes);

            //取出根节点权值最小的两颗二叉树
            //1.取出权值最小的结点（二叉树）
            Node leftNode = nodes.get(0);
            //2.取出权值第二小的结点（二叉树）
            Node rightNode = nodes.get(1);
            //3.构建一颗新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //4.从ArrayList删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //5.将parent加入到nodes
            nodes.add(parent);
        }
        //返回哈夫曼树的root结点
        return nodes.get(0);
    }

}

//创建结点类
//为了让Node对象持续排序Collections结合排序
//让Node实现Comparable接口
class Node implements Comparable<Node> {
    int value;//结点权值
    Node left;//指向左子结点
    Node right;//指向右子结点

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }

    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //表示从小到大
        return this.value - o.value;
        //return -(this.value - o.value);//表示从大到小
    }
}
