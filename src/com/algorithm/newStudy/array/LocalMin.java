package com.algorithm.newStudy.array;

/**
 * @author xuemiao
 * @date 2023/1/12 20:05
 * 获取局部最小值的下标
 */
public class LocalMin {
    /**
     * 获取局部最小值的下标
     *
     * @param arr
     * @return
     */
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (left - right) >> 1;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            }
            if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

}
