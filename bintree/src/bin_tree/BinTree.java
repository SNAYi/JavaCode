package bin_tree;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-23 10:03
 * @Description:
 */
public interface BinTree<E> {
    void add(E e);
    boolean contains(E e);
    //前序遍历
    void preOrder();
    //中序遍历
    void inOrder();
    //后续遍历
    void postOrder();

    /**
     * 取得最小值
     * @return
     */
    E getMin();
    E getMax();

    /**
     * 移除二叉树中最小值
     * @return
     */
    E removeMin();
    E removeMax();

    /**
     * 移除二叉树中指定值得节点
     * @param e
     * @return
     */
   void remove(E e);

    int size();

}
