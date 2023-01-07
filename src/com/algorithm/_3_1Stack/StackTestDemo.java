package com.algorithm._3_1Stack;

import java.util.Scanner;

public class StackTestDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        DListStack dListStack = new DListStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show：表示显示栈");
            System.out.println("exit：表示退出程序");
            System.out.println("push：表示入栈");
            System.out.println("pop：表示出栈");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "show":
                    //arrayStack.list();
                    dListStack.list();
                    break;
                case "exit":
                    if (scanner != null) {
                        scanner.close();
                    }
                    loop = false;
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    //arrayStack.push(value);
                    dListStack.push(value);
                    break;
                case "pop":
                    try {
                        //int res = arrayStack.pop();
                        int res = dListStack.pop();
                        System.out.println("出栈的元素是" + res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
}