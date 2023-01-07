package com.algorithm.LeetCode.SuanFa.Day19.Test01;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.sumNums(5);
        System.out.println(i);
    }

}

class Solution {
    public int sumNums(int n) {
        int res = n;
        boolean flag = n > 0 && (res += sumNums(n - 1)) > 0;
        return res;
    }
}