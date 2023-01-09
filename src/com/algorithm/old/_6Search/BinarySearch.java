package com.algorithm.old._6Search;

import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1234};
        int index = binarySearch(arr, 0, arr.length - 1, 1000);
        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("找到数字的第一个位置是" + index);
        }
    }

    //单个
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (left > right) { //在端点的时候就是left==right
            return -1;
        }

        if (findVal > midVal) { //向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { //向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

    //多个相同值
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        if (left > right) { //递归结束条件
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) { //向右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { //向左递归
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            //有相同值
            /*
        	1、当查找到mid索引值后 向左右两边扫描看是否有多个相同查找值
            2、向mid索引值的左边扫描，若存在满足findVal的值则将其加入集合中
            3、向mid索引值的右边扫描，若存在满足findVal的值则将其加入集合中
            4、不要忘了把mid索引处的数据也加入集合中  最后返回集合即可*/
            ArrayList<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                } else {
                    list.add(temp);
                    temp--;
                }
            }
            list.add(mid);
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                } else {
                    list.add(temp);
                    temp++;
                }
            }
            return list;
        }
    }
}