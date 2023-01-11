package com.algorithm.newStudy.sort.high;

/**
 * @author xuemiao
 * @date 2023/1/11 12:42
 * 插入排序
 * 将第i个数，依次和i之前的数进行比较，若小于则将此数前移
 * 拓展学习——Arrays.sort():双插
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2};
        sort(arr);
        print(arr);
    }

    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j -1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
