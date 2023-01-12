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

        //左右比较，将小的加到temp数组中
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

    /**
     * 非递归
     * 越界问题
     * @param arr
     */
    public static void merge2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        int step = 1;//步长
        while (step < N) {
            int L = 0;//左指针
            while (L < N) {
                int M = 0;//每一组的尾指针
                //当最后一个左组是否长度足够？
                if (N - L >= step) {//当最后一个左组长度足够时
                    M = L + step - 1;
                } else {//当最后一个左组长度不够时
                    M = N - 1;
                }
                if (M == N - 1) {//当尾指针等于数组长度时
                    break;
                }
                int R = 0;//右指针
                //左指针+步长是否大于数组长度？
                if (N - 1 - M >= step) {//足够
                    R = M + step;
                } else {//不足
                    R = N - 1;
                }
                merge(arr, L, M, R);//归并
                //右指针长度是否等于数组长度
                if (R == N - 1) {
                    break;
                } else {//不等于时，新的左指针下标=右指针+1
                    L = R + 1;
                }
            }
            if (step > N / 2) {//长步长大于数组长度的一半时，就不用继续了。ps.N / 2向下取整
                break;
            }
            step *= 2;//步长*2
        }

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
