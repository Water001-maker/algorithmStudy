package com.algorithm.old.LeetCode.day01_day05.Test08;

public class Test {

    public static void main(String[] args) {

        String s = "abcdefg";

        Solution solution = new Solution();

        String s1 = solution.reverseLeftWords(s, 2);

        System.out.println(s1);

    }

}

class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuffer sb = new StringBuffer();
        
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {

            if(i>n){
                char c = s.charAt(i);

                sb.append(c);
            }
        }

        for (int i = 0; i < n; i++) {

            char c = s.charAt(i);

            sb.append(c);

        }

        return sb.toString();
    }
}