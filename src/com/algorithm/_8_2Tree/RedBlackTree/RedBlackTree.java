package com.algorithm._8_2Tree.RedBlackTree;

//红黑树
public class RedBlackTree<K extends Comparable<K>, V> {

    //根节点
    private Node<K, V> root;
    //结点个数
    private int N;
    //直接true、false可读性不高
    private static final boolean RED = true;//红
    private static final boolean BLACK = false;//黑

    //结点类
    private class Node<K, V> {
        //存储键
        private K key;
        //存储值
        private V value;
        //记录左子结点
        private Node<K, V> left;
        //记录右子结点
        private Node<K, V> right;
        //我们将指向该结点的连接定义成颜色。
        //在红黑树中，根节点是一个比较特殊的结点，它的连接一定是黑色的，因为没有任何结点指向它/
        //由其父节点指向它的链接的颜色
        private boolean color;

        //构造方法
        public Node(K key, V value, Node<K, V> left, Node<K, V> right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

    //构造方法
    public RedBlackTree() {
        root = null;
        N = 0;
    }

    //获取树中元素的个数
    public int size() {
        return N;
    }

    //判断树是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * @param node 结点
     * @return 判断指向该结点的连接是否为红色
     */
    public boolean isRed(Node<K, V> node) {
        //如果为null，我们认为其连接是黑色的
        if (node == null) return false;
        return node.color == RED;
    }

    //因为红黑树本身一个种平衡树。所以我们要进行树的平衡化。使整个树平衡（意思就是：在数进行增删改查操作时不破坏红黑树的规则）:

    /**
     * @param node h结点的右连接为红，我们需要将该红链接改到左面
     * @return Node 返回更改后满足条件的结点（更改后的结点并不是h了，是h的右子节点）
     * 左旋目的：是为了有4-结点时操作
     * <p>
     * 由于传进来的这个结点应该还是其父节点的，所以我们要返回修改后的结点作为其原来父节点的左/右结点。
     */
    private Node<K, V> rotateLeft(Node<K, V> node) {
        //获取node结点的右子节点rightnode
        Node<K, V> rightnode = node.right;
        //将rightnode的左子节点作为当前结点的右子节点(因为rightnode的左子节点必比node大)
        node.right = rightnode.left;
        //将node作为rightnode的左子节点
        rightnode.left = node;
        //将node的颜色复制给rightnode颜色，因为之前与上面连接的是h，该后就变成rightnode了
        rightnode.color = node.color;
        //node的颜色为红色
        node.color = RED;
        //返回新的结点
        return rightnode;
    }

    /**
     * @param node node结点和其左子结点（leftnode）的连接和 leftnode和leftnode的左子结点的左子树连接都为红，我们需要进行右旋操作
     * @return Node 返回更改后的结点（更改后，返回为：node与其左子结点和其右子结点的连接都为红。但是显然，这样也不行，因为还是构成了一个4-结点，所以我们好需要一步操作：”颜色反转“）
     * 右旋目的：当出现当出现一个结点的两个连接都为红链接时，说明这是一个4-结点，但是红黑树/2-3树不允许4-结点的存在
     * 函数作用：“将node结点和其左子结点（leftnode）的连接和 leftnode和leftnode的左子结点的左子树连接都为红” 修改为： “该结点与其左子结点和其右子结点的连接都为红”
     */
    private Node<K, V> rotateRight(Node<K, V> node) {
        //获取h的左子节点leftnode
        Node<K, V> leftnode = node.left;
        //leftnode的右子节点作为node的左子节点
        node.left = leftnode.right;
        //node作为leftnode的右子节点
        leftnode.right = node;
        //把node的颜色赋值给leftnode的颜色
        leftnode.color = node.color;
        //让node的颜色为红色
        node.color = RED;
        //返回修改后满足条件的结点
        return leftnode;
    }

    /**
     * 反转颜色：即将右旋后的结果在进行处理，使其恢复红黑树的规则
     * 这个方法就比较简单了
     *
     * @param node node结点的左右子树连接都为红色时，进行修改
     */
    private void flipColors(Node<K, V> node) {
        //让node的左子节点和右子结点的颜色变成黑色
        node.left.color = BLACK;
        node.right.color = BLACK;
        //node结点的颜色变为红色
        node.color = RED;
    }

    //由于我们想要实现平衡树，所以每次插入都让其连接为红色，然后使整颗树平衡
    public void put(K key, V value) {
        root = put(root, key, value);
        //因为红黑树结构可能发生改变，根节点的颜色可能发生改变
        //根节点的颜色总是黑色的
        root.color = BLACK;
    }

    /**
     * insert重载方法，向指定树中插入元素
     *
     * @param node  指定树
     * @param key   插入的键
     * @param value 插入的值
     * @return 返回的结点是插入后的根节点（因为插入后可能会引起树根节点的变化）
     */
    private Node<K, V> put(Node<K, V> node, K key, V value) {
        //如果node为空，那么直接返回一个红色的结点即可
        if (node == null) {
            N++;
            return new Node<>(key, value, null, null, RED);
        }

        //判断插入元素与当前结点key值的大小关系,(cmp<0说明前面的小)
        int cmp = node.key.compareTo(key);//比较
        //如果比当前元素小
        if (cmp > 0) {//大于，继续左递归查找
            node.left = put(node.left, key, value);//递归寻找
        } else if (cmp < 0) {//小于，继续右递归查找
            node.right = put(node.right, key, value);//同理
        } else {//key相等，说明执行的不是增加，是修改
            node.value = value;
            return node;
        }

        //我们需要判断插入后，如果不满足红黑树的定义，我们要把它改成满足红黑树的样子
        if (isRed(node.right) && !isRed(node.left)) {//当当前结点的左子结点为黑色，右子结点为红色
            node = rotateLeft(node);//左旋
        }

        if (isRed(node.left) && isRed(node.left.left)) {//当当前结点的左子结点为红色，左子结点的左子结点还是红色
            node = rotateRight(node);//右旋
        }

        if (isRed(node.left) && isRed((node.right))) {//当当前节点的左子节点和右子结点都为红色时
            flipColors(node);//颜色反转
        }

        return node;
    }

    /**
     * 获取整个树的key所对应value
     *
     * @param key 键
     * @return 找到的结果
     */
    public V get(K key) {
        return get(root, key);
    }

    /**
     * get的重载方法，找到某棵树上的键所对应的值
     *
     * @param node 某个结点/树的根节点
     * @param key  键
     * @return 找到的结果
     */
    private V get(Node<K, V> node, K key) {
        if (node == null) return null;//为空

        int cmp = node.key.compareTo(key);
        if (cmp > 0) {//大于，向左递归，继续查找
            return get(node.left, key);
        } else if (cmp < 0) {//小于，向右递归，继续查找
            return get(node.right, key);
        } else {//找到，输出value值
            return node.value;
        }
    }

}

class RedBlackTreeDemo {
    public static void main(String[] args) {

        //创建树
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();

        //存入元素
        tree.put(1, "A");
        tree.put(2, "B");
        tree.put(3, "C");
        tree.put(4, "D");
        tree.put(5, "E");
        tree.put(6, "F");
        tree.put(7, "G");
        tree.put(8, "H");
        tree.put(9, "I");

        //获取元素
        for (int i = 1; i < tree.size(); i++) {
            System.out.println(tree.get(i));
        }

    }
}
