package com.algorithm.old._3_3polandComputer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中缀表达式转换后缀表达式——逆波兰计算器
 */
public class PolandNotation2 {
    public static void main(String[] args) {

        //将中缀表达式转成对应的list
        String expression = "(3+4)x5-6";
        List<String> infisExpressionList = toInfixExpressionList(expression);

        List<String> parseSuffixExpressionList = ParseSuffixExpressionList(infisExpressionList);

        System.out.println(parseSuffixExpressionList);

        int result = calculate(parseSuffixExpressionList);
        System.out.println("逆波兰表达式的结果为:" + result);

    }

    //将得到的中缀表达式对应的list转换为对应的后缀表达式
    public static List<String> ParseSuffixExpressionList(List<String> list) {
        //定义两个栈
        //定义一个栈用来装符号
        Stack<String> stack1 = new Stack<String>();//符号栈
        //因为在整个过程中，s2没有pop操作，并且在最终需要逆序输出，所以直接用List来代替
        //再定义一个List，用来存储中间结果
        List<String> stack2 = new ArrayList<String>();//存储中间结果的List

        //遍历list
        for (String item : list) {
            if (item.matches("\\d+")) {
                //如果是一个数字，加入S2
                stack2.add(item);
            } else if (item.equals("(")) {
                //如果是左括号“(”，则直接压入s1
                stack1.push(item);
            } else if (item.equals(")")) {
                //如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到"("为止，此时将这一对括号丢弃
                while (!stack1.peek().equals("(")) {
                    stack2.add(stack1.pop());
                }
                stack1.pop();//将“（”弹出
            } else {
                //当item的优先级小于等于s1栈顶的运算符，将s1栈顶的元素运算符弹出并压到s2中，在此与s1中新的栈顶运算符相比较
                //问题：我们缺少一个比较优先级高低的方法
                //Operation：用于比较运算符优先级高低
                while (stack1.size() != 0 && Operation.getValue(stack1.peek()) >= Operation.getValue(item)) {
                    stack2.add(stack1.pop());
                }
                //还需要将item压入栈
                stack1.push(item);
            }
        }
        //将s1中剩余的运算符一次性弹出并加入到s2
        while (stack1.size() != 0) {
            stack2.add(stack1.pop());
        }
        return stack2;
    }

    //将中缀表达式转成对应的list
    public static List<String> toInfixExpressionList(String s) {
        //定义一个list，存放中缀表达式对应的内容
        List<String> list = new ArrayList<String>();
        int i = 0;//相当于一个指针，用于遍历中缀表达式字符串
        String string;//用于多位数拼接
        char c;//每遍历到一个字符，就放到c中
        do {
            //如果是一个非数字，就需要加入到list中
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                list.add("" + c);
                i++;
            } else {
                //如果是一个数字，需要考虑多位数的问题
                string = "";//将string置空
                while (i < s.length() && (c = s.charAt(i)) > 48 && (c = s.charAt(i)) < 57) {
                    string += c;//拼接
                    i++;
                }
                list.add(string);
            }
        } while (i < s.length());
        return list;
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

//编写一个Operation类，可以返回一个运算符对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "x":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}

