package com.algorithm.LinkedList;

/**
 * @author xuemiao
 * @date 2023/1/9 16:54
 * 两个有序链表的合并
 * <p>
 * 给定两个有序链表的头节点head1和head2,
 * 返回合并之后的大链表，要求依然有序
 * 例子   1->3->3->5->7   2->2->>3->3->7
 * 返回   1->2->2->3->3->3->3->5->7
 *
 * https://leetcode.com/problems/merge-two-sorted-lists
 */
public class MergeTwoSortedLinkedList {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        ListNode head = head1.val >= head2.val ? head2 : head1;
        ListNode cur1 = head.next;//小
        ListNode cur2 = cur1 == head1 ? head2 : head1;//大
        ListNode pre = head;//前置
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }

}
