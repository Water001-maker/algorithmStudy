package com.algorithm._7Hash;

import java.util.Scanner;

/**
 * 方法类
 */
public class HashTableDemo {
    public static void main(String[] args) {

        HashTab hashTable = new HashTab(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("del: 删除雇员");
            System.out.println("exit: 退出系统");
            System.out.println("请输入相关指令：");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.print("输入id：");
                    int id = scanner.nextInt();
                    System.out.print("输入姓名：");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.print("输入员工id：");
                    int no = scanner.nextInt();
                    hashTable.findEmpById(no);
                    break;
                case "del":
                    System.out.print("输入员工id：");
                    int no1 = scanner.nextInt();
                    hashTable.deleteEmpById(no1);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }

    }
}