package Title;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-23 13:36
 * @Description:
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class SameTree {
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
