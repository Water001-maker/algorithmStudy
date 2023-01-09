package com.algorithm.old._4recursion;

public class EightQueue {
    //定义一个max：表示共有多少个皇后
    int max = 8;
    //定义数组array, 保存皇后放置位置的结果
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        //运行
        EightQueue queue8 = new EightQueue();
        queue8.check(0);
        System.out.println("一共有" + count + "解法");
        System.out.println();
        System.out.println("一共判断冲突的次数" + judgeCount + "次");

    }

    /**
     * 编写一个方法，放置第n个皇后
     * @param n 表示第几个皇后
     */
    private void check(int n) {
        if (n == max) {  //n = 8 时，证明8个皇后都放好位置
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后 n , 放到该行的第1列
            array[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) { // 不冲突
                //接着放下一个皇后,即开始递归
                check(n + 1);
            }
            //如果冲突，就继续执行 array[n] = i; 即将第n个皇后，放置在本行得后移的一个位置
        }
    }

    //

    /**
     * 当我们放置第n个皇后, 就去检测该皇后是否和前面已经摆放的皇后冲突
     * @param n
     * @return
     */
    private boolean judge(int n) {
        judgeCount++;
        for (int a = 0; a < n; a++) {
            //说明
            //array[i] == array[n]  判断第n个皇后是否和前面的皇后在同一列
            //Math.abs(n-i) == Math.abs(array[n] - array[i]) 判断第n个皇后是否和第a个皇后在同一斜线
            //横坐标相减是否等于纵坐标相减
            //一维数组， 判断是否在同一行, 没有必要
            if (array[a] == array[n] || Math.abs(n - a) == Math.abs(array[n] - array[a])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 写一个方法，可以将皇后摆放的位置输出
     */
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}