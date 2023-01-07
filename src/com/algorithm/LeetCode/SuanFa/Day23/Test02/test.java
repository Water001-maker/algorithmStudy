package com.algorithm.LeetCode.SuanFa.Day23.Test02;

import java.util.Arrays;

public class test {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 5};

        Solution solution = new Solution();
        int[] ints = solution.constructArr(nums);

        System.out.println(Arrays.toString(ints));

    }

}

class Solution {
    public int[] constructArr(int[] a) {
        int[] res = new int[a.length];

        for (int i = 0, cur = 1; i < a.length; i++) {
            res[i] = cur;   //先乘左边
            cur *= a[i];
        }

        ;
        for (int i = a.length - 1, cur = 1; i >= 0; i--) {
            res[i] *= cur;   //再乘右边
            cur *= a[i];
        }

        return res;
    }
}