package com.algorithm.old.LeetCode.SuanFa.Day12.Test01;

public class Test {
}


class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode temp = new ListNode(-1);
        ListNode cur = temp;

        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            } else {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }
        }
        if(l1!=null){
            cur.next = l1;
        }
        if(l2!= null){
            cur.next = l2;
        }

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