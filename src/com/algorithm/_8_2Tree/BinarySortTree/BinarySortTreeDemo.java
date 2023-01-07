package com.algorithm._8_2Tree.BinarySortTree;

//二叉排序树
public class BinarySortTreeDemo {

    public static void main(String[] args) {

        int arr[] = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }

        //中序输出
        binarySortTree.infisOrder();


        //测试删除叶子节点
        binarySortTree.delNode(2);
        binarySortTree.delNode(5);
        binarySortTree.delNode(9);
        binarySortTree.delNode(10);
        System.out.println("测试删除节点后");
        binarySortTree.infisOrder();
    }

}

//二叉排序树
class BinarySortTree {

    private Node root;//根节点

    //查找想要删除的结点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找要结点的父节点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 功能：返回以node为根节点的二叉排序树的最小节点的值 并删除以node为根节点的二叉排序树的最小节点
     *
     * @param node 传入的当做二叉树根节点的节点
     * @return 返回以node为根节点的二叉排序树的最小节点的值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环的查找左节点 直到找到最小值
        while (target.left != null) {
            target = target.left;
        }//退出循环时说明找到了 target指向的就是最小值
        //删除该最小值节点
        delNode(target.value);
        return target.value;//将最小结点的值返回
    }

    /**
     * 功能：返回以node为根节点的二叉排序树的最大节点的值 并删除以node为根节点的二叉排序树的最大节点
     *
     * @param node 传入的当做二叉树根节点的节点
     * @return 返回以node为根节点的二叉排序树的最大节点的值
     */
    public int delLeftTreeMax(Node node) {
        Node target = node;
        //循环的查找右节点 直到找到最大值
        while (target.right != null) {
            target = target.right;
        }//退出循环时说明找到了 target指向的就是最大值节点
        //删除该最大值节点
        delNode(target.value);
        return target.value;//将最大结点的值返回
    }

    //删除节点的方法
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //1.需要先找到要删除的节点 targetNode
            Node targetNode = search(value);
            //如果没有找到要删除的节点
            if (targetNode == null) {
                return;//直接结束即可
            }
            //如果我们发现当这个二叉排序树只有一个节点,而且这个节点就是要查找删除的节点，直接置空删除即可
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            //2.去找targetNode的父节点
            Node parent = searchParent(value);
            //情况一：如果删除的节点是叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                //判断targetNode是父节点的左子节点还是右子节点
                if (parent.left != null && parent.left.value == value) {//是左子节点
                    //说明要删除的targetNode就是要删除的
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {//是右子节点
                    parent.right = null;

                }
            } else if (targetNode.left != null && targetNode.right != null) {//这个是情况三
                //删除的节点有两个子树
                int minValue = delRightTreeMin(targetNode.right);//用个临时变量将最小结点的值保存
                targetNode.value = minValue;//重置value值

            } else {//情况二，删除只有一颗子树的节点，因为前两种情况都排除了
                //如果要删除的节点有左子节点
                if (targetNode.left != null) {//表示要删除的节点有左节点
                    if (parent != null) {//父节点存在
                        if (parent.left.value == value) {
                            //如果targetNode是parent的左子节点
                            parent.left = targetNode.left;//删除
                        } else {
                            //说明targetNode是parent的右子节点
                            parent.right = targetNode.left;//删除
                        }
                    } else {//父节点不存在，且目前只有一颗左子树
                        root = targetNode.left;////删除
                    }
                } else {//表示要删除的节点有右节点
                    if (parent != null) {//父节点存在
                        if (parent.left.value == value) {
                            //如果targetNode是parent的左子节点
                            parent.left = targetNode.right;//删除
                        } else {//如果targetNode是parent的右子节点
                            parent.right = targetNode.right;//删除
                        }
                    } else {//父节点不存在，且目前只有一颗右子树
                        root = targetNode.right;////删除
                    }
                }
            }
        }
    }

    //添加结点的方法
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //遍历方法
    public void infisOrder() {
        if (root != null) {
            root.infisOrder();
        } else {
            System.out.println("空树，不可遍历");
        }
    }

}

//创建node节点
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + '}';
    }

    //添加结点
    //递归的形式添加结点，需要满足二叉排序树的要求
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //判断传入的节点的值，和当前子树的节点的值关系
        if (node.value < this.value) {//添加的节点小于当前节点
            //如果当前节点左子结点为null
            if (this.left == null) {
                this.left = node;
            } else {
                //递归的向左子树添加
                this.left.add(node);
            }
        } else {//添加的节点大于当前节点
            if (this.right == null) {
                this.right = node;
            } else {
                //递归的向右子树添加
                this.right.add(node);
            }
        }
    }

    //中序遍历
    public void infisOrder() {
        if (this.left != null) {
            this.left.infisOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infisOrder();
        }
    }

    /**
     * 查找要删除的结点
     *
     * @param value 希望删除的节点的值
     * @return 如果找到了返回该结点，否则返回null
     */
    public Node search(int value) {
        if (value == this.value) {//找到就返回
            return this;
        } else if (value < this.value) {//如果查找的值，小于当前节点，向左子树递归查找
            if (this.left == null) {//如果左子树为空
                return null;
            }
            return this.left.search(value);//向左递归
        } else {//如果查找的值不小于当前结点，享有字数递归查找
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);//向右递归
        }
    }

    /**
     * 查找要删除结点的父节点
     *
     * @param value 要查找的值
     * @return 要删除结点的父节点
     */
    public Node searchParent(int value) {
        //如果当前结点就是要删除结点的父节点，就返回
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (this.value <= value && this.right != null) {//如果查找的值大于当前结点的值，且当前结点的左子结点不为空
                return this.right.searchParent(value);//向右子树递归查找
            }
            if (this.value > value && this.left != null) {//如果查找的值小于当前结点的值，且当前结点的右子结点不为空
                return this.left.searchParent(value);//向左子树递归查找
            }
            return null;//没有找到父节点，就返回空
        }
    }
}