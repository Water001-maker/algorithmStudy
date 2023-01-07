package com.algorithm.LeetCode.SuanFa.Day13.Test03;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        String s = "a good   example";

        Solution solution = new Solution();
        System.out.println(solution.reverseWords(s));

    }

}

class Solution {
    public String reverseWords(String s) {

        String[] str = s.trim().split(" ");
        StringBuffer res = new StringBuffer();


        int i = 0;
        int j = str.length - 1;

        while (i < j) {
            String temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }

        for (int k = 0; k < str.length; k++) {
            if (k != str.length - 1) res.append(str[k].trim() + " ");
            else res.append(str[k].trim());
        }

        return res.toString();

    }

    public String reverseWords2(String s) {
        //将传进来的字符串以空格拆分
        String[] strings = s.trim().split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        //从尾巴开始遍历
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].equals("")) {
                continue;
            }
            //到头了，append然后去空格
            if (i == 0) {
                stringBuffer.append(strings[i].trim());
            } else {
                // 怕有多余的空格，去掉，再加上去
                stringBuffer.append(strings[i].trim()).append(" ");
            }
        }
        //输出String 完事，安排！
        return stringBuffer.toString();
    }

}