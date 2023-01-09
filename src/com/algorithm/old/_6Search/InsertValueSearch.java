package com.algorithm.old._6Search;

public class InsertValueSearch {
    public static void main(String[] args) {
       /* int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }*/
        int[] arr = {1, 8, 10, 89, 1000,1000,1000, 1234};
        int index = insertValSearch(arr, 0, arr.length-1, 1234);
        System.out.println("index="+index);
    }

    //插值查找  要求数组有序
    public static int insertValSearch(int[] arr, int left, int right, int findVal) {
        //findVal < arr[0] || findVal > arr[arr.length - 1] 必须有 防止mid越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left])  ;
        int midVal = arr[mid];
        if (findVal > midVal) {
            return insertValSearch(arr, mid + 1, right, findVal);//向右递归
        } else if (findVal < midVal) {
            return insertValSearch(arr, left, mid - 1, findVal);//向左递归
        } else {
            return mid;
        }
    }
}

