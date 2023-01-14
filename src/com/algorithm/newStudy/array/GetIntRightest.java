package com.algorithm.newStudy.array;

/**
 * @author xuemiao
 * @date 2023/1/14 16:00
 * 获取一个int类型最右侧的1
 */
public class GetIntRightest {

    public static int getIntRightest(int num) {
        int right = num ^ (~num + 1);//011001 ^ 100111
        return right;
    }
}
