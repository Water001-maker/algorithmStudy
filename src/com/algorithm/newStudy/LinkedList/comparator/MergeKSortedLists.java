package com.algorithm.newStudy.LinkedList.comparator;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xuemiao
 * @date 2023/1/10 19:53
 * <p>
 * 合并K个升序链表
 * 测试链接：https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static class ListNodeCodeComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        //会默认最小的在上面
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new ListNodeCodeComparator());
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        if (queue.isEmpty()) {
            return null;
        }
        //定义一个头结点
        ListNode head = queue.poll();
        ListNode pre = head;
        //将头结点后的下一个节点存入小根堆中
        if (pre.next != null) {
            queue.add(pre.next);
        }
        while (!queue.isEmpty()) {
            ListNode cur = queue.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null) {
                queue.add(cur.next);
            }
        }
        return head;
    }

}
