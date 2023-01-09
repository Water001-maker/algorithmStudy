package com.algorithm.LinkedList.BitMap;

/**
 * @author xuemiao
 * @date 2023/1/9 19:06
 * 位图实现加减乘除
 * https://leetcode.com/problems/divide-two-integers
 */
public class BitAddMinusMultiDiv {

    //加法
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {//知道进位信息变为0
            sum = a ^ b;//异或运算 =》无进位相加信息
            b = (a & b) << 1;//与运算后再向左移动一位（进位） =》进位信息 b -> b`
            a = sum;//无进位相加信息 a -> a`
        }
        return sum;//返回无进位相加信息
    }

    //获取相反数
    public static int negNum(int n) {
        return add(~n, 1);
    }

    //减法
    public static int minus(int a, int b) {
        //a + b的相反数
        return add(a, negNum(b));
    }

    //乘法
    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {// b当前末位是不是0，是0直接跳过
                res = add(res, a);
            }
            a <<= 1;//左移一位 0110 -> 01100
            b >>>= 1;//不带符号右移一位 0101 -> 010
        }
        return res;
    }

    //是否小于0
    public static boolean isNeg(int n) {
        return n < 0;
    }

    //除
    public static int div(int a, int b) {
        //x,y必须大于0，x/y，y必须小于x
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            if ((x >> i) >= y) {//y左移可能会移动到符号位，所以保险起见右移x
                res |= (1 << i);//保留结果（1左移i位）
                x = minus(x, y << i);//x减去y左移i位
                // 011001100   000001100
                // 011001100右移4位，res记0100
                // 011001100 - 000001100左移4位 = 000000110
                // 011001100   000001100
                // 011001100右移4位，res记0
                // 000001100 - 000001100左移0位 = 0
                // 结果为10001
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;//除法中，当两个数的正负一致时（!= = ^），直接返回；不一致时，取反
    }

    //解决系统最小值转绝对值
    public static int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            if (b == negNum(1)) {
                return Integer.MAX_VALUE;
            } else {
                int c = div(add(a, 1), b);//(-10+1)/2=(-4)
                return add(c, div(minus(a, multi(c, b)), b));//2*(-4)=(-8) -> (-10)-(-8)=(-2) -> (-2)/2=(-1) -> (-1)+(-4)=(-5)
            }
            //-10~9，假设系统最小值为 -10
            //-10/2 = (-10+1)/2=(-4) -> 2*(-4)=(-8) -> (-10)-(-8)=(-2) -> (-2)/2=(-1) -> (-1)+(-4)=(-5)
        } else {
            return div(a, b);
        }
    }

}
