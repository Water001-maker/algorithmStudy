package com.algorithm._5Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Sort {

    public static void main(String[] args) {

    }


    //冒泡排序      时间复杂度为O(n^2)
    public static void bubbleSort(int[] arr) {
        int temp = 0;//临时变量
        boolean flag = false;//标识变量 表示没发生交换
        for (int i = 0; i < arr.length - 1; i++) {//i表示当前是第i+1趟排序
            //第i+1趟排序就是把第i+1大的数放在倒数第i+1的位置
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;//在一趟排序中一次交换也没发生 则说明数组已经有序 break即可
            } else {
                flag = false;//重置flag 进行下一次标识
            }
        }
    }

    //选择排序      时间复杂度为O(n^2)
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;//第一轮默认最小值下标是0
            int min = arr[i];//第一轮默认最小值为第一个数
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {       //如果按从大到小排序则改成min < arr[j]即可
                    min = arr[j];//重置最小值
                    minIndex = j;//重置最小值下标
                }
            }
            //交换  优化：如果最小值没变化就不必交换
            if (minIndex != i) {
                arr[minIndex] = arr[i]; //arr[0]=101->arr[3]=101
                arr[i] = min;//arr[0]=101->arr[0]=1
            }
        }
    }

    //插入排序
    public static void insertSort(int[] arr) {
        int insertVal = 0;//待插入的数
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];//待插入的数
            insertIndex = i - 1;//带插入位置的索引 插入到前一位 所以-1
            //说明：1、insertIndex >= 0 保证在给insertIndex找插入位置时不越界
            //     2、insertVal < arr[insertIndex] 说明还没找到插入位置
            //     3、需要将arr[insertIndex]后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }//退出循环时 表示已经找到要插入的位置
            if (insertIndex + 1 != i) {//优化：如果找的的要插入位置就是其本身所在位置 则无需再赋值
                arr[insertIndex + 1] = insertVal;
            }

            // System.out.println("第" + i + "轮插入排序后：" + Arrays.toString(arr));
        }
    }

    //希尔排序-----交换法
    public static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        //增量gap  逐渐缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //遍历各组中所有的元素，共gap组，每一组有2^n/2^n+1个元素.步长为gap
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    //a[j]表示要和a[i]比较的那个数字，例如：10个数字时。i=5,j=0,下面就是a[0]和a[5]比较
                    //如果当前元素大于加上步长后的那个元素交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            //      System.out.println("第" + (++count) + "轮希尔排序的后：" + Arrays.toString(arr));
        }
    }

    //希尔排序-----移位法（对交换法进行优化  速度快了）
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素开始 逐个对其所在组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                //直接插入排序
                int j = i;//保存待插入位置的下标，类似insertIndex
                int temp = arr[j];//用一个临时变量，保存要插入的数据，类似insertVal
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //退出while循环后就表示找到了插入的位置
                    arr[j] = temp;
                }
            }
        }
    }

    //快速排序
    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            //将数组中的第0个数字 设置为基准数
            int pivot = arr[start];
            //记录需要排序的下标
            int left = start;
            int right = end;
            while (left < right) {
                //右边的数比基准数大 则向左移动right指针
                while (left < right && arr[right] >= pivot) {
                    right--;
                }//退出此while循环说明当前arr[right]<pivot
                arr[left] = arr[right];//用right位的数覆盖left位的数
                //左边的数比基准数小 则向右移动low指针
                while (left < right && arr[left] <= pivot) {
                    left++;
                }//退出此while循环说明当前arr[left]>pivot
                arr[right] = arr[left];//用left位的数覆盖right位的数
            }
            //left和right指针相遇时 将基准数赋给此下标处
            arr[left] = pivot;
            //System.out.println("第一次快速排序后的数组为：" + Arrays.toString(arr));
            //递归
            //处理所有比基准数小的数字
            quickSort(arr, start, left);
            //处理所有比基准数大的数字
            quickSort(arr, left + 1, end);//因为left是基准数，所以需要从+1项开始递归
        }
    }

    public static void quickSort2(int[] arr, int left, int right) {
        int l = left;//左下标
        int r = right;//右下标
        int pivot = arr[(left + right) / 2];//中缀
        int temp = 0;//用于交换的临时变量
        //while循环的目的是让比prvot值小的放到左边，比prvot值大的放到右边
        while (l < r) {
            //l和r交替移动

            //在pivot的左边一直找，找到大于等于pivot的值，才退出（左边的数字要确保小于pivot）
            while (arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找，找到小于等于pivot的值，才退出（右边的数字要确保大于pivot）
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l >= r，说明pivot左右两边的值已经被划分开
            //左边的都是小于pivot的值，右边的都是大于pivot的值
            if (l >= r) {
                break;
            }
            //在满足l >= r之前，就继续进行左右交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //当左右两边中，任意一边有值等于pivot时，确保另一边继续进行，直到循环结束
            //如果交换完后，发现arr[l] == pivot，就对r进行--操作（前移一步）
            if (arr[l] == pivot) {
                r -= 1;
            }

            //如果交换完后，发现arr[r] == pivot，就对l进行++操作（后移一步）
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        //如果l==r，必须l++，r--，否则会栈溢出（当l==r时，相当于两个数都指向pivot，所以一直在原值交换）
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r) {
            quickSort2(arr, left, r);
        }
        //向右递归
        if (l > right) {
            quickSort2(arr, l, right);
        }
    }


    //归并排序
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //向左递归分解
            mergeSort(arr, 0, mid, temp);
            //向右递归分解
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, right, mid, temp);
        }
    }

    /**
     * 合并
     *
     * @param arr   需要排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param right 右边有序序列的初始索引
     * @param mid   中间索引
     * @param temp  做中转的数组
     * @return void
     */
    public static void merge(int[] arr, int left, int right, int mid, int[] temp) {
        //
        int i = left;//初始化i，左边有序序列的初始索引
        int j = mid + 1;//初始化k，右边有序序列的初始索引
        int t = 0;//指向temp数组的当前索引
        //1、先把左右两边数组按照规则填充到temp数组
        // 直到左右两边的有序序列有一边处理完毕
        while (i <= mid && j <= right) {
            //若左边序列的当前元素<=右边序列的当前元素
            if (arr[i] <= arr[j]) {//将左边的填充到temp中
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {//将右边的填充到temp中
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }//两种情况退出当前while循环
        //2、把有剩余元素的一边的数据依次全部填充到temp
        while (i <= mid) {//左边的有序序列还有剩余的元素，就全部填充到temp中
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right) {//右边的有序序列还有剩余的元素，就全部填充到temp中
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        //3、将temp数组的元素拷贝到arr
        //注意：并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {//根据合并的次数，每一次的都是不一样的。
            //第一轮 0,1  2,3  4,5 6，7 第二轮 0,3  4,7  第三轮  0,7
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }


    //基数排序
    //最典型的空间换时间的算法
    public static void radixSort(int[] arr) {

        //得到数组中的最大数的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        //定义一个二维数组 表示10个桶 每个桶又是一个一维数组
        //说明：二维数组包含十个一位数组 为了防止放入数据时桶大小不够 所以每个桶的大小设为arr.length
        int[][] bucket = new int[10][arr.length];
        //记录每个桶中的数据个数 如：bucketElementCounts[0] 表示bucket[0]这个桶中存放的数据个数
        int[] bucketElementCounts = new int[10];
        //针对每个元素 对应位 进行处理
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;//取个位
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;//放入个位对应的桶中
            }
            int index = 0;
            //遍历每一个桶 依次取出数据 放入原来数组中
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] != 0) {
                    //有数据 就循环该桶 即第k个桶 即第k个一维数组
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出数据 放入原来数组
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                bucketElementCounts[k] = 0;//桶要清空
            }
            System.out.println("第" + (i + 1) + "轮排序后的数组：" + Arrays.toString(arr));
        }
    }


    //堆排序
    //编写方法实现堆排序
    public static void heapSort(int[] arr) {
        int temp = 0;
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
    //将一个数组（二叉树）调整成一个大顶堆

    /**
     * 功能：将以i为父节点的树 调整成大顶堆
     *
     * @param arr    待调整的数组
     * @param i      i表示非叶子节点在数组中的索引
     * @param length 对length个数据进行调整  没调整一次length-1
     */
    public static void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];//保存当前元素的值
        //调整
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {//左子节点的值小于右子节点的值
                k++;
            }
            if (arr[k] > temp) {
                //把两者中较大的值赋给当前节点arr[i]
                arr[i] = arr[k];
                i = k;//i指向k继续循环比较
            } else {
                break;
            }
        }//for循环结束后 以i为父节点的树的最大值已经放在了最顶部
        arr[i] = temp;//将temp的值放在调整后的位置
    }


}