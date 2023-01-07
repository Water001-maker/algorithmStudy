package com.algorithm._8_1Tree._3Queue;

//最小优先队列
public class MinPriorityQueue<T extends Comparable<T>> {
    //存储队中的元素
    private T[] items;

    //存储堆中元素的个数
    private int N;

    //构造方法，获取队列中元素的个数
    public MinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    //判断队列个数
    public int size() {
        return N;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //判断堆中索引处的元素是否小于索引j处的元素
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    //交换堆中i索引和j索引处的值
    private void exch(int i, int j) {
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    //往堆中植入一个元素
    public void insert(T t) {
        items[++N] = t;//添加至队尾
        swim(N);
    }

    //删除堆中最小的元素，并返回这个最小元素
    public T delMax() {
        T min = items[1];
        exch(1, N);//将索引为1和索引为N的元素交换
        N--;//移除
        sink(1);
        return min;
    }

    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    //将添加至队尾的结点，上浮至正确的位置
    public void swim(int k) {
        while (k > 1) {//通过while循环比较当前结点和父元素的大小
            if (less(k, k / 2)) {//k/2处的值大于k处的值
                exch(k, k / 2);//交换k/2处、k处的值，把较小的值往前放
            }
            k = k / 2;//k指向k/2
        }
    }

    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    //删除时，将队尾的值移动至k=1处，该方法用于将此值下沉至正确的位置
    public void sink(int k) {
        while (2 * k <= N) {//通过while循环比较当前结点和子结点中较大结点的值
            int min;//索引，记录子节点
            if (2 * k + 1 <= N) {//有右子结点，左右节点作比较
                if (less(2 * k, 2 * k + 1)) {//左子结点的值小于右子结点的值
                    min = 2 * k;//max记录左子结点的值
                } else {
                    min = 2 * k + 1;//max记录右子结点的值
                }
            } else {//直接返回左子结点
                min = 2 * k;
            }

            if (less(k, min)) {//比较大小，如果当前结点小于子结点中的较小值
                break;//跳出循环
            }

            //如果当前结点大于子结点中的较小值
            exch(k, min);//交换

            k = min;//k指向min
        }
    }
}


class MinPriorityQueueDemo {
    public static void main(String[] args) {
        //创建优先队列
        MinPriorityQueue<Integer> queue = new MinPriorityQueue<>(10);

        //往队列中存储元素
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);
        queue.insert(7);
        queue.insert(8);

        //通过循环从队列中获取最大的元素
        while (!queue.isEmpty()) {
            Integer i = queue.delMax();
            System.out.println(i);
        }

    }
}
