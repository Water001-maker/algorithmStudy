package com.algorithm.LeetCode.SuanFa.Day17.Test01;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        int[] nums = new int[]{3, 2, 1};

        int k = 2;

        Solution solution = new Solution();
        int[] leastNumbers = solution.getLeastNumbers(nums, k);

        String string = Arrays.toString(leastNumbers);

        System.out.println(string);

    }

}

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {

        Arrays.sort(arr);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }

        return res;

    }
}

