package com.algorithm.old.LeetCode.SuanFa.Day22.Test02;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        int[] nums = new int[]{9, 1, 7, 9, 7, 9, 7};
        Solution solution = new Solution();
        int ints = solution.singleNumber(nums);
        System.out.println(ints);

    }

}

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (Integer num : nums) {
            map.put(num, map.containsKey(num));
        }
        for (int num : nums) {
            if (!map.get(num)) return num;
        }
        return -1;
    }

    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}

