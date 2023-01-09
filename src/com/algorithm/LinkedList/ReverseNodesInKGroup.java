package com.algorithm.LinkedList;

/**
 * @author xuemiao
 * @date 2023/1/9 15:37
 * K各节点的组内逆序调整
 * <p>
 * 给定一个单链表的头节点head,和一个正数k
 * 实现k个节点的小组内部逆序，如果最后一组不够k个就不调整
 * 例子:
 * 调整前: 1->2->3->4->5->6->7->8，k=3
 * 调整后: 3->2->1->6->5->4->7->8
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {

    // 链表
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getKGroupEnd(start, k);
        if (end == null) {
            return head;//第一组都凑不齐
        }
        //第一组凑齐了
        head = end;
        reverse(start, end);
        //上一组的尾节点
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getKGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            //上一组的尾节点指向当前的尾节点
            lastEnd.next = end;
            //上一组的尾节点转换为当前组的首节点
            lastEnd = start;
        }
        return head;
    }


    //返回每一小组的开头，每一小组有k个元素
    public static ListNode getKGroupEnd(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    //反转
    public static void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = start;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

}
