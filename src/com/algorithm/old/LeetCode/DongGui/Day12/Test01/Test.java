package com.algorithm.old.LeetCode.DongGui.Day12.Test01;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> generate = solution.generate(5);


    }

}

class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> lists = new ArrayList<>();

        int[][] nums = new int[numRows][numRows];

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    nums[i][j] = 1;
                } else {
                    nums[i][j] = nums[i - 1][j - 1] + nums[i - 1][j];
                }
                list.add(nums[i][j]);
            }
            lists.add(list);
        }
        return lists;
    }
}