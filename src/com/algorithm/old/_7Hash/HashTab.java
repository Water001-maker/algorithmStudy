package com.algorithm.old._7Hash;

/**
 * 创建HashTab，管理多条链表
 */
public class HashTab {
    private EmpLinkedList[] empLinkedList;
    private int size;//表示有多少条链表

    //构造器。创建size条链表
    public HashTab(int size) {
        this.size = size;
        //初始化empLinkedList
        this.empLinkedList = new EmpLinkedList[size];
        //要初始化hashTab中的每一个链表
        for (int i = 0; i < size; i++) {
            empLinkedList[i] = new EmpLinkedList();
        }
    }

    //编写散列函数，使用一个简单的取模法
    public int hashFun(int id) {
        return id % size;
    }

    //增加
    public void add(Emp emp) {
        //根据员工id，得到该员工应该添加到哪条链表
        int empLinkedListNo = hashFun(emp.id);
        //将emp添加到对应的链表中
        empLinkedList[empLinkedListNo].add(emp);
    }

    //遍历所有
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedList[i].list(i);
        }
    }

    //查询
    public void findEmpById(int id) {
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedList[empLinkedListNo].findEmpById(id);
        if (emp == null) {
            System.out.println("未找到");
        } else {
            System.out.println("第" + empLinkedListNo + "条链表中，id为" + emp.id + "雇员的信息" + emp);
        }
    }

    //删除
    public void deleteEmpById(int id){
        int empLinkedListNo = hashFun(id);
        boolean flag = empLinkedList[empLinkedListNo].deleteById(id);
        if (!flag) {
            System.out.println("未找到");
        } else {
            System.out.println("第" + empLinkedListNo + "条链表中的雇员的信息已删除");
        }
    }

}
