package com.algorithm.old._10tenAlgorithm._4kmp;

import java.util.Arrays;

//kmp算法
public class KMPAlgorithm {

    public static void main(String[] args) {

        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

        int[] next = kmpNext(str2);

        System.out.println(Arrays.toString(next));

        int index = kmpSearch(str1, str2, next);

        System.out.println(index);

    }

    /**
     * kmp搜索算法的实现
     *
     * @param str1 愿字符串
     * @param str2 子串
     * @param next 子串对应的部分匹配表
     * @return
     */
    public static int kmpSearch(String str1, String str2, int[] next) {
        //遍历
        for (int i = 0, j = 0; i < str1.length(); i++) {

            //需要处理str1.charAt(i) != str2.charAt(j)
            //KMP核心
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }

            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {//找到了
                return i - j + 1;
            }
        }
        return -1;
    }

    /**
     * 获取字符串的部分匹配值表的方法
     *
     * @param dest 当前字符串
     * @return 部分匹配表
     */
    public static int[] kmpNext(String dest) {
        //创建一个数组，保存部分匹配值
        int[] next = new int[dest.length()];

        next[0] = 0;//如果字符串长度是1，部分匹配值就是0
        //i表示后缀缀（一直在移动），j表示前缀
        for (int i = 1, j = 0; i < dest.length(); i++) {
            //当dest.charAt(i) != dest.charAt(j)成立时
            //我们需要从next[j-1]处获取新的j
            //直到dest.charAt(i) == dest.charAt(j)成立时，才退出

            //这是kmp算法的核心
            //加入这句话之前：[0, 0, 0, 0, 1, 2, 2]
            //加入这句话之后：[0, 0, 0, 0, 1, 2, 0]
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {//当j>0时，并且后续的值不相等
                j = next[j - 1];
                //回溯到与当前值相等的前缀下标
                //"A  B  C  D  A  B  D  A  B  C  C";
                //[0, 0, 0, 0, 1, 2, 0, 1, 2, 3, 0]
            }

            //当dest.charAt(i) == dest.charAt(j)成立时，部分匹配值就是++
            if (dest.charAt(i) == dest.charAt(j)) {//值相等时
                j++;
            }
            next[i] = j;
        }
        return next;
    }

}
