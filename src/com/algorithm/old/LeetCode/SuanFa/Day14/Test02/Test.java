package com.algorithm.old.LeetCode.SuanFa.Day14.Test02;

import java.util.LinkedList;
import java.util.Queue;

public class Test {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int i = solution.movingCount(2, 3, 1);
        int j = solution.movingCount2(2, 3, 1);
        System.out.println(i);
        System.out.println(j);

    }

}


class Solution {

    int m, n, k;//定义
    boolean[][] isVisited;//是否被访问过

    /**
     * 主方法+初始化
     *
     * @param m 行
     * @param n 列
     * @param k 范围值
     * @return
     */
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.k = k;
        this.n = n;
        this.isVisited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }

    /**
     * 深度优先算法：
     *
     * @param i  行
     * @param j  列
     * @param si 行的位数和
     * @param sj 列的位数和
     * @return
     */
    private int dfs(int i, int j, int si, int sj) {
        if (i >= m || j >= n || k < si + sj || isVisited[i][j]) return 0;
        isVisited[i][j] = true;
        //第一部分：向下移动 + 第二部分：向右移动
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }


    /**
     * 广度优先算法
     *
     * @param m 行
     * @param n 列
     * @param k 范围值
     * @return
     */
    public int movingCount2(int m, int n, int k) {
        this.isVisited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{0, 0, 0, 0});
        while (queue.size() > 0) {
            int[] x = queue.poll();
            int i = x[0], j = x[1], si = x[2], sj = x[3];
            if (i >= m || j >= n || k < si + sj || isVisited[i][j]) continue;
            isVisited[i][j] = true;
            res++;
            queue.add(new int[]{i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj});//向下
            queue.add(new int[]{i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8});//向右
        }
        return res;
    }

}