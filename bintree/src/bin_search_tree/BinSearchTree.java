package bin_search_tree;

import bin_tree.BinTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-23 10:11
 * @Description: 二分搜索树
 */
public class BinSearchTree<E extends Comparable<E>> implements BinTree<E> {
    private class Node{
        E data;
        Node left;
        Node right;

        public Node(E data) {
            this.data = data;
        }
    }
    private Node root;
    private int size;
    @Override
    public void add(E e) {
        //在进行插入操作后，树结构会产生变化，需要将变化后的根节点替换原来根节点
        root = add(root,e);
    }
    /**
     * 以当前node为根节点，插入元素为e的节点
     * @param node
     * @param e
     * @return  返回插入后树的根节点
     */
    private Node add(Node node,E e) {
        //当前节点为空，直接产生新节点替换当前
        if (node == null) {
            Node newNode = new Node(e);
            size++;
            return newNode;
        }
        //判断此时应该在左树插入还是右树
        if (e.compareTo(node.data) < 0) {
            //去左树插入，然后更新左树根节点
           node.left = add(node.left,e);
        }
        if (e.compareTo(node.data) > 0) {
            //去右树插入然后更新右树根节点
            node.right=add(node.right,e);
        }
        return node;
    }

    /**
     * 以指定node为根节点，插入指定元素
     * 前三个条件语句是递归出口
     */
   /* private void add(Node node,E e) {
        //要插入元素值等于当前根节点值
        if (node.data.compareTo(e) == 0) {
            return;
        }
        //待插入元素值小于当前根节点值 且当前根节点左子树为空，在左子树插入
        else if (e.compareTo(node.data) < 0 && node.left == null) {
            Node newNode = new Node(e);
            node.left =newNode;
            size++;
        }
        //待插入元素值大于当前根节点元素值 且当前根节点右子树为空。在右子树插入
        else if (e.compareTo(node.data) > 0 && node.right ==null) {
            Node newNode = new Node(e);
            node.right = newNode;
            size++;
        }
        //改变根节点位置，去左子树递归寻找插入位置
        else if (e.compareTo(node.data) < 0) {
            add(node.left,e);
        }
        //改变根节点位置，去右子树递归寻找插入位置
        else if (e.compareTo(node.data) > 0) {
            add(node.right,e);
        }

    }*/

    @Override
    public boolean contains(E e) {
        if (root == null) {
            return false;
        }
        //以根节点开始递归的查找数据
        return contains(root,e);
    }
    private boolean contains(Node node,E e) {
        if (node == null) {
            return false;
        }
        //待查找数据的值等于当前根节点的值
        if (e.equals(node.data)) {
            return true;
        }
        //待查找数据小于当前根节点的值
        else if (e.compareTo(node.data) < 0) {
            return contains(node.left,e);
        }
        //否则 带查找数据大于当前根节点的值，递归去右子树查找
        else  {
            return contains(node.right,e);
        }
    }

    @Override
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 以当前节点作为根节点进行前序遍历
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        //1.输出本节点
        System.out.println(node.data);
        //2.以左节点作为根节点前序遍历
        preOrder(node.left);
        //3.以右节点作为根节点前序遍历
        preOrder(node.right);
    }

    /**
     * 非递归的前序遍历
     */

    @Override
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 以当前node为根节点，进行中序遍历
     * @param node
     */
    private void inOrder(Node node) {
        //如果根节点为空
        if (node == null) {
            return;
        }
        //1.先遍历左树
        inOrder(node.left);
        //2.再输出当前根节点
        System.out.println(node.data);
        //3.最后遍历右树
        inOrder(node.right);
    }

    /**
     * 非递归的中序遍历
     */
/*    public void inOrderNoR(){
        inOrderNoR(root);
    }*/
