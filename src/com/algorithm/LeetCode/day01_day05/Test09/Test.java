package com.algorithm.LeetCode.day01_day05.Test09;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.sort;

public class Test {

    public static void main(String[] args) {

        int[] arr1 = new int[]{2, 3, 1, 0, 2, 5, 3};

        Solution solution = new Solution();
        System.out.println(solution.findRepeatNumber1(arr1));

        int[] arr2 = new int[]{5, 7, 7, 8, 8, 10};

        System.out.println(solution.search1(arr2, 8));

        System.out.println(solution.search2(arr2, 8));

        int[] arr3 = new int[]{0,1,2,3,4,5,6,7,9};

        System.out.println(solution.missingNumber(arr3));

    }

}


class Solution {
    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count = count + 1;
            }
        }
        return count;
    }

    public int search2(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        int count = 0;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        while (left < nums.length && nums[left++] == target) {
            count++;
        }
        return count;
    }

    public int missingNumber(int[] nums) {
        int right = nums.length - 1;
        int left = 0;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}