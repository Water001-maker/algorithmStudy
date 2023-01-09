package com.algorithm.old.LeetCode.DongGui.Day07.Test02;

public class Test {

    public static void main(String[] args) {
        int[] nums = new int[]{7, 6, 4, 3, 1};

        Solution solution = new Solution();
        System.out.println(solution.maxProfit(nums));
    }

}

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int res = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            res = Math.max(prices[i] - min, res);
            min = Math.min(min, prices[i]);
        }
        return res;
    }


    public int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int res = 0, min = prices[0];
        for (int i : prices) {
            if (i < min) min = i;
            else if (res < i - min) res = i - min;
        }
        System.gc();
        return res;
    }
}