package com.algorithm._10tenAlgorithm._9Floyd;

import java.util.Arrays;

public class FloydAlgorithm {

    public static void main(String[] args) {
        //测试看看图是否创建成功
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //创建邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[]{0, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, 0, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, 0, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, 0, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, 0, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, 0, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, 0};
        Graph graph = new Graph(7, matrix, vertex);

        System.out.println("佛洛依德算法执行前：");
        graph.show();

        graph.floyd();
        System.out.println("佛洛依德算法执行后：");
        graph.show();
    }

}

class Graph {

    private char[] vertex;//存放顶点的数组
    private int[][] dis;//存放从各个顶点出发到其他顶点的距离(最后的结果也保留在该数组中)
    private int[][] pre;//存放各个顶点的前驱结点
    final int N = 65535;

    /**
     * 构造器
     *
     * @param length 大小
     * @param matrix 邻接矩阵
     * @param vertex 顶点数组
     */
    public Graph(int length, int[][] matrix, char[] vertex) {
        this.vertex = vertex;
        this.dis = matrix;
        this.pre = new int[length][length];

        //对pre数组进行初始化,存放前驱结点的下标
        for (int i = 0; i < pre.length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    //显示
    public void show() {
        //pre
        for (int i = 0; i < dis.length; i++) {
            //先输出pre数组
            for (int j = 0; j < pre.length; j++) {
                System.out.print(vertex[pre[i][j]] + " ");
            }
            System.out.println();
            //再输出dis数组
            for (int j = 0; j < dis.length; j++) {
                System.out.print("（" + vertex[i] + "—>" + vertex[j] + ",min：" + dis[i][j] + "） ");
            }
            System.out.println();
            System.out.println();

        }
    }

    //弗洛伊德算法

    /**
     * 弗洛伊德算法
     */
    public void floyd() {
        int len = 0;//变量保存距离
        //i 通过 k中间节点 到 j
        //对中间顶点的遍历，k就是中间顶点的下标
        for (int k = 0; k < dis.length; k++) {
            //从i顶点开始出发：[A,B,C,D,E,F,G]
            for (int i = 0; i < dis.length; i++) {
                //到达j顶点
                for (int j = 0; j < dis.length; j++) {
                    if (k != i && k != j && dis[i][k] != N && dis[k][j] != N) {
                        len = dis[i][k] + dis[k][j];//=>求出从i顶点出发，经过k中间顶点，到达j顶点的距离
                        if (len < dis[i][j]) {
                            //如果len小于dis[i][j]
                            dis[i][j] = len;//更新距离
                            pre[i][j] = pre[k][j];//更新前驱顶点
                        }
                    }
                }
            }
        }
    }

}