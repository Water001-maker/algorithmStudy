package com.algorithm.LeetCode.DongGui.Day07.Test01;

public class Test {

    public static void main(String[] args) {
        int[] nums = new int[]{8, 1, 5, 2, 6};

        Solution solution = new Solution();
        System.out.println(solution.maxScoreSightseeingPair(nums));
    }

}

//values[i] + values[j] + i - j  ==>  values[i] + i +values[j] - j
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max = 0, imax = values[0];
        for (int i = 1; i < values.length; i++) {
            max = Math.max(max, values[i] - i + imax);
            imax = Math.max(imax, values[i] + i);
        }
        return max;
    }
}