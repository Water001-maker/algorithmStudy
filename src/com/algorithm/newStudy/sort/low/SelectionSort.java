package com.algorithm.newStudy.sort.low;

/**
 * @author xuemiao
 * @date 2023/1/11 12:44
 * 选择排序
 * 找到最小的，排到最前面
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2};
        sort(arr);
        print(arr);
    }

    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {//执行n次
            int minIndex = i;//执行n次
            for (int j = i + 1; j < arr.length; j++) {//执行n平方次
                //下标交换
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;//i=1时，执行n-1次；i=2时，执行n-2次...i=n-1时，执行1次；
            }
            int temp = arr[i];//执行n次
            arr[i] = arr[minIndex];//执行n次
            arr[minIndex] = temp;//执行n次
        }
        return arr;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
