package com.algorithm.LeetCode.DongGui.Day09.Test02;

public class Test {

    public static void main(String[] args) {

        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        Solution solution = new Solution();
        System.out.println(solution.trap(height));

    }
}

class Solution {
    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int left_max = 0;
        int right_max = 0;
        int ans = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > left_max) {
                    left_max = height[left];
                } else {
                    ans += left_max - height[left];
                }
                left++;
            } else {
                if (height[right] > right_max) {
                    right_max = height[right];
                } else {
                    ans += right_max - height[right];
                }
                right--;
            }
        }
        return ans;
    }
}