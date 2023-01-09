package com.algorithm.old.LeetCode.day01_day05.Test06;

public class Test {
    public static void main(String[] args) {

        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        Node node6 = null;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        node1.random = node6;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        Solution solution = new Solution();

/*
        Node temp = node1;

        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
*/

        Node node = solution.copyRandomList(node1);

        Node temp = node;

        while (temp != null) {
            System.out.println(temp.val);
            if(temp.random == null){
                System.out.println("null");
            }else {
                System.out.println(temp.random.val);
            }
            temp = temp.next;
            System.out.println();
        }

    }
}

class Solution {
    public Node copyRandomList(Node head) {

        //非空判断
        if (head == null) {
            return head;
        }

        Node copyNode = null;//复制链表
        Node cur = null;//当前链表的指针
        Node curCopy = null;//复制链表的指针

        //链表赋值
        cur = head;
        while (cur != null) {
            copyNode = new Node(cur.val);//复制一份
            copyNode.next = cur.next;
            cur.next = copyNode;
            cur = cur.next.next;//后移
        }

        //赋random值
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        //分开
        cur = head;
        copyNode = head.next;
        curCopy = head.next;
        while (cur != null) {
            //将copyNode结点删除
            cur.next = cur.next.next;
            cur = cur.next;//后移
            if (curCopy.next != null) {
                //将node结点删除
                curCopy.next = curCopy.next.next;
                curCopy = curCopy.next;//后移
            }
        }
        return copyNode;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}