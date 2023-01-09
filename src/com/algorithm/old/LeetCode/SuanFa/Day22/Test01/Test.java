package com.algorithm.old.LeetCode.SuanFa.Day22.Test01;

import java.util.HashMap;
import java.util.Map;

public class Test {
}

class Solution {
    public int[] singleNumbers(int[] nums) {
        //x,y：返回的两个数字
        //n:所有数字异或的结果
        //m:找到第一个不是0的数字
        int x = 0, y = 0, n = 0, m = 1;
        for (int num : nums) {
            //遍历异或
            n ^= num;
        }
        while ((n & m) == 0) {//循环左移，计算m
            m <<= 1;
        }
        for (int num : nums) {//遍历nums分组
            //根据当前位置是否为0分为两组
            if ((num & m) != 0) {//当num & m != 0
                x ^= num;
            } else {//当num & m == 0
                y ^= num;
            }
        }
        return new int[]{x, y};//返回出现一次的数字
    }

    public int[] singleNumbers2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int x: nums) {
            map.put(x, map.getOrDefault(x, 2) - 1);
            if (map.get(x) == 0) {
                map.remove(x);
            }
        }
        int[] ans = new int[2];
        int i = 0;
        for (int x: map.keySet()) {
            ans[i] = x;
            i++;
        }
        return ans;
    }
}