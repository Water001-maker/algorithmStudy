package com.algorithm.LeetCode.SuanFa.Day08.Test02;

public class Test {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.numWays(3));

    }

}


class Solution {
    public int numWays(int n) {

        if (n < 2) return 1;

        int a = 1;
        int b = 1;

        for (int i = 2; i <= n; i++) {
            a = a + b;
            b = a - b;
            a = a % 1000000007;
        }
        return a;
    }
}