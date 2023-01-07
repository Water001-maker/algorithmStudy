package com.algorithm.LeetCode.DongGui.Day06.Test01;

public class Test {

    public static void main(String[] args) {

        int[] num = new int[]{-1, -2};

        Solution solution = new Solution();
        int i = solution.maxProduct(num);
        System.out.println(i);

    }

}

class Solution {
    public int maxProduct(int[] nums) {
        ;
        int imin = nums[0], imax = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int max = imax, min = imin;
            imax = Math.max(max * nums[i], Math.max(nums[i], min * nums[i]));
            imin = Math.min(min * nums[i], Math.min(nums[i], max * nums[i]));

            res = Math.max(imax, res);

        }
        return res;
    }
}