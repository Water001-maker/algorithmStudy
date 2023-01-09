package com.algorithm.old._3_3polandComputer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 最简单的计算器实现
 */
public class PolandNotation1 {

    public static void main(String[] args) {
        //(3+4)×5-6   -->    3 4 + 5 × 6 -
        //将逆波兰表达式的数字和符号用空格分开
        String suffExpression = "3 4 + 5 x 6 -";
        //String suffExpression = "4 5 x 8 - 60 + 8 2 / +";//4*5-8+60+8/2

        //将逆波兰表达式存放在ArrayList中
        List<String> lst = getListString(suffExpression);
        System.out.println(lst);

        //计算逆波兰表达式
        int result = calculate(lst);
        System.out.println("逆波兰表达式的结果为:" + result);
    }

    //将一个逆波兰表达式存放在ArrayList中
    public static List<String> getListString(String suffixExpression) {
        //将suffixExpression分割
        String[] arr = suffixExpression.split(" ");
        List<String> lst = new ArrayList<>();
        for (String item : arr) {
            lst.add(item);
        }
        return lst;
    }

    //对逆波兰表达式的计算
    public static int calculate(List<String> lst) {
        //定义一个栈
        Stack<String> stack = new Stack<>();
        for (String lst1 : lst) {
            if (lst1.matches("\\d+"))//利用正则表达式来取值，匹配的是多位数
            {
                stack.push(lst1);
            } else {
                //弹出两个数进行运算
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (lst1.equals("+")) {
                    res = num1 + num2;
                } else if (lst1.equals("-")) {
                    res = num1 - num2;
                } else if (lst1.equals("x")) {
                    res = num1 * num2;
                } else if (lst1.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //res入栈
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }

}