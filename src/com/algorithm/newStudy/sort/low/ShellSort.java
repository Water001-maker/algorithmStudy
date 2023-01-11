package com.algorithm.newStudy.sort.low;

/**
 * @author xuemiao
 * @date 2023/1/11 12:44
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2};

        int[] shellSort = shellSort(arr);
        print(shellSort);

        int[] knuthSort = knuthSort(arr);
        print(knuthSort);

    }

    //希尔——对半分组
    public static int[] shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {//8,6,4,7中，gap=2时。gap-1为6的下标
                    if (arr[j - gap] > arr[j]) {
                        int temp = arr[j];
                        arr[j] = arr[j - gap];
                        arr[j - gap] = temp;
                    }
                }
            }
        }
        return arr;
    }

    //另一种分组方式
    public static int[] knuthSort(int[] arr) {
        int h = 1;
        while (h <= arr.length / 3) {
            h = h * 3 + 1;//求出适合当前数组的最大的分组数
        }
        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (arr[j - gap] > arr[j]) {
                        int temp = arr[j];
                        arr[j] = arr[j - gap];
                        arr[j - gap] = temp;
                    }
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
