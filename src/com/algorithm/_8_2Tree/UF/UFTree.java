package com.algorithm._8_2Tree.UF;

//并查集
public class UFTree {

    //记录并差好几种数据的分组个数
    private int[] eleAndGroup;
    //记录并吃噶合计中数据的分组个数
    private int count;

    //初始化并查集
    public UFTree(int N) {
        //初始化分组的数量
        this.count = N;

        //初始化eleAndGroup数组
        this.eleAndGroup = new int[N];

        //初始化eleAndGroup中元素及其所在数组的标识符
        //让eleAndGroup数组的索引作为变成嘎哈及的每个节点的元素
        //并且让每个索引处的值（该元素所在的组的标识符）就是该索引
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }
    }

    //获取当前并查集中的数据有多少分组
    public int getCount() {
        return count;
    }

    //判断并查集中元素p和元素q是否在同一分组中(判断两个元素的标识符是否相等)
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    //元素p所在分组的标识符
    public int find(int p) {
        while (true) {
            if (p == eleAndGroup[p]) {
                return p;
            } else {
                p = eleAndGroup[p];
            }
        }
    }

    //把p元素所在分组和q元素所在分组合并
    public void union(int p, int q) {
        //p的根节点
        int pRoot  = find(p);
        //q的根节点
        int qRoot  = find(q);
        if (pRoot  == qRoot ) {
            return;
        }
        //让p所在树的根节点的父节点变为q所在树的根节点即可
        eleAndGroup[pRoot] = qRoot ;

        //组的数量-1
        this.count--;
    }
}

