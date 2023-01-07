package com.algorithm._2_1singlelinked;

public class SingleLinkedList {
    //先初始化一个头节点,头节点不能动,不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode) {
        //因为head节点不能动,因此我们需要一个辅助变量temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后   1
            if (temp.next == null) {
                break;
            }
            //如果没有找到，将temp后移
            temp = temp.next;
        }
        //当退出循环时，temp就指向了链表的最后
        //将最后的这个节点的next 指向新的节点     2
        temp.next = heroNode;
    }

    // 第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //在内存中将数据排序
    //(如果有这个排名，则添加失败，并给出提示)
    //要将新添加的heroNode存储到temp.next的位置，所以要和原先的temp.next作比较。将heroNode.next指向原先的temp.next.no，再将temp.next指向新的heroNode
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，找到的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;//flag标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {//说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {//位置找到，就在temp的后面
                break;
            } else if (temp.next.no == heroNode.no) {//说明希望添加的heroNode的编号已然存在
                flag = true;
                break;
            }
            temp = temp.next;//后移，遍历当前链表
        }
        //判断flag的值
        if (flag) {//不能添加，说明编号存在
            System.out.println("准备插入的英雄的编号" + heroNode.no + "已经存在了,不能加入");
        } else {
            //插入到链表中，temp的后面（不能反！！！）
            //将heroNode.next指向原先的temp.next
            heroNode.next = temp.next;
            //temp.next指向新的heroNode
            temp.next = heroNode;
        }

    }

    //修改节点的信息，根据no编号来修改，即no编号不能改
    //说明
    //1.根据newHeroNode的no来修改即可
    public void update(HeroNode newHeroNode) {
        //判断是否为空
        if (head.next == null) {//链表的有效节点并不包括头指针，头指针通常用head定义，他只是指向第一个有效结点；无论链表是否为空，头指针都不为空；头指针并不存放有效数据！
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //先定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到节点
        while (true) {
            if (temp == null) {
                break;//已经遍历完链表
            }
            if (temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到编号%d的节点，不能修改\n", newHeroNode.no);
        }
    }

    //删除节点
    //思路
    //1.head不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    //2.说明我们在比较时，是temp.next.no和需要删除的节点的no的比较
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;//标志是否找到待删除节点的
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                //找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;//temp后移，遍历
        }
        //判断flag
        if (flag) {//找到
            //可以删除
            //让当前的下一个节点指向当前的下一个的下一个
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的" + no + "节点不存在");
        }
    }

    //显示链表[遍历]
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将temp后移，一定小心
            temp = temp.next;

        }
    }

}
