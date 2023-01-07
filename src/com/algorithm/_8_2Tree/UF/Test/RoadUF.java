package com.algorithm._8_2Tree.UF.Test;

import com.algorithm._8_2Tree.UF.UFTree_Weighted;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RoadUF {

    public static void main(String[] args) throws Exception {

        //读取文件
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(RoadUF.class.getClassLoader().getResourceAsStream("com/algorithm/_8_2Tree/UF/Test/Test.txt")));

        //读取到第一行数据20
        int totalNumber = Integer.parseInt(bufferedReader.readLine());

        //构建一个并查集
        UFTree_Weighted uf = new UFTree_Weighted(totalNumber);

        //读取第二行数据
        int roadNumber = Integer.parseInt(bufferedReader.readLine());

        //循环读取7条数据
        for (int i = 0; i < roadNumber; i++) {
            //逐行读取数据
            String line = bufferedReader.readLine();
            String[] str = line.split(" ");
            int p = Integer.parseInt(str[0]);
            int q = Integer.parseInt(str[1]);

            uf.union(p, q);
        }

        int roads = uf.getCount() - 1;
        System.out.println("还需要修建"+roads+"条道路");
    }

}
