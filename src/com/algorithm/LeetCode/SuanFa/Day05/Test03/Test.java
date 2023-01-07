package com.algorithm.LeetCode.SuanFa.Day05.Test03;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        String s = "abaccdeff";
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar(s));
    }
}

class Solution {
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) map.put(c, 1);
            else map.put(c, map.get(c) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return s.charAt(i);
        }
        return ' ';
    }
}
