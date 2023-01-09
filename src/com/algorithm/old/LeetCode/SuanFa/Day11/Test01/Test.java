package com.algorithm.old.LeetCode.SuanFa.Day11.Test01;

public class Test {

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(9);

        head.next = l1;
        l1.next = l2;
        l2.next = l3;

        Solution solution = new Solution();
        ListNode listNode = solution.deleteNode(head, 1);

        ListNode temp = listNode;
        while (temp.next != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }

}

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return head;

        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode cur = temp;

        while (cur.next.val != val) {
            cur = cur.next;
        }
        cur.next = cur.next.next;

        return temp.next;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}