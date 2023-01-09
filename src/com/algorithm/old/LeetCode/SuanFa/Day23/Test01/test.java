package com.algorithm.old.LeetCode.SuanFa.Day23.Test01;

public class test {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};

        Solution solution = new Solution();

        System.out.println(solution.majorityElement(arr));

    }

}


class Solution {

    public int majorityElement(int[] nums) {

        int count = 0;//计数
        int num = nums[0];//众数

        for (int i : nums) {//循环
            if (count == 0) {//当计数为0时，将当前值赋值给众数
                num = i;
            }
            //如果当前数字等于众数，count+1，否则-1
            count += (num == i) ? 1 : -1;

        }
        //返回众数
        return num;
    }

}