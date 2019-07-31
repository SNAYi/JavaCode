package Title;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-24 15:12
 * @Description: 给定一个二叉树，返回它的 前序 遍历。
 */

/*class TreeNode {
    int val;
    Title.TreeNode left;
    Title.TreeNode right;
    TreeNode(int x) { val = x; }
}*/
public class Solution1 {

    List<Integer> list = new ArrayList();
    public List<Integer> preorderTraversal(TreeNode root) {
        //如果根节点为空，树为空
        if(root == null)
            //返回一个空list
            return Collections.emptyList();
        //否则遍历本节点
        list.add(root.val);
        //遍历左树
        preorderTraversal(root.left);
        //遍历右树
        preorderTraversal(root.right);
        return list;
    }
}
