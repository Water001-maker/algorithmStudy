package com.algorithm.old._9grap;

public class Test {
    public static void main(String[] args) {

        //广度优先
        int n = 8;
        String VertexValue[] = {"1", "2", "3", "4", "5","6","7","8"};
        //创建图对象
        BFSGrap bfsGrap = new BFSGrap(n);
        //循环添加顶点
        for (String vertex : VertexValue) {
            bfsGrap.insertVertex(vertex);
        }
        //添加边
        //A-B A-C B-C B-D B-E
        bfsGrap.insertEdges(0, 1, 1);
        bfsGrap.insertEdges(0, 2, 1);
        bfsGrap.insertEdges(1, 3, 1);
        bfsGrap.insertEdges(1, 4, 1);
        bfsGrap.insertEdges(3, 7, 1);
        bfsGrap.insertEdges(4, 7, 1);
        bfsGrap.insertEdges(2, 5, 1);
        bfsGrap.insertEdges(2, 6, 1);
        bfsGrap.insertEdges(5, 6, 1);

        System.out.println("广度优先：");
        bfsGrap.bfs();

        System.out.println();

        //深度优先
        //创建图对象
        DFSGrap dfsGrap = new DFSGrap(n);
        //循环添加顶点
        for (String vertex : VertexValue) {
            dfsGrap.insertVertex(vertex);
        }
        //添加边
        //A-B A-C B-C B-D B-E
        dfsGrap.insertEdges(0, 1, 1);
        dfsGrap.insertEdges(0, 2, 1);
        dfsGrap.insertEdges(1, 3, 1);
        dfsGrap.insertEdges(1, 4, 1);
        dfsGrap.insertEdges(3, 7, 1);
        dfsGrap.insertEdges(4, 7, 1);
        dfsGrap.insertEdges(2, 5, 1);
        dfsGrap.insertEdges(2, 6, 1);
        dfsGrap.insertEdges(5, 6, 1);

        System.out.println("深度优先：");
        dfsGrap.dfs();

    }
}
