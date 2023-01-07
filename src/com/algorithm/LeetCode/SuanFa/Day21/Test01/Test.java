package com.algorithm.LeetCode.SuanFa.Day21.Test01;

public class Test {

    public static void main(String[] args) {

    }

}

class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        int count = 0;
        while (n != 0) {
            n = n & (n - 1);//
            count++;
        }
        return count++;
    }
}