/*    private void inOrderNoR(Node node){
        Node cur = node;
        Stack<Node> stack = new Stack<>();
        Node top = null;
        while (cur != null || !stack.isEmpty()){
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;

            }
        top = stack.pop();
        System.out.print(top.data + "、");
        cur = top.right;
    }*/

    @Override
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        postOrder(node.right);
        System.out.println(node);
    }
    //二叉树的层序遍历
    public void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Node cur = root;
        if (cur != null) {
            queue.offer(cur);
        }
        while (!queue.isEmpty()){
            cur = queue.poll();
            System.out.print(cur);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
        }
    }

    //不一定是叶子节点，一直递归向左子树走，直到走不动为止，此时就是最小值
    @Override
    public E getMin() {
        if (root == null)
            throw new IllegalArgumentException("The BST is empty");
        Node node = getMinNode(root);
        return node.data;
    }
    private Node getMinNode(Node node) {
        //当前节点已经没有左子树，那么它就是最小值
        if (node.left == null) {
            return node;
        }
        //走到这里，就是还有左子树，可以继续向下，向左走
        return getMinNode(node.left);
    }
    //不一定是叶子节点，一直递归向右子树走，直到走不动为止，此时就是最大值
    @Override
    public E getMax() {
        if (root == null)
            throw new IllegalArgumentException("The BST is empty");
        Node node = getMaxNode(root);
        return node.data;
    }
    private Node getMaxNode(Node node) {
        //当前节点已经没有右子树，那么它就是最大值
        if (node.right == null) {
            return node;
        }
        //走到这里，就是还有右子树，可以继续向下，向右走
        return getMinNode(node.right);
    }

    @Override
    public E removeMin() {
        E result = getMin();
        root = removeMinNode(root);
        return result;
    }

    /**
     * 删除传入的二叉树的最小值节点
     * 返回删除后二叉树的根节点
     * @param node
     * @return
     */
    private Node removeMinNode(Node node){
        //当前node就是最小值
        if (node.left == null) {
            //保存要链到上级节点的根节点
            Node rightNode = node.right;
            //让node和树的下面连接断开
            node.right = null;
            size--;
            return rightNode;
        }
        //向左一直走，直到找到最小值节点
        //此行是把最小节点的右子树和最小节点的根节点连起来
        node.left = removeMinNode(node.left);
        return node;
    }

    @Override
    public E removeMax() {
        E result = getMax();
        root = removeMaxNode(root);
        return result;
    }
    private Node removeMaxNode(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left =null;
            size--;
            return leftNode;
        }
        node.right = removeMaxNode(node.right);
        return node;
    }

    @Override
    public void remove(E e) {
        root = remove(root,e);
    }

    /**
     * 删除以node为根节点且值为e的节点
     * 返回删除后的二叉树根节点
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node,E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.data) < 0) {
            node.left = remove(node.left,e);
        }
        if (e.compareTo(node.data) > 0) {
            node.right = remove(node.right,e);
        }
        //此时node就为需要删除的节点
        else {
            //若此时节点只有一边孩子
            if (node.left != null && node.right == null) {
                Node leftNode = node.left;
                size--;
                node.left = null;
                return leftNode;
            }
            if (node.right != null && node.left == null) {
                Node rightNode = node.right;
                size--;
                node.right = null;
                return rightNode;
            }
            if (node.left !=null && node.right != null) {
                //找到前驱或后继节点
                Node successor = getMinNode(node.right);
                successor.left = node.left;
                successor.right = removeMinNode(node.right);
                node.left = node.right =null;
                return successor;
            }
        }
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateTreeStruct(root,0,res);
        return res.toString();
    }
    private void generateTreeStruct(Node node,int depth,StringBuilder res) {
        if (node == null) {
            System.out.println("null"+"\n");
            return;
        }

        res.append(generateGang(depth)+node.data+"\n");
        generateTreeStruct(node.left,depth+1,res);
        generateTreeStruct(node.right,depth+1,res);

    }
    private String generateGang(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }
}
