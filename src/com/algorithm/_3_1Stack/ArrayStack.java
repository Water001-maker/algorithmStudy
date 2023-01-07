package com.algorithm._3_1Stack;

class ArrayStack{
    private int maxSize;//栈的大小
    private int[] stack;//数组，模拟栈，用来存放数据
    private int top = -1; //栈顶元素，初始时指向栈地的上一位

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull(){
        return  top == maxSize-1;
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int value){
        //先判断是否栈满
        if(isFull()){
            System.out.println("栈已满，不能再放数据");
            return;
        }
        top ++;
        stack[top] = value;
    }

    //出栈
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空，没有数据");
        }
        int tmp = stack[top];
        top--;
        return tmp;
    }

    //遍历栈,遍历时从栈底开始遍历
    public void list(){
        if(isEmpty()){
            System.out.println("栈空");
            return;
        }
        for(int i = top; i >= 0; i--){
            System.out.printf("stack["+i+"]="+stack[i]);
        }
    }
}