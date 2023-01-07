package com.algorithm.LeetCode.SuanFa.Day16.Test01;

import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        int[] nums = new int[]{10, 2};

        Solution solution = new Solution();

        String s = solution.minNumber(nums);

        System.out.println(s);

    }
}

class Solution {
    public String minNumber(int[] nums) {

        String[] strs = new String[nums.length];

        for (int i = 0; i < strs.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (s1, s2) -> (s1 + s2).compareTo((s2 + s1)));
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

}