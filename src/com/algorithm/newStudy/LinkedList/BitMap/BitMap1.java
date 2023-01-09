package com.algorithm.newStudy.LinkedList.BitMap;

import java.util.HashSet;

/**
 * @author xuemiao
 * @date 2023/1/9 18:40
 * <p>
 * 位图
 * 功能：收集数字，并且判断存在不存在
 * 好处：极大的压缩空间
 * 位图的实现
 */
public class BitMap1 {

    public static class BitMap {

        private long[] bits;

        public BitMap(int max) {
            //(max + 64) >> 6 => (max+64)/64
            bits = new long[(max + 64) >> 6];
        }

        public void add(int num) {
            //num/64
            //num & 63 => num % 64
            // 1 << (num & 63) 1 向左移动(num & 63)位
            // |= 对应的位置标 1
            bits[num >> 6] |= (1L << (num & 63));
        }

        public void delete(int num) {
            // &= 对应的位置标 0
            bits[num >> 6] &= ~(1L << (num & 63));
        }

        public boolean contains(int num) {
            //找到当前数据，如果与之后为0，则存在
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }

        //1只有32位，1L有64位

    }

    public static void main(String[] args) {
        System.out.println("测试开始！");
        int max = 10000;
        BitMap bitMap = new BitMap(max);
        HashSet<Integer> set = new HashSet<>();
        int testTime = 10000000;
        for (int i = 0; i < testTime; i++) {
            int num = (int) (Math.random() * (max + 1));
            double decide = Math.random();
            if (decide < 0.333) {
                bitMap.add(num);
                set.add(num);
            } else if (decide < 0.666) {
                bitMap.delete(num);
                set.remove(num);
            } else {
                if (bitMap.contains(num) != set.contains(num)) {
                    System.out.println("Oops!");
                    break;
                }
            }
        }
        for (int num = 0; num <= max; num++) {
            if (bitMap.contains(num) != set.contains(num)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }

}