package com.algorithm.old.LeetCode.SuanFa.Day05.Test01;

public class Test01 {
    public static void main(String[] args) {

        int[][] num = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        Solution solution = new Solution();
        System.out.println(solution.findNumberIn2DArray1(num, 5));
        System.out.println(solution.findNumberIn2DArray2(num, 5));

    }
}

class Solution {
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray2(int[][] matrix, int target) {

        int m = matrix.length - 1, n = 0;
        while (m >= 0 && n <= matrix[0].length - 1) {
            if (matrix[m][n] > target) m--;
            else if (matrix[m][n] < target) n++;
            else return true;
        }
        return false;
    }

}
