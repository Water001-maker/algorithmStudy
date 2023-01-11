package com.algorithm.newStudy.sort.high;

/**
 * @author xuemiao
 * @date 2023/1/11 12:43
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 8, 3, 6, 9};
        sort(arr, 0, arr.length - 1);
        print(arr);
    }

    public static void sort(int[] arr, int left, int right) {
        if (left == right) return;
        int mid = left + (right - left) / 2;//(right + left) / 2时，right + left可能会越界
        //左半递归
        sort(arr, left, mid);
        //右半
        sort(arr, mid + 1, right);
        //合并
        merge(arr, left, mid + 1, right);
    }

    /**
     * @param arr
     * @param leftPtr    左指针
     * @param rightPtr   右指针
     * @param rightBound 右边界
     */
    public static void merge(int[] arr, int leftPtr, int rightPtr, int rightBound) {
        int mid = rightPtr - 1;
        int[] temp = new int[rightBound - leftPtr + 1];

        int i = leftPtr;
        int j = rightPtr;
        int k = 0;

        //
        while (i <= mid && j <= rightBound) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        //左半
        while (i <= mid) temp[k++] = arr[i++];
        //右半
        while (j <= rightBound) temp[k++] = arr[j++];

        //将temp的值复制到arr中
        for (int m = 0; m < temp.length; m++) arr[leftPtr + m] = temp[m];

    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //timeSort
    //分成很多块，每一小块按照二分插入排序后，两两归并，；插入排序，归并
    //binarySort
    //二分插入排序
}
