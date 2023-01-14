package com.algorithm.newStudy.array;

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
            for (int i = 0; i < 31; i++) {
                bytes[i] += ((num >> i) & 1);
            }
        }
        int res = 0;
        for (int i = 0; i < 31; i++) {
            if (bytes[i] / m != 0) {
                res |= (1 << i);//将1或到res中
            }
        }
        return res;
    }
}
