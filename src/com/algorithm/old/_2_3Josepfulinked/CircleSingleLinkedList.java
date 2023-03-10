package com.algorithm.old._2_3Josepfulinked;

//
public class CircleSingleLinkedList {

    //创建一个first节点，当前没有编号
    private Boy first = null;

    //添加小孩节点，构建一个环形链表
    public void addBoy(int nums) {
        //nums做一个数据校验
        if (nums < 1) {
            System.out.println("num的值必须大于1");
            return;
        }

        Boy curBoy = null;//辅助指针，帮助构建环形链表
        //使用for来创建我们的环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号，创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩（自己指向自己，有些特殊）
            if (i == 1) {
                first = boy;
                first.setNext(first);//构成环
                curBoy = first;//让curBoy指向第一个小孩
            } else {
                curBoy.setNext(boy);//最后一个跟新节点相连
                boy.setNext(first);//跟头相连
                curBoy = boy;//curBoy后移
            }
        }
    }

    // 根据用户的输入，计算出小孩出圈的顺序

    /**
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        // 先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }

        // 创建要给辅助指针,帮助完成小孩出圈
        Boy helper = first;
        // 需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点
        while (true) {
            if (helper.getNext() == first) { // 说明 helper 指向最后小孩节点
                break;
            }
            helper = helper.getNext();
        }

        //小孩报数前，先让 first 和 helper 移动 k - 1 次
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //当小孩报数时，让 first 和 helper 指针同时移动 m - 1 次, 然后出圈
        //这里是一个循环操作，知道圈中只有一个节点
        while (true) {
            if (helper == first) { //说明圈中只有一个节点
                break;
            }

            //让 first 和 helper 指针同时 的移动 countNum - 1
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            //这时 first 指向的节点，就是要出圈的小孩节点
            System.out.println("小孩" + first.getNo() + "出圈");

            //这时将 first 指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first); //
        }
        System.out.println("最后留在圈中的小孩编号" + first.getNo());
    }

    //遍历当前的环形链表
    public void showBoy() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("没有任何小孩");
            return;
        }
        //因为first不能动，因此我们仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.println("小孩的编号：" + curBoy.getNo());
            if (curBoy.getNext() == first) {//说明已经遍历完毕
                break;
            }
            curBoy = curBoy.getNext();// curBoy后移
        }
    }

}
