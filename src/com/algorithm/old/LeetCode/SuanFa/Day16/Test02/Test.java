package com.algorithm.old.LeetCode.SuanFa.Day16.Test02;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        int[] nums = new int[]{11,9,0,0,0};

        Solution solution = new Solution();
        boolean straight = solution.isStraight(nums);

        System.out.println(straight);

    }

}

class Solution {
    public boolean isStraight(int[] nums) {

        if (nums.length < 1) return false;

        Arrays.sort(nums);
        int zeroCount = 0;
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                if (nums[i] == nums[i + 1]) return false;
                if (nums[i] + 1 != nums[i + 1]) {
                    zeroCount = zeroCount - (nums[i + 1] - nums[i]-1);
                }
            }
        }
        return zeroCount >= 0;
    }
}