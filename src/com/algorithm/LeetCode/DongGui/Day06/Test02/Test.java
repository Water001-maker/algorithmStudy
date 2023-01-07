package com.algorithm.LeetCode.DongGui.Day06.Test02;

public class Test {

    public static void main(String[] args) {

        int[] nums = new int[]{2, -3, 4, -5};
        Solution solution = new Solution();
        System.out.println(solution.getMaxLen(nums));

    }

}

class Solution {
    public int getMaxLen(int[] nums) {
        int res = 0;
        int zCount = 0;
        int fCount = 0;
        for (int num : nums) {
            if (num > 0) {//大于零
                zCount++;
                fCount = fCount == 0 ? 0 : fCount + 1;
            } else if (num < 0) {//小于零（负负得正）
                int temp = zCount;
                zCount = fCount == 0 ? 0 : fCount + 1;
                fCount = temp + 1;//fCount = zCount+1
            } else {//等于零
                zCount = 0;
                fCount = 0;
            }
            res = Math.max(res, zCount);
        }
        return res;
    }
}