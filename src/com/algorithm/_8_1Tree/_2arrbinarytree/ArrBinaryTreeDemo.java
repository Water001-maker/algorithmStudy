package com.algorithm._8_1Tree._2arrbinarytree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        //创建一个ArrBinaryTree对象
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        //arrBinaryTree.preOrder(0);//按照根节点，应该先传0进去即可，但是这样写比较麻烦，一般使用重载的方法

        //前序操作
        System.out.println("前序遍历的操作");
        arrBinaryTree.preOrder();
        //中序操作
        System.out.println("中序遍历的操作");
        arrBinaryTree.midOrder();
        //后序操作
        System.out.println("后序遍历的操作");
        arrBinaryTree.postOrder();

    }
}

//编写一个ArrayBinaryTree，实现顺序存储二叉树的遍历
class ArrBinaryTree {
    private int[] arr;//存储数据节点的数组（就是存储二叉树节点的数组）

    //需要一个构造器，待会把数组传给我即可
    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }


    //重载前序遍历的方法
    public void preOrder() {
        this.preOrder(0);
    }

    //编写一个方法完成顺序存储二叉树前序遍历操作

    /**
     * @param index 这个表示数组的下标，类似刚才分析的n
     */
    public void preOrder(int index) {
        //如果数组为空，或者arr.length=0
        if (arr == null || arr.length == 0) {//arr=null，表示arr不指向任何对象，length=0表示指针指向一个长度为0的对象，判断null需要在前防止空指针异常
            System.out.println("数组为空，不能按照二叉树的前序进行遍历");
        }
        //进行前序遍历
        //输出当前的这个元素
        //中间
        System.out.println(arr[index]);//0
        //先向左递归遍历
        if ((index * 2 + 1) < arr.length) {//加上这个判断是为了防止角标越界
            preOrder(2 * index + 1);//1
        }
        //然后向右递归
        if ((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);//2
        }
    }


    //中序方法的重载操作
    public void midOrder() {
        midOrder(0);
    }

    //完成顺序存储二叉树的中序操作
    public void midOrder(int index) {
        //先判断数组是否为空或者长度为0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能进行二叉树中序遍历操作");
        }
        //先向左递归
        if ((2 * index + 1) < arr.length) {//1
            midOrder(2 * index + 1);
        }
        //中间
        System.out.println(arr[index]);//0
        //向右递归
        if ((2 * index + 2) < arr.length) {//2
            midOrder(2 * index + 2);
        }
    }

    //后序方法的重载操作
    public void postOrder() {
        postOrder(0);
    }

    //完成顺序存储二叉树的后序操作
    public void postOrder(int index) {
        //先判断数组是否为空或者长度为0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能进行二叉树后序遍历操作");
        }
        //先向左递归
        if ((2 * index + 1) < arr.length) {
            postOrder(2 * index + 1);//1
        }
        //向右递归
        if ((2 * index + 2) < arr.length) {
            postOrder(2 * index + 2);//2
        }
        //中间
        System.out.println(arr[index]);//0
    }
}