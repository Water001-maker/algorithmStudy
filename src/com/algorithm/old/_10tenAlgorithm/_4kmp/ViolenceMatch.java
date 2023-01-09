package com.algorithm.old._10tenAlgorithm._4kmp;

//字符匹配
public class ViolenceMatch {

    public static void main(String[] args) {

        String str1 = "adsadasdasjkdbaskjdasj";
        String str2 = "ask";

        int i = violenceMatch(str1, str2);

        System.out.println(i);

    }

    //暴力匹配实现
    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int len1 = s1.length;
        int len2 = s2.length;

        int i = 0;//i索引指向s1
        int j = 0;//j索引指向s2

        while (i < len1 && j < len2) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                i = i - (j - 1);//移动到i的下一位
                j = 0;
            }
        }

        //判断是否匹配成功
        if (j == len2) {
            return i - j;
        } else {
            return -1;
        }
    }

}
