package Title;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-23 15:17
 * @Description:
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        //如果二叉树为空
        if (root == null) {
            return 0;
        }
        //走到这里已经不为空,分别去左树和右树去找最大深度，然后取更大的那个
        int max = Math.max(maxDepth(root.left),maxDepth(root.right));
        return max+1;
    }
}
