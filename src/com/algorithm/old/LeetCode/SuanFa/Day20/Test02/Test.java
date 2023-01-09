package com.algorithm.old.LeetCode.SuanFa.Day20.Test02;

public class Test {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        Solution solution = new Solution();
        System.out.println(solution.myPow(x, n));

    }
}

//最后一步不是很懂
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}