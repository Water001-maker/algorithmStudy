package com.algorithm.old.LeetCode.SuanFa.Day21.Test02;

public class Test {
}

class Solution {
    public int add(int a, int b) {

        while (b != 0) {
            int c = (a & b) << 1;
            a = a ^ b;
            b = c;
        }
        return a;
    }
}