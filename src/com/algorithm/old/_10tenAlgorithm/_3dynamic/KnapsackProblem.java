package com.algorithm.old._10tenAlgorithm._3dynamic;

//01背包
public class KnapsackProblem {

    public static void main(String[] args) {

        int[] weight = {1, 4, 3};//物品的重量
        int[] value = {1500, 3000, 2000};//物品的价值，这里的value[i]就是v[i]
        int m = 4;//背包的容量
        int n = value.length;//物品的个数

        //创建二维数组，表示背包
        //v[i][j] 表示在前i个物品中能装入容量为j的背包中的最大价值
        int[][] v = new int[n + 1][m + 1];

        //为了记录放入商品的情况，我们定一个二维数组
        int[][] path = new int[n + 1][m + 1];

        //初始化第一行和第一列，在本程序中可以不写，因为默认为0
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;//将第一列设置为0
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;//将第一行设置为0
        }

        //根据前面得到的公式来动态规划处理
        for (int i = 1; i < v.length; i++) {//不处理第一行，i是从1开始的
            for (int j = 1; j < v[0].length; j++) {//不处理第一列，j是从1开始的
                //公式
                if (weight[i - 1] > j) {//当准备加入的商品的容量大于当前背包的容量时，因为我们程序i是从1开始的，因此原来公式中的w[i]修改为w[i-1]
                    v[i][j] = v[i - 1][j];//直接使用上一个单元格的装入策略
                } else {// 当准备加入的新增的商品的容量小于等于当前背包的容量。
                    //比较 上一个单元格能装入的最大价值 和 表示当前商品的价值+能加入的上一个商品最大数量的价值 的大小，那种情况价值大，取哪种情况。
                    //因为我们程序i是从1开始的，因此原来公式中的value[i]修改为value[i-1],weight[i]该我weight[i-1]

                    //v[i][j] = Math.max(v[i - 1][j], value[i - 1] + v[i ][j - weight[i]]);//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: -3
                    //v[i][j] = Math.max(v[i - 1][j], value[i - 1] + v[i - 1][j - weight[i - 1]]);

                    //为了记录商品存放到背包的情况，我们不能兼得使用上面的工具
                    if (v[i - 1][j] < value[i - 1] + v[i - 1][j - weight[i - 1]]) {
                        v[i][j] = value[i - 1] + v[i - 1][j - weight[i - 1]];
                        //把当前的情况记录到path
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        //遍历v，查看一下当前情况
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        //输出最后我们放入的商品
        //遍历path

        //        这样输出会把所有放入情况都得到，而我们只需要最后的放入
//        for (int i = 0; i < path.length; i++) {
//            for (int j = 0; j < path[i].length; j++) {
//                if (path[i][j] == 1) {
//                    System.out.print("第" + i + "个商品放入到背包");
//                    j -= weight[i - 1];
//                }
//            }
//        }

        System.out.println("价值最大的情况");
        int i = path.length - 1;//行的最大下标
        int j = path[0].length - 1;//列的最大下标
        while (i > 0 && j > 0) {//从path的最后开始找
            if (path[i][j] == 1) {
                System.out.println("第" + i + "个商品放入到背包");
                j -= weight[i - 1];//包的重量-当前商品的重量
            }
            i--;//已经找到一个商品，寻找下一个商品
        }

    }

}
