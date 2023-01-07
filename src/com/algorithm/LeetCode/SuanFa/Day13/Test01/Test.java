package com.algorithm.LeetCode.SuanFa.Day13.Test01;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 8, 1, 5, 4, 3};

        Solution solution = new Solution();
        int[] exchange = solution.exchange(nums);

        System.out.println(Arrays.toString(exchange));

    }

}


class Solution {
    public int[] exchange(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && (nums[left] & 1) == 1) left++;
            while (left < right && (nums[right] & 1) == 0) right--;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
}