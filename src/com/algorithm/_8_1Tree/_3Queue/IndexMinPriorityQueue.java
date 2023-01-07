package com.algorithm._8_1Tree._3Queue;

//索引最小优先队列
public class IndexMinPriorityQueue<T extends Comparable<T>> {
    //存储堆中的元素
    private T[] items;
    //存储每个元素在items数组中的索引，pq数组需要堆有序
    private int[] pq;
    //保存qp的逆序，pq的值作为索引，pq的索引作为值
    private int[] qp;
    //记录堆中元素的个数
    private int N;

    //构造方法
    public IndexMinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.pq = new int[capacity + 1];
        this.qp = new int[capacity + 1];
        this.N = 0;

        //默认情况下，队列中没有存储任何数据，让qp的元素都为-1
        for (int i = 0; i < qp.length; i++) {
            qp[i] = -1;
        }
    }

    //获取队列元素的个数
    public int size() {
        return N;
    }

    //判断队列是否为空
    public boolean inEmpty() {
        return N == 0;
    }

    //判断堆中索引为i,j两处元素的大小
    private boolean less(int i, int j) {
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    //交换堆中元素值
    private void exch(int i, int j) {
        //交换pq中的数据
        int tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;

        //此时，更新qp中的数据
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    //判断k对应的元素是否存在
    public boolean contains(int k) {
        return qp[k] != -1;
    }

    //最小元素关联的索引
    public int minIndex() {
        return pq[1];
    }

    //往队列中插入一个元素，并关联索引
    public void insert(int i, T t) {
        // 判断i是否已经被关联，如果已经被关联，不让插入
        if (contains(i)) {
            return;
        }
        //元素个数+1
        N++;
        //把数据存储到items对应的i位置处
        items[i] = t;
        //把i存储到pq中
        pq[N] = i;
        //用qp来记录pq的i
        qp[i] = N;

        //保持堆有序
        swim(N);
    }

    // 删除队列中最小的元素，并返回该元素关联的索引
    public int delMin() {
        int minIndex = pq[1];
        // 交换pq
        exch(1, N);
        // 删除qp中对应的内容
        qp[pq[N]] = -1;
        // 删除pq最大索引处的内容
        pq[N] = -1;
        // 删除items中对应的内容
        items[minIndex] = null;
        // 元素个数-1
        N--;
        // 下沉调整
        sink(1);

        return minIndex;
    }

    // 删除索引i关联的元素
    public void delete(int i) {
        //找出i在pq中的索引
        int k = pq[i];
        exch(k, N);
        qp[pq[N]] = -1;
        pq[N] = -1;
        items[k] = null;
        N--;
        // 因为元素k是在数组中的中间，所以需要先下沉再上浮，或者先上浮再下沉
        sink(k);
        swim(k);
    }

    // 修改索引i关联的元素为t
    public void changeItem(int i, T t) {
        items[i] = t;
        int k = qp[i];
        sink(k);
        swim(k);
    }

    // 上浮算法
    private void swim(int k) {
        while (k > 1) {
            if (less(k, k / 2)) {
                exch(k, k / 2); //这里面已经更新了pq[]和qp[]
            }
            k = k / 2;
        }
    }

    //下沉算法
    private void sink(int k) {
        while (2 * k <= N) {
            int min;
            if (2 * k + 1 <= N) {
                if (less(2 * k, 2 * k + 1)) {
                    min = 2 * k;
                } else {
                    min = 2 * k + 1;
                }
            } else {
                min = 2 * k;
            }

            //比较当前结点和较小值
            if (less(k, min)) {
                break;
            }
            exch(k, min);
            k = min; //把最小值赋值给当前结点
        }
    }
}

class IndexMinPriorityQueueDemo {

    public static void main(String[] args) {
        IndexMinPriorityQueue queue = new IndexMinPriorityQueue(10);

        queue.insert(0, "A");
        queue.insert(1, "B");
        queue.insert(2, "C");
        queue.insert(3, "D");
        queue.insert(4, "E");
        queue.insert(5, "F");
        queue.insert(6, "G");
        queue.insert(7, "H");
        queue.insert(8, "I");

        queue.changeItem(0, "S");

        while (!queue.inEmpty()) {
            int index = queue.delMin();
            System.out.println(index+ " ");
        }
    }


}