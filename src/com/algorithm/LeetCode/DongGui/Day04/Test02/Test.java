package com.algorithm.LeetCode.DongGui.Day04.Test02;

public class Test {
    public static void main(String[] args) {

        int[] nums = new int[]{2, 3, 1, 1, 4};

        Solution solution = new Solution();
        System.out.println(solution.canJump(nums));

        System.out.println(nums.length);

    }
}

class Solution {
    public int canJump(int[] nums) {

        int length = nums.length;
        int end = 0;//当前能到达的最大下标位置
        int max = 0;//每次移动的最大值
        int steps = 0;//计步
        for (int i = 0; i < length - 1; i++) {
            max = Math.max(nums[i] + i, max);
            if (i == end) {//到达当前最大下标位置
                end = max;//更新
                steps++;//计数+1
            }
        }
        return steps;
    }
}