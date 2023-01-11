package com.algorithm.newStudy.sort.high;

import java.lang.reflect.Array;


/**
 * @author xuemiao
 * @date 2023/1/11 12:43
 * 快速排序
 * 拓展学习——Arrays.sort():双轴快排
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2};
        sort(arr, 0, arr.length - 1);
        print(arr);
    }

    public static void sort(int[] arr, int leftBound, int rightBound) {
        if (leftBound >= rightBound) {
            return;
        }
        int mid = partition(arr, leftBound, rightBound);
        sort(arr, leftBound, mid-1);
        sort(arr, mid+1, rightBound);
    }

    public static int partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;
        while (left <= right) {
            while (left <= right && arr[left] <= pivot) left++;
            while (left <= right && arr[right] > pivot) right--;

            if (left < right) swap(arr, left, right);
        }
        swap(arr, left, rightBound);
        return left;
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
