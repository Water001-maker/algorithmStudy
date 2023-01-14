package com.algorithm.newStudy.array;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author xuemiao
 * @date 2023/1/14 15:43
 * 数组中只有一个基数词的数，其余的都是偶数次，找到打印他
 */
public class OddTimesNum {

    /**
     * 数组中只有一个基数词的数，其余的都是偶数次，找到打印他
     *
     * @param arr
     * @return
     */
    public static int printOddTimesNum(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num ^= arr[i];
        }
        return num;
    }

    /**
     * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数
     *
     * @param arr
     * @return
     */
    public static int[] printTwoOddTimesNum(int[] arr) {
        int num1 = 0;
        for (int i = 0; i < arr.length; i++) {//第一次异或得到两个数组异或
            num1 ^= arr[i];
        }
        //num1  = 0110101000011100010
        //right = 0000000000000000010
        int right = num1 ^ (~num1 + 1);//取到两数异或后最右侧的1，就可以确认这两个数的不同之处

        int num2 = 0;
        for (int i = 0; i < arr.length; i++) {
            //arr[i]  = 0111010011100010010
            //right   = 0000000000000000010
            if ((arr[i] & right) != 0) {//将最右1与所有的数组元素，就可以获取到两数中的一个
                num2 ^= arr[i];
            }
        }
        num1 = num1 ^ num2;//再异或一次，就可以获取到另一个数
        int[] res = new int[]{num1, num2};
        return res;
    }

    /**
     * 一个数组中只有一种数出现K次，其他数都出现M次，M>1,K<M，找到出现了K次的数
     * 将一个数的所有的二进制码相加，并将该信息存储到一个int数组中，当数组中的元素大小不为m的倍数时，说明出现了k次数的二进制该位置一定是1
     * 假设k=2,m=3
     * bytes=[3,4,6,4,9] 中去除掉出现了3次的 =》[0,1,0,1,0]=10
     *
     * @param arr
     * @return
     */
    public static int printKTimesNum(int[] arr, int k, int m) {
        int[] bytes = new int[32];

        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                bytes[i] += ((num >> i) & 1);
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (bytes[i] % m == 0) {
                continue;
            }
            if (bytes[i] % m == k) {
                res |= (1 << i);//将1或到res中
            } else {
                return -1;
            }
        }
        if (res == 0) {//边界处理
            int count = 0;
            for (int num : arr) {
                if (num == 0) {
                    count++;
                }
            }
            if (count != k) {
                return -1;
            }
        }
        return res;
    }

    //对数器——用另一种方式实现，并确认

    //另一种实现：请保证arr中，只有一种数出现了K次，其他数都出现了M次
    public static int test(int[] arr, int k, int m) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : map.keySet()) {
            if (map.get(num) == k) {
                return num;
            }
        }
        return -1;
    }

    public static void mapCreater(HashMap<Integer, Integer> map) {
        int value = 1;
        for (int i = 0; i < 32; i++) {
            map.put(value, i);
            value <<= 1;
        }
    }

    /**
     * 对数器
     *
     * @param maxKinds 几个数字
     * @param range    值的范围
     * @param k        k次
     * @param m        m次
     * @return
     */
    public static int[] randomArray(int maxKinds, int range, int k, int m) {
        int ktimeNum = randomNumber(range);
        // 真命天子出现的次数
        int times = Math.random() < 0.5 ? k : ((int) (Math.random() * (m - 1)) + 1);
        int numKinds = (int) (Math.random() * maxKinds) + 2;
        // k * 1 + (numKinds - 1) * m
        int[] arr = new int[times + (numKinds - 1) * m];
        int index = 0;
        for (; index < times; index++) {
            arr[index] = ktimeNum;//存k个
        }
        numKinds--;
        HashSet<Integer> set = new HashSet<>();
        set.add(ktimeNum);
        while (numKinds != 0) {
            int curNum = 0;
            do {
                curNum = randomNumber(range);
            } while (set.contains(curNum));
            set.add(curNum);
            numKinds--;
            for (int i = 0; i < m; i++) {
                arr[index++] = curNum;//存m个
            }
        }
        // arr 填好了，但是太有序，所以打乱
        for (int i = 0; i < arr.length; i++) {
            // i 位置的数，我想随机和j位置的数做交换
            int j = (int) (Math.random() * arr.length);// 0 ~ N-1
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }


    /**
     * @param range [-range, +range]取值范围
     * @return
     */
    public static int randomNumber(int range) {
        return (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));
    }

    public static void main(String[] args) {
        int kinds = 5;//几个数字
        int range = 30;//值的范围-30-30
        int testTime = 100000;//次数
        int max = 9;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int a = (int) (Math.random() * max) + 1; // a 1 ~ 9
            int b = (int) (Math.random() * max) + 1; // b 1 ~ 9
            // k < m
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            if (k == m) {
                m++;
            }
            int[] arr = randomArray(kinds, range, k, m);
            int ans1 = printKTimesNum(arr, k, m);
            int ans2 = test(arr, k, m);
            if (ans1 != ans2) {
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println("出错了！");
            }
        }
        System.out.println("测试结束");

    }


}
