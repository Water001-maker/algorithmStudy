package com.algorithm.newStudy.LinkedList;

/**
 * @author xuemiao
 * @date 2023/1/9 15:08
 * 双向链表实现双端队列
 */
public class DoubleLinkedListToDoque {

    public static class Node<V> {
        public V value;
        public Node last;
        public Node next;

        public Node(V v) {
            value = v;
            last = null;
            next = null;
        }
    }


    public static class MyDeque<V> {
        private Node<V> head;
        private Node<V> tail;
        private int size;

        public MyDeque() {
            size = 0;
            head = null;
            tail = null;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void pushHead(V value) {
            Node<V> cur = new Node<>(value);
            if (head != null) {
                cur.next = head;
                head.last = cur;
                head = cur;
            } else {
                head = cur;
                tail = cur;
            }
            size++;
        }

        public void pushTail(V value) {
            Node<V> cur = new Node<>(value);
            if (head != null) {
                tail.next = cur;
                cur.last = tail;
                tail = cur;
            } else {
                head = cur;
                tail = cur;
            }
            size++;
        }

        public V pollHead() {
            V ans = null;
            if (head == null) {
                return ans;
            }
            size--;
            ans = head.value;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.last = null;
            }
            return ans;
        }

        public V pollTail() {
            V ans = null;
            if (tail == null) {
                return ans;
            }
            size--;
            ans = tail.value;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                tail.next = null;
            }
            return ans;
        }

        public V peekHead() {
            V ans = null;
            if (head != null) {
                ans = head.value;
            }
            return ans;
        }

        public V peekTail() {
            V ans = null;
            if (tail != null) {
                ans = tail.value;
            }
            return ans;
        }

    }

}
