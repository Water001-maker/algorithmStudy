package com.algorithm.old.LeetCode.day01_day05.Test07;

public class Test {

    public static void main(String[] args) {

        String s = "We are happy.";

        Solution solution = new Solution();

        String s1 = solution.replaceSpace(s);
        System.out.println(s1);

    }

}

class Solution {
    public String replaceSpace(String s) {

        StringBuffer stringBuilder = new StringBuffer();

        char[] chars = s.toCharArray();

        for (char aChar : chars) {
            if (aChar == ' ') {
                String s1 = "%20";
                stringBuilder.append(s1);
            } else {
                stringBuilder.append(aChar);
            }
        }
        return stringBuilder.toString();
    }
}

class Solution1 {
    public String replaceSpace(String s) {

        int length = s.length();//确定长度

        char[] chars = new char[length * 3];

        int size = 0;

        for (int i = 0; i < length; i++) {

            char c = s.charAt(i);

            if (c == ' ') {
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            } else {
                chars[size++] = c;
            }

        }
        String str = new String(chars, 0, size);

        return str;
    }

}