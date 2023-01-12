package com.algorithm.newStudy.sort.high;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;


/**
 * @author xuemiao
 * @date 2023/1/11 12:43
 * 快速排序
 * 拓展学习——Arrays.sort():双轴快排
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 8, 1, 9, 4, 2, 7};
        //sort(arr, 0, arr.length - 1);
        //sort2(arr, 0, arr.length - 1);
        partition4(arr);
        print(arr);
    }

    public static void sort(int[] arr, int leftBound, int rightBound) {
        if (leftBound >= rightBound) {
            return;
        }
        int mid = partition(arr, leftBound, rightBound);
        sort(arr, leftBound, mid - 1);
        sort(arr, mid + 1, rightBound);
    }

    public static void sort2(int[] arr, int leftBound, int rightBound) {
        if (leftBound >= rightBound) {
            return;
        }
        int[] equalE = partition3(arr, leftBound, rightBound);
        sort2(arr, leftBound, equalE[0] - 1);
        sort2(arr, equalE[1] + 1, rightBound);
    }

    /**
     * 实现一
     *
     * @param arr
     * @param leftBound  左边界
     * @param rightBound 右边界
     * @return
     */
    public static int partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;
        while (left <= right) {
            while (left <= right && arr[left] <= pivot) left++;//从左开始与基准值依次比较，若小于等于则跳过（左侧存放小的值）
            while (left <= right && arr[right] > pivot) right--;//从右开始与基准值依次比较，若大于等于则跳过（右侧存放大的值）

            if (left < right) swap(arr, left, right);//将大于基准值的左侧的数和小于基准值的右侧的数交换
        }
        swap(arr, left, rightBound);
        return left;//返回的是根据原数组末尾数在经过快排之后的下标
        //[5, 3, 6, 8, 1, 7, 9, 4, 2]   =》[1, 2, 6, 8, 5, 7, 9, 4, 3]
        //对原数组快排后，在新数组中原数组末尾元素的下标
    }

    /**
     * 实现思想简化
     *
     * @param arr
     */
    public static void partition2(int[] arr) {
        int l = arr.length;
        int left = -1;
        int right = l - 1;
        int index = 0;
        while (index <= right) {
            if (arr[index] < arr[l - 1]) {
                swap(arr, ++left, index++);
            } else if (arr[index] > arr[l - 1]) {
                swap(arr, --right, index++);
            } else {
                index++;
            }
        }
    }


    /**
     * 实现二
     *
     * @param arr
     * @param L
     * @param R
     * @return 返回基准值的前一个下标和他自身的下标
     */
    public static int[] partition3(int[] arr, int L, int R) {
        int left = L - 1;
        int right = R;
        int index = L;
        while (index < right) {
            if (arr[index] < arr[R]) {
                swap(arr, ++left, index++);
            } else if (arr[index] > arr[R]) {
                swap(arr, --right, index);
            } else {
                index++;
            }
        }
        swap(arr, right, R);
        return new int[]{left + 1, right};
    }


    public static class Job {
        public int L;
        public int R;

        public Job(int left, int right) {
            L = left;
            R = right;
        }
    }

    /**
     * 非递归实现
     *
     * @param arr
     * @return
     */
    public static void partition4(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        Stack<Job> stack = new Stack<>();
        stack.push(new Job(0, arr.length - 1));
        while (!stack.isEmpty()) {
            Job cur = stack.pop();
            int[] equals = partition3(arr, cur.L, cur.R);
            if (equals[0] > cur.L) { // 有< 区域
                stack.push(new Job(cur.L, equals[0] - 1));
            }
            if (equals[1] < cur.R) { // 有 > 区域
                stack.push(new Job(equals[1] + 1, cur.R));
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
