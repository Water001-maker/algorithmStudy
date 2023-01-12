package com.algorithm.newStudy.LinkedList.BitMap;

/**
 * @author xuemiao
 * @date 2023/1/12 20:22
 * 两数交换位置——不创建新的变量
 */
public class ChangePleace {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        a = a ^ b;// a = 1^2
        b = a ^ b;// b = 1^2^2 = 1
        a = a ^ b;// a = 1^2^1 = 2

        System.out.println(a);
        System.out.println(b);
    }

}
