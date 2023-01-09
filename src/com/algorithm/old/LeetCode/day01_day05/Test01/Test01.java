package com.algorithm.old.LeetCode.day01_day05.Test01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test01 {

    public static void main(String[] args) {

        int[] nums = {2, 7, 5, 3};
        int target = 9;

        Solution solution = new Solution();
        int[] ints = solution.twoSum(nums, 9);

        System.out.println(Arrays.toString(ints));
    }

}

class Solution {
/*
    public int[] twoSum(int[] nums, int target) {
        int[] num = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            boolean contains = map.containsKey(temp);//判断是否包含指定的键名 9-7=2
            if (contains) {//包含
                num[1] = i;//
                num[0] = map.get(temp);
            }//不包含
            map.put(nums[i],i);//将数组元素和下标存入map集合中
        }
        return num;
    }
*/

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {//判断是否包含指定的键名 9-7=2//包含
                return new int[]{map.get(target - nums[i]),i};
            }//不包含
            map.put(nums[i],i);//将数组元素和下标存入map集合中
        }
        return new int[0];
    }

}