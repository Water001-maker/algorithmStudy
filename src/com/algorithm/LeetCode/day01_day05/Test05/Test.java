package com.algorithm.LeetCode.day01_day05.Test05;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);

        l1.next = l2;
        l2.next = l3;

        ListNode cur = new ListNode(0);

        cur.next = l1;

        while (cur.next != null) {
            cur = cur.next;
            System.out.println(cur.val);
        }

        Solution solution = new Solution();
        int[] ints = solution.reversePrint(l1);

        System.out.println(Arrays.toString(ints));

        ListNode listNode = solution.reverseList(l1);

        ListNode temp = new ListNode(0);
        temp.next = listNode;

        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp.val);
        }

    }
}


class Solution {
    public int[] reversePrint(ListNode head) {

        ListNode cur = new ListNode(0);
        cur.next = head;//指向前一位
        int count = 0;//计数

        while (cur.next != null) {//获取count的个数
            count++;
            cur = cur.next;
        }

        int[] reverse = new int[count];

        cur = head;//指向头指针

        for (int i = reverse.length - 1; i >= 0; --i) {
            reverse[i] = cur.val;
            cur = cur.next;
        }

        return reverse;
    }

    /*
        public ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode next = null;
        ListNode reverse = null;

        while (cur != null) {//获取count的个数
            next = cur.next;
            cur.next = reverse;
            reverse = cur;
            cur = next;
        }
        return reverse;
    }
    */

    public ListNode reverseList(ListNode head) {

        ListNode reverse = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = reverse;
            reverse = head;
            head = next;
        }
        return reverse;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}