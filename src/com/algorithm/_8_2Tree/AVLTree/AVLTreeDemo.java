package com.algorithm._8_2Tree.AVLTree;

//二叉平衡树
public class AVLTreeDemo {

    public static void main(String[] args) {
        int[] arr1 = {4, 3, 6, 5, 7, 8};
        //创建以一个AVLTree对象
        AVLTree leftavlTree = new AVLTree();
        //添加结点
        for (int element : arr1) {
            leftavlTree.add(new Node(element));
        }

        //遍历
        leftavlTree.infisOrder();

        //子树高度
        System.out.println("树的高度:" + leftavlTree.getRoot().height());
        //左子树高度
        System.out.println("左子树高度:" + leftavlTree.getRoot().leftHeight());
        //右子树高度
        System.out.println("右子树高度:" + leftavlTree.getRoot().rightHeight());

        int[] arr2 = {10, 12, 8, 9, 7, 6};
        //创建以一个AVLTree对象
        AVLTree rightavlTree = new AVLTree();
        //添加结点
        for (int item : arr2) {
            rightavlTree.add(new Node(item));
        }

        //遍历
        rightavlTree.infisOrder();

        //子树高度
        System.out.println("树的高度:" + rightavlTree.getRoot().height());
        //左子树高度
        System.out.println("左子树高度:" + rightavlTree.getRoot().leftHeight());
        //右子树高度
        System.out.println("右子树高度:" + rightavlTree.getRoot().rightHeight());


        int[] arr3 = {10, 12, 8, 9, 7, 6};
        //创建以一个AVLTree对象
        AVLTree avlTree = new AVLTree();
        //添加结点
        for (int value : arr3) {
            avlTree.add(new Node(value));
        }

        //遍历
        avlTree.infisOrder();

        //子树高度
        System.out.println("树的高度:" + avlTree.getRoot().height());
        //左子树高度
        System.out.println("左子树高度:" + avlTree.getRoot().leftHeight());
        //右子树高度
        System.out.println("右子树高度:" + avlTree.getRoot().rightHeight());
    }
}

//创建AVLTree
class AVLTree {

    private Node root;//根节点

    public Node getRoot() {
        return root;
    }

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
                //int minValue = delRightTreeMin(targetNode.right);//用个临时变量将最小结点的值保存
                //targetNode.value = minValue;//重置value值
                targetNode.value = delRightTreeMin(targetNode.right);

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

class Node {

    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //返回左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    //返回右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    //返回当前结点的高度，一该结点为根节点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;//递归获取
    }

    //左旋转
    public void leftRotate() {
        //创建一个新的节点，以当前节点为值
        Node newNode = new Node(value);
        //把新节点的左子树设置为当前节点的左子树
        newNode.left = left;
        //把新节点的右子树设置成当前结点右子树的左子树
        newNode.right = right.left;
        //把当前节点的值替换成右子树的值
        value = right.value;
        //把当前节点的右子树设置成指向当前结点右子树的右子树
        right = right.right;
        //把当前节点的左子树（结点）指向新生成的结点
        left = newNode;
    }

    //右旋转
    public void rightRotate() {
        //创建一个新的节点，以当前节点为值
        Node newNode = new Node(value);
        //把新节点的右子树设置为当前节点的右子树
        newNode.right = right;
        //把新节点的左子树设置成当前结点左子树的右子树
        newNode.left = left.right;
        //把当前节点的值替换成左子树的值
        value = left.value;
        //把当前节点的左子树设置成指向当前结左子树的左子树
        left = left.left;
        //把当前节点的右子树（结点）指向新生成的结点
        right = newNode;
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

        //当添加完一个节点后，右子树与左子树的高度差>1，就是用AVL
        if (rightHeight() - leftHeight() > 1) {//右大于左
            leftRotate();
        } else if (leftHeight() - rightHeight() > 1) {//左大于右
            rightRotate();
        }

        //双旋转
        if (rightHeight() - leftHeight() > 1) {//右大于左
            if (right != null && right.rightHeight() < right.leftHeight()) {//如果当前结点的右子树的左子树大于右子树的高度
                right.rightRotate();//对象前结点的右子树进行右旋转
                leftRotate();//再对当前节点进行左旋转
            }
            //如果没有上述情况，直接左旋转
            leftRotate();
        } else if (leftHeight() - rightHeight() > 1) {//左大于右
            if (left != null && left.leftHeight() < left.rightHeight()) {//如果当前节点的左子树的右子树大于左子树的高度
                left.leftRotate();//对当前节点的左子树进行左旋转
                rightRotate();//再对当前结点进行右旋转
            }
            //如果没有上述情况，直接右旋转
            rightRotate();
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
