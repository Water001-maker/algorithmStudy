package com.algorithm._6Search;

import java.util.Arrays;

public class FibonacciSearch {
    public static int maxSzie = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int index = fibSearch(arr, 1234);
        System.out.println("您要找的数据的下标是：" + index);
    }

    //获得斐波那契数列
    //非递归方式
    public static int[] fib() {
        int[] fib = new int[maxSzie];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < maxSzie; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    public static int fibSearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;//表示斐波那契分割数值的下标
        int mid;
        int fib[] = fib();//获取到斐波那契数列
        //获取到斐波那契额分割数值的下标
        while (arr.length > fib[k] - 1) {
            k++;
        }
        //System.out.println(k);//k=5 表示fib[5]-1=8-1=7  7>6
        //退出循环时说明已经找到斐波那契分割的数值即fib[k]  fib[k]的值表示 要使用此方法所需的 元素的个数
        //因为fib[k]可能大于arr的长度，所以这里需要构建一个新数组补齐所需的元素
        // copyOf(oringinal, int newlength) oringinal:原数组  newlength:复制数组的长度
        int[] temp = Arrays.copyOf(arr, fib[k]);//不足的地方自动填充0
        /*for(int x=0;x<temp.length;x++) {
            System.out.println("temp=" + temp[x]);//[1, 8, 10, 89, 1000, 1234,0,0]
        }*/
        //此方法实际应该在不足的地方填充arr的最后一个数据的值
        for (int i = high + 1; i < fib[k]; i++) {
            temp[i] = arr[high];////[1, 8, 10, 89, 1000, 1234,1234,1234]
        }
        //开始查找（非递归）
        while (low <= high) {
            mid = low + fib[k - 1] - 1;//前半段
            if (value < temp[mid]) {//向数组左边查找
                high = mid - 1;
                //fib[k]=fib[k-1]+fib[k-2] 因为要找的值小于temp[mid] 所以去fib[k-1]这部分继续找
                //所以k-- 即 下次循环mid=low+fib[k-1-1]-1
                k--;
            } else if (value > temp[mid]) {//向数组右边查找
                low = mid + 1;
                //fib[k]=fib[k-1]+fib[k-2] 因为要找的值大于于temp[mid] 所以去fib[k-2]这部分继续找
                //所以k-=2 即 下次循环mid=low+fib[k-2-1]-1
                k -= 2;
            } else {//找到的话需要确定返回的下标
                if (mid <= high) return mid;//在右边
                else return high;//因为temp填充过，所以mid会大于high
            }
        }
        return -1;
    }
}

