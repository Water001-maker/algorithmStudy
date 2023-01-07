package com.algorithm.LeetCode.DongGui.Day10.Test01;

public class Test {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 7};

        Solution solution = new Solution();
        int i = solution.numberOfArithmeticSlices(nums);

        System.out.println(i);
    }

}

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {

        if (nums == null && nums.length < 3) return 0;
        int res = 0;//返回值
        int add = 0;//记录当前数组中是等差数列的数组个数
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 1] - nums[i] == nums[i - 2] - nums[i - 1]) {
                add++;//等差数列个数 1 2 3
                res += add;//数量+1
            } else {
                add = 0;
            }
        }
        return res;

    }
}