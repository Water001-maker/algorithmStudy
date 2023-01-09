package com.algorithm.LinkedList;

import java.util.List;

/**
 * @author xuemiao
 * @date 2023/1/9 16:16
 * 两个链表相加
 * <p>
 * 给定两个链表的头节点head1和head2,
 * 认为从左到右是某个数字从低位到高位，返回相加之后的链表
 * 例子  4->3->6  2->5->3
 * 返回  6->8->9
 * 解释  634+352=986
 *
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    // 链表
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        int len1 = listLength(head1);
        int len2 = listLength(head2);

        //长链表是l，短链表是s
        ListNode l = len1 >= len2 ? head1 : head2;
        ListNode s = l == head1 ? head2 : head1;

        ListNode curl = l;
        ListNode curs = s;
        ListNode last = curl;

        int carry = 0;//进位信息
        int curNum = 0;//当前值

        while (curs != null) {//长短都有时
            curNum = curl.val + curs.val + carry;
            curl.val = (curNum % 10);
            last = curl;
            curl = curl.next;
            curs = curs.next;
        }
        while (curl != null) {//短结束，长有时
            curNum = curl.val + carry;
            curl.val = (curNum % 10);
            carry = curNum / 10;
            last = curl;
            curl = curl.next;
        }
        if (curl != null) {//都结束，但还有进位
            last.next = new ListNode(1);
        }
        return l;
    }


    //求链表长度
    public static int listLength(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
