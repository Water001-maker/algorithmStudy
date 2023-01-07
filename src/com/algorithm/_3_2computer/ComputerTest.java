package com.algorithm._3_2computer;

public class ComputerTest {
    public static void main(String[] args) {

        String expression = "70+2*6-4"; //8
        //创建两个栈，数栈，操作符栈
        NumStack numStack = new NumStack(10);
        NumStack operStack = new NumStack(10);
        //定义相关变量
        int index = 0;//用于扫描
        int num1 = 0;//第一个数字
        int num2 = 0;//第二个数组
        int oper = 0;//接收操作符
        int res = 0;//保存结果
        char ch = ' ';//保存每次扫描的操作符
        String keepNum = "";
        //循环扫描计算式
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么（符号/数字），然后做响应的处理
            if (operStack.isOper(ch)) {//如果是运算符
                if (!operStack.isEmpty()) {
                    //与符号栈栈顶元素比较，如果优先级 < = 栈顶元素优先级，就从数栈里面弹出两个数，再从符号栈里弹出一个符号运算，
                    // 运算，后将结果压入数栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = operStack.cal(num1, num2, oper);
                        numStack.push(res);
                        //然后将当前操作符入栈
                        operStack.push(ch);
                    } else {//当前操作符优先级>栈顶操作符优先级，直接入栈
                        operStack.push(ch);
                    }
                } else {
                    //符号栈为null，直接入栈
                    operStack.push(ch);
                }
            } else {
                //接收数字时，可能接收到多位数，因此不能发现是一个数字就入栈，因为可能是多位数
                //在处理数时，需要向expression的表达式的index后再看一位，如果是符号才入栈
                //因此我们需要定义一个变量，字符串，用于拼接

                //处理多位数
                keepNum += ch;

                //判断下一位是不是数字，，如果是数字，就继续扫描，如果是运算符就入栈
                //注意看后一位，不是index++
                if (index + 1 == expression.length()) {
                    //如果是最后一位，直接如数栈
                    numStack.push(ch - 48);
                } else {
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果最后一位是运算符，则入栈 keepNum="1"或者”123“
                        numStack.push(Integer.parseInt(keepNum));
                        //清空keepNum
                        keepNum = "";
                    }
                }
             /*   //如果是数字，直接入栈
                numStack.push(ch-48);//字符转数字*/
            }
            //让index+1，并判断是否扫描到expression的结尾
            index++;
            if (index >= expression.length()) {
                break;//扫描完毕，跳出循环
            }
        }
        while (true) {
            //如果符号栈为空，则计算到最后结果，数栈中只有一个数栈【结果】
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        res = numStack.pop();
        System.out.printf("表达式%s = %d", expression, res);
    }
}

class NumStack {
    private int maxSize;//栈的大小
    private int[] stack;//数组，模拟栈，用来存放数据
    private int top = -1; //栈顶元素，初始时指向栈地的上一位

    //构造器
    public NumStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //获取栈顶元素，但不pop
    public int peek() {
        return stack[top];
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        //先判断是否栈满
        if (isFull()) {
            System.out.println("栈已满，不能再放数据");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        int tmp = stack[top];
        top--;
        return tmp;
    }

    //遍历栈,遍历时从栈底开始遍历
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    //返回运算符的优先级，优先级由程序员来确定，优先级使用数字表示
    //数字越大，优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //辨别运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0; //用来存放结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}

