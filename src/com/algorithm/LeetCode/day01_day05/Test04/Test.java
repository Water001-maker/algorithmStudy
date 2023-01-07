package com.algorithm.LeetCode.day01_day05.Test04;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib1(5));
        System.out.println(solution.fib2(5));
    }

}

class Solution {

    public int fib1(int n) {
        if (n < 1) {
            return n;
        }

        int a = 1, b = 0;
        for (int i = 1; i < n; i++) {
            a = a + b;
            b = a - b;
            a %= 1000000007;
        }
        return a;
    }

    public int fib2(int n) {

        if (n == 0) return 0;

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = (a + b) % 1000000007;
            a = b;
            b = c;
        }

        return b;
    }



}