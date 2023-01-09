package com.algorithm.old._9grap;

import java.util.ArrayList;
import java.util.Arrays;

public class Grap {

    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges;//存储树对应的邻结矩阵
    private int numOfEdges;//表示边的数目

    public static void main(String[] args) {
        int n = 5;
        String VertexValue[] = {"A", "B", "C", "D", "E"};
        //创建图对象
        Grap grap = new Grap(n);
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
        grap.insertEdges(0, 4, 1);

        //显示
        grap.show();

    }

    //构造器
    public Grap(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
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

}
