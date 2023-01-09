package com.algorithm.old.LeetCode.SuanFa.Day13.Test02;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 11, 15};

        Solution solution = new Solution();
        int[] ints = solution.twoSum(nums, 9);
        System.out.println(Arrays.toString(ints));

    }

}

class Solution {
    public int[] twoSum(int[] nums, int target) {

        int i = 0;//左
        int j = nums.length - 1;//右

        while (i < j) {
            int temp = nums[i] + nums[j];

            if (temp == target) {
                return new int[]{nums[i], nums[j]};
            } else if (temp > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.contains(target - num)) {
                set.add(num);
            } else {
                return new int[]{num, target - num};
            }
        }

        return null;

    }

}