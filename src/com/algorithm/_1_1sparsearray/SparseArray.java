package com.algorithm._1_1sparsearray;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sun.org.apache.bcel.internal.classfile.Utility.printArray;

/**
 * 稀疏数组
 */
public class SparseArray {

    public static void main(String[] args) throws IOException {

        String fileName = "E:\\Program\\AlgorithmStudy\\src\\com\\algorithm\\_1_1sparsearray\\sparseArray.txt";


        //创建一个原始的二维数组 11*11
        //0表示没有棋子 1表示黑子 2表示白子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出原始的二维数组
        System.out.println("原始的二维数组：");
        /*foreach方式遍历数组
        for(数据类型 变量名:数组名)
        {}
        首先遍历chessArr1[],得到的都是一些地址值，然后再次遍历chessArr1[][]，这才能得到所存储的值
        */
        for (int[] arr : chessArr1) {
            for (int data : arr) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println();

        //将二维数组转稀疏数组
        //1.先遍历二维数组得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("稀疏数组中非零元素的个数：" + sum);

        //2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //遍历二维数组，将非0的值放入稀疏数组
        int count = 0;//计数器用于记录第几个非0数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }

            }
        }
        //输出稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组：");
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d\t", sparseArr[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        //加入IO流
        System.out.println("保存稀疏数组到本地");
        //保存到本地
        SaveToLocal(fileName, sparseArr);
        System.out.println();

        System.out.println("正在读取本地稀疏数组文件");
        int[][] readArray = ReadByLocal(fileName);
        printArray(readArray);
        System.out.println();

        //读取到的稀疏数组
        System.out.println("读取到的稀疏数组：");
        for (int i = 0; i < readArray.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d\t", readArray[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        //将稀疏数组==>恢复成 原始数组
        /*
        1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        2.在读取稀疏数组后几行的数据，并赋值原始数据即可
        */
        int chessArr2[][] = new int[readArray[0][0]][readArray[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[readArray[i][0]][readArray[i][1]] = readArray[i][2];
        }

        //输出恢复后的二维数组
        for (int[] arr : chessArr2) {
            for (int data : arr) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    //将稀疏数组保存到本地
    private static void SaveToLocal(String fileName, int[][] sparseArray) throws IOException {
        //输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName), false));
        StringBuffer sb = new StringBuffer();
        //拼接字符
        for (int[] row : sparseArray) {
            for (int i : row) {
                sb.append(i + "\t");
            }
            sb.append("\r\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    //读取本地稀疏数组文件
    private static int[][] ReadByLocal(String fileName) throws IOException {
        //定义行列
        int row = 0, col = 0;
        List<int[]> readList = new ArrayList<>();
        //文件
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName))));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            //将读取到的String转换为int数组存数在ArrayList中
            int[] array = Arrays.stream(line.split("\\t")).mapToInt(Integer::parseInt).toArray();
            System.out.println("读取到的稀疏数组:" + Arrays.toString(array));
            //用List保存
            readList.add(array);
            //列
            col = array.length;
        }
        //行
        row = readList.size();
        bufferedReader.close();

        // ArrayList内部一维数组转化为二维数组
        int[][] readArray = new int[row][col];
        for (int i = 0; i < readArray.length; i++) {
            readArray[i] = readList.get(i);
        }
        return readArray;
    }

}