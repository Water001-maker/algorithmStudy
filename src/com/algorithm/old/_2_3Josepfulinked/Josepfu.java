package com.algorithm.old._2_3Josepfulinked;

public class Josepfu {
    public static void main(String[] args) {
        //测试一把构建环形链表，和遍历是否成功
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);//加入5个小孩节点
        circleSingleLinkedList.showBoy();
        //测试一把小孩出圈是否正确
        circleSingleLinkedList.countBoy(1, 2, 5); // 2->4->1->5->3
    }
}
