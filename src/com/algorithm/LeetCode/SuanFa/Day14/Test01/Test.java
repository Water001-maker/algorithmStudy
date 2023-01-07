package com.algorithm.LeetCode.SuanFa.Day14.Test01;

public class Test {

    public static void main(String[] args) {

        char[][] nums = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCED";

        Solution solution = new Solution();
        System.out.println(solution.exist(nums, word));

    }

}


class Solution {
    public boolean exist(char[][] board, String word) {

        if (board == null || board[0] == null || board[0].length == 0 || word == null) {
            return false;
        }

        char[] chars = word.toCharArray();
        boolean[][] isVisited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == chars[0]) {
                    //从0,0点开始进行dfs操作，不断的去找；如果0,0没有就去看0,1……
                    if (dfs(board, isVisited, chars, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] isVisited, char[] word, int i, int j, int start) {

        if (start == word.length) {
            return true;
        }

        if (i < 0 || j < 0 || i == board.length || j == board[0].length || word[start] != board[i][j] || isVisited[i][j]) {
            return false;
        }

        isVisited[i][j] = true;
        boolean ans = dfs(board, isVisited, word, i + 1, j, start + 1)
                || dfs(board, isVisited, word, i - 1, j, start + 1)
                || dfs(board, isVisited, word, i, j + 1, start + 1)
                || dfs(board, isVisited, word, i, j - 1, start + 1);
        isVisited[i][j] = false;
        return ans;
    }

}