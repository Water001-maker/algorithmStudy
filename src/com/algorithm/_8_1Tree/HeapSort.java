package com.algorithm._8_1Tree;

import java.text.SimpleDateFormat;
import java.util.Date;

//堆排序
public class HeapSort {
    public static void main(String[] args) {
        //对该数组进行升序排列
        //int[] arr = {4, 6, 8, 5, 9,0,-1,22,-88};
        //heapSort(arr);
        //测试堆排序的速度   随机给80000个数  ---
        int[] arr = new int[800000];
        for (int i = 0; i < 800000; i++) {
            arr[i] = (int) (Math.random() * 800000);//[0,800000)
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是：" + date1Str);
        heapSort(arr);
        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是：" + date2Str);
    }

    //编写方法实现堆排序
    public static void heapSort(int[] arr) {
        int temp = 0;
        //分步完成
        //1)将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        // System.out.println("调整后的堆为：" + Arrays.toString(arr));
        //2)将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
        //3)重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];//调整好的堆 最大值肯定在数组的第一位
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
        // System.out.println("堆排序的结果：" + Arrays.toString(arr));
    }

    /**
     * 将一个数组（二叉树）调整成一个大顶堆
     * 功能：将以i为父节点的树 调整成大顶堆
     *
     * @param arr    待调整的数组
     * @param i      i表示非叶子节点在数组中的索引
     * @param length 对length个数据进行调整  没调整一次length-1
     */
    public static void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];//保存当前元素的值
        //调整
        // k = i * 2 + 1是i节点的左子结点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {//k + 1 < length为了提高效率  arr[k] < arr[k + 1]左子节点的值小于右子节点的值
                k++;//k指向右子结点
            }
            if (arr[k] > temp) {//子结点大于当前值
                arr[i] = arr[k]; //把两者中较大的值赋给当前节点arr[i]
                i = k;//i指向k继续循环比较
            } else {
                break;
            }
        }//for循环结束后 以i为父节点的树的最大值已经放在了最顶部
        arr[i] = temp;//将temp的值放在调整后的位置
    }

}