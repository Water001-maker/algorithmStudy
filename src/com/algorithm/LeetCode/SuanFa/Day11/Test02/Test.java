package com.algorithm.LeetCode.SuanFa.Day11.Test02;


import java.util.List;

public class Test {


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);

        Solution solution = new Solution();

        ListNode listNode = solution.getKthFromEnd(head, 2);

        ListNode temp = listNode;

        while (temp.next != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }

}

class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode cur = head;

        while (cur.next != null && k > 0) {
            cur = cur.next;

            if (k == 0) {
                head = head.next;
            }else {
                k--;
            }

        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}