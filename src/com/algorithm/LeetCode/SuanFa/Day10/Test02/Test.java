package com.algorithm.LeetCode.SuanFa.Day10.Test02;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {

    public static void main(String[] args) {

        String str = "pwwkew";

        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstring(str);
        System.out.println(i);

    }

}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1 && s.equals(" ")) return s.length();
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0, j = 0; i < chars.length; i++) {
            while (set.contains(chars[i])) {
                set.remove(chars[j++]);
            }
            set.add(chars[i]);
            res = Math.max(i - j + 1, res);
        }
        return res;
    }

    //方法一：动态规划 + 哈希表
    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, temp = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = dic.getOrDefault(s.charAt(i), -1);//获取索引i
            dic.put(s.charAt(i), i);// 更新哈希表
            temp = temp < i - j ? temp + 1 : i - j;// dp[j - 1] -> dp[j]
            res = Math.max(res, temp);// max(dp[j - 1], dp[j])
        }
        return res;
    }


    //方法二： 动态规划 + 线性遍历
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, temp = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i - 1;//获取索引i
            while (j >= 0 && s.charAt(j) != s.charAt(i)) j--;//先行查找  向左遍历搜索第一个满足 s[i] = s[j]s[i]=s[j] 的字符即可
            temp = temp < i - j ? temp + 1 : i - j;// dp[j - 1] -> dp[j]
            res = Math.max(res, temp);// max(dp[j - 1], dp[j])
        }
        return res;
    }

    //方法二： 双指针 + 哈希表
    public int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int j = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (dic.containsKey(s.charAt(i))) j = Math.max(j, dic.get(s.charAt(i)));//更新左指针
            dic.put(s.charAt(i), i);// 哈希表记录
            res = Math.max(res, i - j);// 更新结果
        }
        return res;
    }

}