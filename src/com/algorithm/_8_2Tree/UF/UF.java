package com.algorithm._8_2Tree.UF;

//并查集
public class UF {

    //记录并差好几种数据的分组个数
    private int[] eleAndGroup;
    //记录并吃噶合计中数据的分组个数
    private int count;

    //初始化并查集
    public UF(int N) {
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

    //元素p所在分组的标识符
    public int find(int p) {
        return eleAndGroup[p];
    }

    //判断并查集中元素p和元素q是否在同一分组中(判断两个元素的标识符是否相等)
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    //把p元素所在分组和q元素所在分组合并
    public void union(int p, int q) {
        //判断p、q是不是已经在同一分组中，如果已经在同一分组中，直接结束方法
        if (connected(p, q)) {
            return;
        }

        //不在同一分组中
        //找到p所在分组的标识符
        int pGroup = find(p);
        //找到q所在分组的标识符
        int qGroup = find(q);
        //合并：让p所在组的所有元素的组标识符变为q所在分组的标识符
        for (int i = 0; i < eleAndGroup.length; i++) {
            if (eleAndGroup[i] == pGroup) eleAndGroup[i] = qGroup;
        }
        //分组个数-1
        this.count--;
    }
}
