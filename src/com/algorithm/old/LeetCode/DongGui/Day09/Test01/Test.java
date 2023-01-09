package com.algorithm.old.LeetCode.DongGui.Day09.Test01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

    public static void main(String[] args) {

        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("cat");
        wordDict.add("pen");
        wordDict.add("car");
        wordDict.add("catsan");
        wordDict.add("dog");

        Solution solution = new Solution();
        boolean b = solution.wordBreak(s, wordDict);
        System.out.println(b);

        boolean c = solution.wordBreak2(s, wordDict);
        System.out.println(c);

    }


}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();//长度
        //创建dp数组
        boolean dp[] = new boolean[n + 1];
        dp[0] = true;

        //s是背包，wordDict是物品
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (len <= i && word.equals(s.substring(i - len, i))) {//len<=i是指不能超出范围
                    //要么装包dp[i]=dp[i],不装dp[i]=dp[i-len]
                    dp[i] = dp[i] || dp[i - len];

                }
            }
        }
        return dp[n];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {

        int maxlen = 0;

        //创建dp数组
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;

        //添加入set集合
        Set<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
            maxlen = Math.max(maxlen, word.length());
        }

        //s是背包，wordDict是物品
        for (int i = 1; i < dp.length; i++) {
            for (int j = i; j >= 0 && j >= i - maxlen; j--) {//逐步比较

                if (dp[j] && wordSet.contains(s.substring(j, i))) {//找到一个
                    dp[i] = true;
                    break;
                }

            }
        }

        return dp[dp.length-1];

    }
}