package com.algorithm.LeetCode.DongGui.Day04.Test01.Test;

public class Test {
    public static void main(String[] args) {

        int[] nums = new int[]{2, 3, 1, 1, 4};

        Solution solution = new Solution();
        System.out.println(solution.canJump(nums));

        System.out.println(nums.length);

    }
}

class Solution {
    public boolean canJump(int[] nums) {

        int len = nums.length;//记录长度
        if (len <= 1) return true;

        int max = nums[0];//位移值

        for (int i = 1; i < len - 1; i++) {
            if (i <= max) {
                max = Math.max(max, nums[i] + i);//更新步长
            }
        }

        if (max >= len - 1) {
            return true;
        }
        return false;
    }
}