package com.algorithm._6Search;

public class SeqSearch {
    public static void main(String[] args) {
        int arr[] = {1, 9, 11, -1, 34, 89};
        int index = seqSearch(arr, 11);
        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("找到数字的第一个位置是" + index);
        }
    }

    public static int seqSearch(int[] arr, int value) {
        //线性查找是逐一比对，发现有相同值，就返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}