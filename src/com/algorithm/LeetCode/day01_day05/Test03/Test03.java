package com.algorithm.LeetCode.day01_day05.Test03;

import java.util.LinkedList;

public class Test03 {

    public static void main(String[] args) {

    }

}

class CQueue {
    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) return -1;
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
            return stack2.pop();
        }
        return stack2.pop();
    }

}