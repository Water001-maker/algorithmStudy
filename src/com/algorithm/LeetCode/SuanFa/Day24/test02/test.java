package com.algorithm.LeetCode.SuanFa.Day24.test02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[][] continuousSequence = solution.findContinuousSequence(10);

        for (int i = 0; i < continuousSequence.length; i++) {
            for (int i1 = 0; i1 < continuousSequence[i].length; i1++) {
                System.out.println(continuousSequence[i][i1]);
            }
        }


    }

}

class Solution {
    public int[][] findContinuousSequence(int target) {

        int i = 1;
        double j = 2.0;
        List<int[]> res = new ArrayList<>();

        while (i < j) {
            //公式推导：(（首项+末项）*项数)/2==>末项=...
            j = (-1 + Math.sqrt(1 + 4 * (2 * target + (long) i * i - i))) / 2;

            if (i < j && j == (int) j) {
                int[] ans = new int[(int) j - i + 1];
                for (int k = i; k <= (int) j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }
            i++;
        }

        return res.toArray(new int[0][]);
    }
}
