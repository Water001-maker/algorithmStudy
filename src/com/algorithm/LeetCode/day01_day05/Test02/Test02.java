package com.algorithm.LeetCode.day01_day05.Test02;

public class Test02 {
    public static void main(String[] args) {

        ListNode l13 = new ListNode(3);
        ListNode l12 = new ListNode(4, l13);
        ListNode l1 = new ListNode(2, l12);

        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(6, l23);
        ListNode l2 = new ListNode(5, l22);

        Solution solution = new Solution();

        ListNode listNode = solution.addTwoNumbers(l1, l2);

        ListNode head = new ListNode();
        head.next = listNode;
        while (head.next != null) {
            System.out.println(head.next.val);
            head = head.next;
        }

    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();//返回的链表
        int total = 0;//值
        int next = 0;//进位
        ListNode temp = result;//指针

        while (l1 != null && l2 != null) {
            total = l1.val + l2.val + next;
            temp.next = new ListNode(total % 10);//只存个位数
            next = total / 10;//存储十位数
            l1 = l1.next;
            l2 = l2.next;
            temp = temp.next;
        }
        while (l1 != null) {
            total = l1.val + next;
            temp.next = new ListNode((total % 10));
            next = total / 10;//存储十位数
            l1 = l1.next;
            temp = temp.next;
        }

        while (l2 != null) {
            total = l2.val + next;
            temp.next = new ListNode((total % 10));
            next = total / 10;//存储十位数
            l2 = l2.next;
            temp = temp.next;
        }

        if (next != 0) {
            temp.next = new ListNode(next);
        }

        return result.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

