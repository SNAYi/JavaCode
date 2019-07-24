package Title;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-23 14:56
 * @Description:
 * 题目：给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 *       s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * 找到t的根节点在s中的位置
 * 判断两颗二叉树是否相等
 * 解题思路：在s中查找t的位置+判断两个树是否相同
 */
public class SubTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        //设置标志位来判断是否相同
        boolean flag = false;
        if (s!= null) {
            //1.s当前根节点的值等于t的值，已经在s中找到t对应子树
            if (s.val == t.val) {
                //2.进一步判断相等
                flag = isSameTree(s,t);
            }
            //当前s还未遍历完，仍未找到s中值也为t的节点
            if (!flag){
                //当前s值不等于t值，需要递归s来查找t位置
                flag = isSubtree(s.left,t) ||isSubtree(s.right,t);
            }
        }
        return flag;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //判断两个树当前根节点是否为空
        if (p == null && q == null) {
            return true;
        }
        //两个根节点中只有一个为空
        if (p == null || q== null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        //走到此处，已经可以确定两树当前根节点都不为空，且值相等
        //递归判断左子树和右子树
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
