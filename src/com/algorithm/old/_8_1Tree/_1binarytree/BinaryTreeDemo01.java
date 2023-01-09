package com.algorithm.old._8_1Tree._1binarytree;

/**
 * 前序、中序、后序遍历
 */
public class BinaryTreeDemo01 {

    public static void main(String[] args) {
        //先需要一个二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        HeroNode root = new HeroNode(1, "老大");
        HeroNode node2 = new HeroNode(2, "老二");
        HeroNode node3 = new HeroNode(3, "老三");
        HeroNode node4 = new HeroNode(4, "老四");
        HeroNode node5 = new HeroNode(5, "老五");//再加一个


        //说明：先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);//root左边的节点挂上了node2，之前是root.left=node2;但是这个方法变成私有的了
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);//
        binaryTree.setRoot(root);

        //遍历
        //测试
        System.out.println("前序遍历");//先输出1宋江，2吴用，3卢俊义，4林冲，正好是顺序
        binaryTree.preOrder();//再加一个5，是12354

        //测试
        System.out.println("中序遍历");
        binaryTree.infixOrder();//2,1,3,4；//再加一个5，是21534

        //后序遍历
        System.out.println("后序遍历");//此时需要注意
        binaryTree.postOrder();//2，4，3，1//再加一个5，是254311

        //查找
        //前序查找遍历
        //前序遍历的次数4
        System.out.println("前序遍历查找的方式~~");
        HeroNode resNode = binaryTree.preOrderSearch(5);
        //System.out.println(resNode);直接输出即可，毕竟都重写了toString，但是老师是按照下面写的
        if (resNode != null) {
            System.out.printf("找到了，信息为id=%d name=%s\n", resNode.getNo(), resNode.getName());
        } else {
            System.out.printf("没有找到id=%d的英雄", 5);
        }

        //中序查找遍历
        //中序遍历的次数3
        System.out.println("中序遍历查找的方式~~");
        HeroNode resNode1 = binaryTree.infixOrderSearch(5);
        if (resNode1 != null) {
            System.out.printf("找到了，信息为id=%d name=%s", resNode1.getNo(), resNode1.getName());
        } else {
            System.out.printf("没有找到id=%d的英雄", 5);
        }

        //后序查找遍历
        //后序遍历的次数3
        System.out.println("后序遍历查找的方式~~");
        HeroNode resNode2 = binaryTree.postOrderSearch(5);
        if (resNode2 != null) {
            System.out.printf("找到了，信息为id=%d name=%s", resNode2.getNo(), resNode2.getName());
        } else {
            System.out.printf("没有找到id=%d的英雄", 5);
        }


        //删除
        //测试，删除节点的操作
        System.out.println("删除前，前序遍历的操作");
        binaryTree.preOrder();
        binaryTree.delNode(5);//1234
        //binaryTree.delNode(3);//12 删除子树，等价与把那棵子树全部干掉
        System.out.println("删除后，前序遍历的操作");
        binaryTree.preOrder();//1234

    }
}

//定义BinaryTree 二叉树
class BinaryTree {
    //只需要一个根节点即可
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历；真正的调用是从根节点来调的，就想前面所讲的哈希表
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();//谁调用指向谁preOrder()指向root
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    //前序查找遍历
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;//如果为空的话直接返回即可
        }
    }

    //中序查找遍历
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    //删除节点的操作
    public void delNode(int no) {
        //首先判断root是否为空
        if (root != null) {
            //如果只有一个root节点，这里需要立即判断root是不是要删除的节点
            if (root.getNo() == no) {
                root = null;//恰好是根节点，直接置空即可
            } else {
                //如果root不是，则就递归删除
                root.delNode(no);
            }
        } else {
            System.out.println("空树，不能删除~~");
        }
    }

}


//先创建HeroNode 节点
class HeroNode {
    private int no;//英雄的编号
    private String name;//英雄的名字
    private HeroNode left;//指向左边的索引，默认null
    private HeroNode right;//指向右边的索引，默认null

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public HeroNode getRight() {
        return right;
    }

    //需要输出当前节点的内容，所以需要重写toString方法
    @Override
    public String toString() {
        return "HeroNode{" + "no=" + no + ", name='" + name + '\'' + '}';
    }

    //前序遍历的方法
    public void preOrder() {
        //先输出当前节点，不用判断是否为空，因为都进来了肯定不为空
        System.out.println(this);//先输出父节点，不能写root，后面无法递归，第一次this=root
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //向左递归结束后，返回到root，递归向右子树进行遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历的方法
    public void infixOrder() {
        //先递归，向左子树中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        //输出当前节点：父节点
        System.out.println(this);
        //递归，向右子树中序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历的方法
    public void postOrder() {
        //先递归，向左子树后序遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        //递归，向右子树后序遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        //输出当前父节点
        System.out.println(this);
    }


    /**
     * 前序遍历查找的方法
     *
     * @param no 英雄的编号（id)
     * @return 找到返回该英雄node，没找到返回null
     */
    public HeroNode preOrderSearch(int no) {
        System.out.println("进入前序遍历查找的方式");
        //比较当前节点是不是
        if (this.no == no) {
            return this;//
        }
        //如果不是，判断左子节点是否为空，不为空就左递归;
        //如果左递归找到，节点，则返回
        HeroNode resNode = null;//返回的值
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {//这个说明左子树我们已经找到了
            return resNode;
        }
        //左递归没有找到的话，需要继续判断
        //判断当前节点的右子节点是否为空，如果不为空，则继续向右递归查找，找到返回，没有返回null
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;//不管找没找到，就可以直接返回
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        //先判断当前节点的左子节点是否为空，如果不为空，则递归中序查找
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {//这个表示左节点找到
            return resNode;
        }
        System.out.println("进入中序遍历查找");
        //如果没有找到，就和当前节点比较，如果是，则返回当前节点
        if (this.no == no) {
            return this;//说明找到，并返回了当前节点
        }
        //如果没有找到，就向右继续递归中序查找
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;//不管是否为空，直接返回即可
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no) {
        //判断当前节点的左子节点是否为空，如果不为空，则递归后序查找
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        //判断
        if (resNode != null) {
            return resNode;//说明找到
        }
        //如果左子树没有找到，则向右子树进行后序遍历
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入后序查找");//查看遍历的次数，得写在比较语句(this.no==no)的前面，不能写在前面
        //如果左右子树都没有找到，就比较当前节点是不是
        if (this.no == no) {
            return this;
        }
        return resNode;
    }


    //递归删除节点
    //规定：1.如果是叶子节点则删除该节点，2如果删除的是非叶子节点，则删除该子树
    public void delNode(int no) {
        //先判断左子节点是否为空，再判断是否是要删除的节点
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        //如果左子节点不是，判断右子节点是否为空或者是否是要删除的节点
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        //如果前两个都没有，则需要先向左递归删除
        if (this.left != null) {
            this.left.delNode(no);
        }
        //左递归没有结束的话，就进行右递归进行删除
        if (this.right != null) {
            this.right.delNode(no);
        }
    }

}