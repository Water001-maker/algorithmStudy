package com.algorithm.newStudy.LinkedList;

/**
 * @author xuemiao
 * @date 2023/1/9 13:49
 * 单链表的反转
 */
public class ReverseList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            value = data;
        }
    }

    /**
     * 单链表的反转
     *
     * @param head
     * @return
     */
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 双向链表的反转
     *
     * @param head
     * @return
     */
    public static DoubleNode reverseDoubleLinkedList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1.next.next.next = new Node(4);
        while (n1 != null) {
            System.out.println(n1.value);
            n1 = n1.next;
        }

        System.out.println("————————————————————");

        DoubleNode n2 = new DoubleNode(1);
        n2.next = new DoubleNode(2);
        n2.next.next = new DoubleNode(3);
        n2.next.next.next = new DoubleNode(4);
        n2.next.next.next.last = n2.next.next;
        n2.next.next.last = n2.next;
        n2.next.last = n2;

        while (n2!=null){
            System.out.println(n2.value);
            n2 = n2.next;
        }
        /*
        n2 = n2.next.next.next;
        while (n2 != null) {
            System.out.println(n2.value);
            n2 = n2.last;
        }
        */


    }

}
