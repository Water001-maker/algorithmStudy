package com.algorithm.LeetCode.SuanFa.Day24.Test01;

import java.util.Map;

public class test {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(10));

    }

}

class Solution {
    public int cuttingRope(int n) {

        if (n < 4) return n - 1;
        else if (n == 4) return 4;

        int r = n % 3;
        if(r==0) return (int) Math.pow(3,n/3);

        if(r==1) return (int) Math.pow(3,n/3-1)*4;
        else return (int) Math.pow(3,n/3)*2;
    }
}