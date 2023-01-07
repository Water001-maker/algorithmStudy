package com.algorithm.LeetCode.SuanFa.Day09.Test02;

public class Test {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        Solution solution = new Solution();
        System.out.println(solution.maxValue(nums));
    }

}

class Solution {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row+1][col+1];
        for (int i = 1; i < row+1; i++) {
            for (int j = 1; j < col+1; j++) {
                dp[i][j] = Math.max( dp[i - 1][j],dp[i][j-1]) + grid[i-1][j-1];
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }
        return dp[row][col];
    }
}