package com.algorithm._10tenAlgorithm._1BinarySearch;

//非递归实现二分查找
public class BinarySearch {

    /**
     * 二分查找的非递归实现
     *
     * @param arr    待查找的数组，arr是升序排列
     * @param target 需要查找的数
     * @return 返回对应下标
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;//左头
        int right = arr.length - 1;//右头
        while (left <= right) {
            int mid = (left + right) / 2;//中间值
            if (arr[mid] == target) {//找到
                return mid+1;
            } else if (arr[mid] > target) {
                right = mid - 1;//需要向左边查找
            } else {
                left = mid + 1;//需要向右边查找
            }
        }
        return -1;
    }

}

class BinarySearchDemo {

    public static void main(String[] args) {

        int[] arr = {1, 3, 8, 10, 11, 67, 100};

        int i = BinarySearch.binarySearch(arr, 10);

        System.out.println(i);

    }

}