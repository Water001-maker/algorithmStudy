package com.algorithm.old._10tenAlgorithm._8Dijkstra;

import java.util.Arrays;

//迪杰特斯拉算法
public class DijkstraAlgorithm {

    public static void main(String[] args) {

        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] martex = new int[vertexs.length][vertexs.length];
        final int N = 65535;
        martex[0] = new int[]{N, 5, 7, N, N, N, 2};
        martex[1] = new int[]{5, N, N, 9, N, N, 3};
        martex[2] = new int[]{7, N, N, N, 8, N, N};
        martex[3] = new int[]{N, 9, N, N, N, 4, N};
        martex[4] = new int[]{N, N, 8, N, N, 5, 4};
        martex[5] = new int[]{N, N, N, 4, 5, N, 6};
        martex[6] = new int[]{2, 3, N, N, 4, 6, N};

        //创建一个图对象
        Graph graph = new Graph(vertexs, martex);
        graph.show();
        //测试
        graph.dijkstra(6);

        graph.showDijkstra();
    }

}

//已访问的顶点结合
class VisitedVertex {
    //记录这个顶点是否被访问过，1表示访问过、0表示没访问过，动态更新
    public int[] already_arr;
    //每个下标对应的值为前一个顶点下标，会动态更新
    public int[] pre_visited;
    //记录出发顶点到其他顶点的距离
    //以G为出发点为例，会记录G到其他顶点的距离，并动态更新，求出最端距离时就会放到dis
    public int[] dis;

    /**
     * 构造器
     */
    public VisitedVertex(int length, int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];

        //初始化dis数组
        Arrays.fill(dis, 65535);
        this.already_arr[index] = 1;//设置出发顶点为被访问
        this.dis[index] = 0;//出发顶点到自己的距离为0
    }

    /**
     * 判断index顶点是否被访问过
     *
     * @param index 当前结点的下标
     * @return 如果访问过就返回true, 否则就返回false
     */
    public boolean in(int index) {
        return already_arr[index] == 1;
    }

    /**
     * 更新出发顶点到结点index结点的距离
     *
     * @param index
     * @param len
     */
    public void updateDis(int index, int len) {
        dis[index] = len;
    }

    /**
     * 更新顶点pre的前驱结点为index结点
     *
     * @param pre
     * @param index
     */
    public void updatePre(int pre, int index) {
        pre_visited[pre] = index;
    }

    /**
     * 返回出发顶点到index顶点的距离
     *
     * @param index
     */
    public int getDis(int index) {
        return dis[index];
    }

    /**
     * 遍历修改
     *
     * @return
     */
    public int updateArr() {
        int min = 65535, index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min) {//未访问、求出最短路径
                min = dis[i];
                index = i;
            }
        }
        //更新index顶点 被访问过
        already_arr[index] = 1;
        return index;
    }

    /**
     * 显示最后的结果，即，输出三个数组
     */
    public void show() {
        System.out.println("already_arr:");
        for (int i : already_arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("pre_visited:");
        for (int i : pre_visited) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("dis:");
        for (int i : dis) {
            System.out.print(i + " ");
        }
        System.out.println();

        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int count = 0;
        for (int i : dis) {
            if (i != 65535) {
                System.out.print(vertexs[count] + "(" + i + ")" + " ");
            } else {
                System.out.println("N");
            }
        }
    }
}

//创建图
class Graph {
    private char[] vertex;//顶点数组
    private int[][] matrix;//邻接矩阵——边
    private VisitedVertex visitedVertex;//已经访问的顶点的集合

    //构造器
    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    //显示图
    public void show() {
        for (int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 迪杰斯特拉算法
     *
     * @param index 出发顶点对应的下标
     */
    public void dijkstra(int index) {
        visitedVertex = new VisitedVertex(vertex.length, index);
        update(index);//更新index顶点到周围顶点的距离和前驱结点
        //遍历
        for (int i = 1; i < vertex.length; i++) {
            index = visitedVertex.updateArr();//选择并返回新的访问顶点
            update(index);//更新index顶点到周围顶点的 距离和前置结点
        }
    }

    /**
     * 更新index下标顶点到周围顶点的距离 和 周围顶点的前驱结点
     *
     * @param index
     */
    private void update(int index) {
        int len = 0;//距离
        //遍历邻接矩阵的 matrix[index] 行 ,遍历当前顶点到周围顶点的距离
        for (int i = 0; i < matrix[index].length; i++) {
            //len :出发顶点到index顶点的距离 + 从index结点到i结点距离
            len = visitedVertex.getDis(index) + matrix[index][i];
            //如果i顶点没有被访问过，并且len小于出发顶点到i顶点的距离，就需要更新
            if (!visitedVertex.in(i) && len < visitedVertex.getDis(i)) {
                visitedVertex.updatePre(i, index);//更新i结点的前置结点为index结点
                visitedVertex.updateDis(i, len);//更新出发点到i结点的距离
            }
        }
    }

    public void showDijkstra() {
        visitedVertex.show();
    }

}