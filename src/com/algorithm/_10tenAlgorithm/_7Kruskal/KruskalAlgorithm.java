package com.algorithm._10tenAlgorithm._7Kruskal;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Arrays;

public class KruskalAlgorithm {

    private int edgeNum;//边的个数
    private char[] verstexs;//顶点数组——顶点
    private int[][] matrix;//邻接矩阵——边
    //使用INF表示两个顶点不能连通
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {

        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        //克鲁斯卡尔算法的邻接矩阵

        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF},
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 7, 6, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, 0}};

        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm(vertexs, matrix);
        kruskalAlgorithm.show();

        System.out.println("排序前:");//没有排序
        for (int i = 0; i < kruskalAlgorithm.getEdges().length; i++) {
            System.out.println(kruskalAlgorithm.getEdges()[i]);
        }

        System.out.println("排序后:");//没有排序
        for (int i = 0; i < kruskalAlgorithm.getEdges().length; i++) {
            System.out.println(kruskalAlgorithm.sortEdges(kruskalAlgorithm.getEdges())[i]);
        }

        kruskalAlgorithm.kruskal();

    }

    //构造器
    public KruskalAlgorithm(char[] verstexs, int[][] matrix) {
        //初始化定点数和边的个数
        int vlen = verstexs.length;

        //初始化顶点
        this.verstexs = new char[vlen];//新建数组
        for (int i = 0; i < verstexs.length; i++) {
            this.verstexs[i] = verstexs[i];
        }

        //初始化边
        this.matrix = new int[vlen][vlen];//新建数组
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }

        //统计边
        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    //打印邻接矩阵
    public void show() {
        System.out.println("邻接矩阵为：");
        for (int i = 0; i < verstexs.length; i++) {
            for (int j = 0; j < verstexs.length; j++) {
                System.out.printf("%-12d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 功能：对边进行排序处理
     *
     * @param edges 边的集合
     */
    private EData[] sortEdges(EData[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {//交换
                    EData tmp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = tmp;
                }
            }
        }
        return edges;
    }

    /**
     * 返回队形下标
     *
     * @param ch 顶点的值，比如'A','B'
     * @return 返回ch对应的下标，如果找不到，返回-1
     */
    private int getPosition(char ch) {
        for (int i = 0; i < verstexs.length; i++) {
            if (verstexs[i] == ch) {
                return i;
            }
        }
        //找不到，返回-1
        return -1;
    }

    /**
     * 获取图中的边，放到EData[]数组中，后面我们需要遍历该数组
     * 是通过matrix邻接矩阵来获取
     * EData[] 形式[['A','B',12],['B','F',7],……]
     *
     * @return
     */
    private EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < verstexs.length; i++) {
            for (int j = i + 1; j < verstexs.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(verstexs[i], verstexs[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 获取下标为i的顶点的终点,用于后面判断两个顶点的终点是否相同
     *
     * @param ends 数组记录了各个顶点对应的终点是哪个，ends 数组是在遍历过程中逐步判断形成的
     * @param i    传入的顶点对应的下标
     * @return 返回的是下表为i这个顶点对应的重点的下标
     */
    private int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    public void kruskal() {
        int index = 0;//表示最后结果数组的索引
        int[] ends = new int[edgeNum];//用于保存已有的最小生成树中每一个顶点在最小生成树中的终点
        //创建结果数组，保存最后的最小生成树
        EData[] rets = new EData[edgeNum];

        //获取图中所有的边的集合，一共有十二条边
        EData[] edges = getEdges();

        System.out.println("图的边的集合如下，共" + edges.length + "条");
        for (int i = 0; i < edges.length; i++) {
            System.out.println(edges[i]);
        }

        //按照边的权值大小进行排序（从小到大）
        sortEdges(edges);

        //遍历edges数组，将边添加到最小生成树中是，判断准备加入的边是否生成了回路，如果没有，就加入rets，否则不能加入
        for (int i = 0; i < edgeNum; i++) {
            //获取到第i条边的第一个顶点（起点）
            int p1 = getPosition(edges[i].start);
            //获取到第i跳变的第2个顶点
            int p2 = getPosition(edges[i].end);

            //获取p1顶点在已有最小生成树中的终点
            int m = getEnd(ends, p1);
            //获取p1顶点在已有最小生成树中的终点
            int n = getEnd(ends, p2);
            //是否构成回路
            if (m != n) {//没有构成回路
                ends[m] = n;//设置m在已有最小生成树中的终点
                rets[index++] = edges[i];//有一条边加入到rets数组
            }
            System.out.println("ends:" + Arrays.toString(ends));
            //ends:[A，B, C, D, E, F, G, 0, 0, 0, 0, 0]
            //ends:[0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0]
            //ends:[0, 0, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0]
            //ends:[0, 0, 3, 5, 5, 0, 0, 0, 0, 0, 0, 0]
            //ends:[0, 0, 3, 5, 5, 0, 0, 0, 0, 0, 0, 0]
            //ends:[0, 0, 3, 5, 5, 0, 0, 0, 0, 0, 0, 0]
            //ends:[0, 5, 3, 5, 5, 0, 0, 0, 0, 0, 0, 0]
            //ends:[0, 5, 3, 5, 5, 6, 0, 0, 0, 0, 0, 0]
            //ends:[0, 5, 3, 5, 5, 6, 0, 0, 0, 0, 0, 0]
            //ends:[0, 5, 3, 5, 5, 6, 0, 0, 0, 0, 0, 0]
            //ends:[6, 5, 3, 5, 5, 6, 0, 0, 0, 0, 0, 0]
            //ends:[6, 5, 3, 5, 5, 6, 0, 0, 0, 0, 0, 0]
            //ends:[6, 5, 3, 5, 5, 6, 0, 0, 0, 0, 0, 0]
        }


        //统计并打印“最小生成树”，输出rest数组
        System.out.println("最小生成树为：");
        for (int i = 0; i < index; i++) {
            System.out.println(rets[i]);
        }

    }

}

//创建一个Data，他的对象实例就表示一条边
class EData {
    char start;//边的一个点
    char end;//边的另外一个点
    int weight;//边的权值

    //构造器
    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    //重写toSstring，便于输出边的信息
    public String toString() {
        return "EDATA [<" + start + "," + end + ">=" + weight + "]";
    }

}