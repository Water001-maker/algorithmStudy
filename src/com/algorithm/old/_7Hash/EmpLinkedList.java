package com.algorithm.old._7Hash;

/**
 * 创建EmpLinkedList，表示链表
 */
public class EmpLinkedList {
    public Emp head;//头结点，默认为null

    //有序添加
    public void add(Emp emp) {
        if (head == null) {//如果头结点为空，直接加入
            head = emp;
            return;
        }
        //如果不是第一个就在链表中添加
        Emp curEmp = head;//辅助指针
        if (curEmp.id > emp.id) {//输入的值小于现在的头结点，则和头结点互换
            emp.next = head;
            head = emp;
            return;
        }
        while (true) {
            if (curEmp.next == null) {//到达链表末尾
                break;
            }
            if (curEmp.next.id > emp.id) {//下一个比输入的大
                break;
            }
            curEmp = curEmp.next;//后移
        }
        //
        emp.next = curEmp.next;
        curEmp.next = emp;
    }

    //遍历全部
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + no + "条链表为空");
            return;
        }
        System.out.println("第" + no + "条链表:");
        Emp curEmp = head;//辅助指针
        while (true) {
            System.out.println(curEmp);
            if (curEmp.next == null) {//说明指到了最后
                break;
            }
            curEmp = curEmp.next;
        }
    }

    //查询
    public Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {//找到
                break;
            }
            if (curEmp.next == null) {//到最后都没找到，返回null
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;//后移
        }
        return curEmp;
    }

    //删除
    public boolean deleteById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return false;
        }
        if (head.id == id) {//如果删除的为头结点
            head = head.next;
            return true;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {//没找到找到
                break;
            }
            if (curEmp.next.id == id) {//找到了
                if (curEmp.next.next == null) {//如果需要删除的是当前链表的尾节点
                    curEmp.next = null;
                } else {//如果是链表中间
                    curEmp.next = curEmp.next.next;
                }
                break;
            }
            curEmp = curEmp.next;//后移
        }
        return false;
    }

}
