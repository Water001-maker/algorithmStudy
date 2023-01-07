package com.algorithm.LeetCode.DongGui.Day12.Test02;

import java.util.ArrayList;
import java.util.List;

public class Test {
}

class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> list = new ArrayList<>();

        //第一个数字
        list.add(1);

        for (int i = 1; i <= rowIndex; i++) {

            list.add(0);
            for (int j = i; j > 0; --j) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
        }
        return list;
    }

    public List<Integer> getRow2(int rowIndex) {

        List<Integer> list = new ArrayList<>();

        long cur = 1;

        for (int i = 0; i <= rowIndex; i++) {
            list.add((int) cur);
            cur = cur * (rowIndex - i) / (i + 1);
        }
        return list;
    }

}