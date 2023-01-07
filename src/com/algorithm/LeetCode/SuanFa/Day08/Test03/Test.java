package com.algorithm.LeetCode.SuanFa.Day08.Test03;

public class Test {

    public static void main(String[] args) {

        int[] num = new int[]{1, 7, 6, 4, 3, 2, 8};

        Solution solution = new Solution();
        int i = solution.maxProfit(num);
        System.out.println(i);

    }

}

class Solution {
    public int maxProfit(int[] prices) {

        if (prices.length < 1) return 0;

        int min = Integer.MAX_VALUE;
        int price = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > price) {
                price = prices[i] - min;
            }
        }

        return price;

    }

    public int maxProfit2(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
