package com.algorithm._8_1Tree._2threadebinarytree;

public class ThreadeBinaryTreeDemo {
    public static void main(String[] args) {
        //测试一把中序线索化二叉树的功能
        HeroNode root = new HeroNode(1, "Tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "marry");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");
        //二叉树，后面我们要递归的创建，仙子啊简单处理手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //测试中序线索化
        ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree();
        threadBinaryTree.setRoot(root);
        threadBinaryTree.threadNodes();

        //测试，找10这个节点，看其前驱或者后驱节点是否变成了3和1
        HeroNode leftNode = node5.getLeft();
        System.out.println("十号节点的前驱节点是" + leftNode);
        System.out.println("十号节点的后继节点是" + node5.getRight());

        //当线索化二叉树后，不能在使用原来的遍历方法了
        //threadBinaryTree.infixOrder();
        System.out.println("使用线索化的方式遍历线索化二叉树");
        threadBinaryTree.threadList();//8.3.10.1.14.6

    }
}


//定义ThreadBinaryTree 实现了线索化功能的二叉树
class ThreadBinaryTree {
    //只需要一个根节点即可
    private HeroNode root;
    //为了实现线索化，需要创建要给指向当前节点的前驱节点的指针
    //在递归进行线索化时，pre总是保留前一个节点
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //重载threadNodes
    public void threadNodes() {
        this.threadeNodes(root);
    }

    //遍历线索化二叉树的方法
    public void threadList() {
        //定义一个变量，存储当前遍历的节点，root开始
        HeroNode node = root;
        while (node != null) {
            //先循环的找到leftType==1的节点，第一个找到的应该是8这个节点
            //后边随着遍历而变化，因为当left==1时，说明该节点是按照线索化
            //处理后的有效节点
            while (node.getLefType() == 0) {
                node = node.getLeft();//就一直找，直到找到node.getLeftType==1，的时候停下
            }
            //找到之后，打印当前节点
            System.out.println(node);
            //如果当前节点的右指针指向的是后继节点，就一直输出
            while (node.getRightType() == 1) {
                //获取到当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }
            //while循环结束，说明就找到不等于1的，替换遍历的节点
            node = node.getRight();
        }
    }

    /**
     * 编写对二叉树进行中序线索化的方法
     *
     * @param node 这个就是当前需要线索化的节点
     */
    public void threadeNodes(HeroNode node) {
        //如果node==null，就不能进行线索化
        if (node == null) {
            return;
        }
        //中序线索化的步骤
        //一、先线索化左子树
        threadeNodes(node.getLeft());

        //二、线索化当前节点

        //处理当前节点的前驱节点
        //以8节点来理解，8节点.left=null，8节点的.leftType=1
        if (node.getLeft() == null) {
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针类型,指向前驱节点
            node.setLefType(1);
        }

        //处理后继节点；(在递归中在下一轮才处理)
        // 后继节点处理需要返回递归上一层，8是上层的左节点。。
        //此时node指向3，而pre指向8
        if (pre != null && pre.getRight() == null) {
            //让前驱节点的右指针指向当前节点
            pre.setRight(node);
            //修改前驱节点的右指针类型
            pre.setRightType(1);
        }
        //！！这句话尤其重要，每处理一个节点后，让当前节点是下一个节点的前驱节点
        pre = node;

        //三、线索化右子树
        threadeNodes(node.getRight());

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

    //说明
    //1.如果leftType==0，表示指向左子树，如果为1则表示指向前驱节点
    //2.如果rightType==0，表示指向右子树，如果为1表示指向后继节点
    private int lefType;
    private int rightType;

    public void setLefType(int lefType) {
        this.lefType = lefType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getLefType() {
        return lefType;
    }

    public int getRightType() {
        return rightType;
    }

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
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //编写，前序遍历的方法
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

    //前序遍历查找的方法

    /**
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
        // 如果左递归找到，节点，则返回
        HeroNode resNode = null;//假定我们找到的节点就是它，因为我们需要判断左递归找到要返回
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

        System.out.println("进入zhong序遍历查找");

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