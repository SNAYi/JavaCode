package Title;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-24 16:53
 * @Description:
 */
public class Solution3 {
    //创建list来存放树遍历的值
    List<Integer> list = new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return Collections.emptyList();
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
}
