package com.algorithm._3_1Stack;

class DListStack {
    private Node top = new Node(0); //栈顶指针
    private int maxSize; //最大长度
    private Node tail; //指向栈底

    //构造器
    public DListStack(int maxsize) {
        this.maxSize = maxsize;
        tail = top;
        for (int i = 0; i < maxsize; i++) {
            Node tmp = new Node(0);//规定0表示没有值
            tail.next = tmp;
            tmp.prev = tail;
            tail = tail.next;
        }
    }

    //栈空
    public boolean isEmpty() {
        if (top.no == 0) {
            return true;
        }
        return false;
    }

    //栈满
    public boolean isFull() {
        return tail == top;
    }

    //遍历打印
    public void list() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return;
        }
        Node tmp = top;
        while (tmp.no != 0) {
            System.out.println(tmp.no);
            tmp = tmp.prev;
        }
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        top = top.next;
        top.no = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            System.out.println("栈已空");
            return 0;
        }
        int no = top.no;
        top = top.prev;
        return no;
    }

}


class Node {
    public int no;
    public Node next;
    public Node prev;

    public Node(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "" + no;
    }
}
