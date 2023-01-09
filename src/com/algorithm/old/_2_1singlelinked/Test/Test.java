package com.algorithm.old._2_1singlelinked.Test;


import com.algorithm.old._2_1singlelinked.HeroNode;
import com.algorithm.old._2_1singlelinked.SingleLinkedList;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {

        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();

        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        HeroNode hero5 = new HeroNode(5, "老五", "智多星");
        HeroNode hero6 = new HeroNode(6, "老六", "豹子头");
        HeroNode hero7 = new HeroNode(7, "老七", "智多星");
        HeroNode hero8 = new HeroNode(8, "老八", "豹子头");
        HeroNode hero9 = new HeroNode(9, "老九", "智多星");

        singleLinkedList1.addByOrder(hero3);
        singleLinkedList1.addByOrder(hero1);
        singleLinkedList1.addByOrder(hero7);
        singleLinkedList1.addByOrder(hero5);
        singleLinkedList1.addByOrder(hero9);

        singleLinkedList2.addByOrder(hero2);
        singleLinkedList2.addByOrder(hero6);
        singleLinkedList2.addByOrder(hero8);
        singleLinkedList2.addByOrder(hero4);

        System.out.println("链表1：");
        singleLinkedList1.list();

        System.out.println("链表2：");
        singleLinkedList2.list();

        HeroNode merge = merge(singleLinkedList1.getHead(), singleLinkedList2.getHead());

        System.out.println("合并后：");
        while (merge !=null){
            System.out.println(merge);
            merge = merge.next;
        }

        /*
        System.out.println("有效节点的个数：" + getLength(singleLinkedList.getHead()));

        System.out.println("倒数第1个节点：" + findLastIndexNode(singleLinkedList.getHead(), 1));

        System.out.println("原本的链表");
        singleLinkedList.list();

        System.out.println("反转的链表");
        reversetList(singleLinkedList.getHead());
        singleLinkedList.list();

        System.out.println("反向输出");
        reversePrint(singleLinkedList.getHead());
        */


    }

    //方法：获取到单链表的节点的个数(如果是带头结点的链表，需求不统计头节点)

    /**
     * 求单链表中有效节点的个数
     *
     * @param head 链表的头结点
     * @return 返回的就是有效结点的个数
     */
    public static int getLength(HeroNode head) {
        int length = 0;

        if (head.next == null) { //空链表
            return 0;
        }

        //定义一个辅助的变量, 这里我们没有统计头节点
        HeroNode heroNode = head.next;
        while (heroNode != null) {
            length++;
            heroNode = heroNode.next; //遍历
        }
        return length;
    }

    /**
     * 查找单链表中的倒数第k个结点
     * 思路
     * 1. 编写一个方法，接收 head 节点，同时接收一个 index
     * 2. index 表示是倒数第 index 个节点
     * 3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
     * 4. 得到 size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
     * 5. 如果找到了，则返回该节点，否则返回 null
     *
     * @param head
     * @param index
     * @return
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //第一个遍历得到链表的长度(节点个数)
        int size = getLength(head);

        //判断如果链表为空，返回 null
        if (head.next == null) {
            return null;
        }

        //index 的校验，确定index符合范围
        if (index < 0 || index > size) {
            return null;
        }

        //第二次遍历 size-index 位置，就是我们倒数的第 K 个节点
        //定义一个辅助变量
        HeroNode heroNode = head.next;
        for (int i = 0; i < size - index; i++) {
            heroNode = heroNode.next;
        }
        //返回
        return heroNode;
    }

    //将单链表反转
    public static void reversetList(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        HeroNode cur = head.next;//用于遍历原先链表的
        HeroNode next = null;//指向当前节点的下一个节点。
        HeroNode reverseHead = new HeroNode(0, "", "");//创建的新链表

        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表 reverseHead 的最前端
        //动脑筋
        while (cur != null) {
            next = cur.next;//暂时保存cur当前节点的下一个节点，因为要留给下一次循环使用
            cur.next = reverseHead.next;//将当前结点的下一个节点指向新链表的最前端，即新链表的头结点的下一个节点
            reverseHead.next = cur;//再将新链表头结点的下一个节点指向cur，也就是当前链表
            cur = next;//cur后移，下一个循环使用
        }
        //将 head.next 指向 reverseHead.next , 实现单链表的反转
        head.next = reverseHead.next;
    }

    //方式2：
    //可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;//空链表，不能打印
        }
        //创建要给一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        //将链表的所有节点压入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next; //cur后移，这样就可以压入下一个节点
        }
        //将栈中的节点进行打印,pop 出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop()); //stack的特点是先进后出
        }
    }

    public static HeroNode merge(HeroNode head1, HeroNode head2) {
        //创建的新链表
        HeroNode reverseHead = new HeroNode(0, "", "");

        //定义一个辅助的指针，帮助我们遍历原来的链表 reverseHead
        HeroNode cur = reverseHead;
        //定义一个辅助的指针，帮助我们遍历原来的链表1
        HeroNode l1 = head1.next;
        //定义一个辅助的指针，帮助我们遍历原来的链表2
        HeroNode l2 = head2.next;

        //通过循环，比较两个链表值的大小，将其中较小的节点添加到新链表的结尾
        while (l1 != null && l2 != null) {

            if (l2.no > l1.no) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }

            if (l1.no > l2.no) {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }

        //当其中一个遍历完了之后，就将另一个剩余的节点全部添加到新链表的结尾
        if (l1 == null) {
            cur.next = l2;
        }
        if (l2 == null) {
            cur.next = l1;
        }
        return reverseHead.next;
    }

}



