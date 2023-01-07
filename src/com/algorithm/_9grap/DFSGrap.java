package com.algorithm._9grap;

import java.util.ArrayList;
import java.util.Arrays;

//深度优先
public class DFSGrap {

    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges;//存储树对应的邻结矩阵
    private int numOfEdges;//表示边的数目
    //定义给数组boolean[],记录某个结点是否被访问
    private boolean[] isVisited;


    //构造器
    public DFSGrap(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[0];
    }

    //返回节点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //得到变的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回结点i下标（对应的数据 0->"A" 1->"B" 2->"C"）
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //显示图对应的矩阵
    public void show() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    //插入节点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     *
     * @param v1     表示点的下标即是第几个顶点："A"-"B" "A"->"0" "B"->1
     * @param v2     表示第二个顶点对应的下标
     * @param weight 表示权值
     */
    public void insertEdges(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    /**
     * 获取第一个邻接结点的下标
     *
     * @param index 当前访问的结点
     * @return 如果存在就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接结点的下标来获取下一个邻接结点
     * 查找结点v1的第一个邻接结点v2的下一个邻接结点
     *
     * @param v1 当前被访问结点的下标
     * @param v2 当前结点的第一个邻接结点
     * @return 结点v1的第一个邻接结点v2的下一个邻接结点
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //深度优先

    /**
     * @param isVisited 用来判断当前结点i是否被访问的boolean数组
     * @param i         被访问的结点下标
     */
    private void dfs(boolean[] isVisited, int i) {
        //首先访问该结点，输出
        System.out.print(getValueByIndex(i) + "->");
        //将结点设置为已经访问
        isVisited[i] = true;
        //查找结点i的第一个邻接结点
        int firstNeighbor = getFirstNeighbor(i);
        while (firstNeighbor != -1) {//说明存在邻接结点
            if (!isVisited[firstNeighbor]) {//没有被访问过，
                dfs(isVisited, firstNeighbor);
            }
            //如果firstNeighbor已经被访问过
            //查找结点i的第一个邻接结点的下一个邻接结点
            firstNeighbor = getNextNeighbor(i, firstNeighbor);
        }
    }

    //对dfs进行重载，遍历我们所有的结点，并进行dfs
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        //便利所有的结点，进行dfs[回溯]
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

}

class DFSGrapDemo {
    public static void main(String[] args) {
        int n = 5;
        String[] VertexValue = {"A", "B", "C", "D", "E"};
        //创建图对象
        DFSGrap grap = new DFSGrap(n);
        //循环添加顶点
        for (String vertex : VertexValue) {
            grap.insertVertex(vertex);
        }
        //添加边
        //A-B A-C B-C B-D B-E
        grap.insertEdges(0, 1, 1);
        grap.insertEdges(0, 2, 1);
        grap.insertEdges(1, 2, 1);
        grap.insertEdges(1, 3, 1);
        grap.insertEdges(1, 4, 1);

        //显示
        grap.show();

        System.out.println("深度遍历");
        grap.dfs();

    }
}