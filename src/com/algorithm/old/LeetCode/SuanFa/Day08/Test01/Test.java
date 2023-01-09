package com.algorithm.old.LeetCode.SuanFa.Day08.Test01;

public class Test {
}

class Solution {
    public int fib(int n) {
        if(n<1){
            return n;
        }

        int a = 1,b = 0;
        for(int i = 1 ; i< n ; i++){
            a = a+b;
            b = a-b;
            a%=1000000007;
        }
        return a;
    }
}