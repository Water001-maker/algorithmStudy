package com.algorithm.old.LeetCode.SuanFa.Day17.Test02;

import java.util.PriorityQueue;

public class Test {

    public static void main(String[] args) {




    }

}

class MedianFinder {

    //大顶堆，存储左半边的元素（求最小中的最大值）
    private PriorityQueue<Integer> left;
    //小顶堆，存储右半边的元素（求最大中的最小值）
    private PriorityQueue<Integer> right;
    //当前数据流读入的元素个数
    private int N = 0;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        //初始化
        //大顶堆存小值
        left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        //小顶堆存大值
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        //插入要保证两个堆存于平衡
        if (N % 2 == 0) {
            /*
            N为偶数的情况下插到右半边
            因为右半边元素都要大于左半边，但是新插入的元素不一定对左半边元素大
            因此需要先将元素插入左半边，然后利用左半边为大顶堆的特点
            取出堆顶元素的特点，取出对顶元素（最大元素），插入右半边
             */
            //大顶堆加入新元素
            left.add(num);
            //小顶堆加入大顶堆的堆顶
            right.add(left.poll());
        } else {
            //小顶堆加入新元素
            right.add(num);
            //大顶堆加入小顶堆的堆顶
            left.add(right.poll());
        }
        N++;
    }

    public double findMedian() {
        if (N % 2 == 0) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return (double) right.peek();
        }
    }
}
