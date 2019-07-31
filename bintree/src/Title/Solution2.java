package Title;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-24 15:41
 * @Description: 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * 空节点则用一对空括号 "()" 表示。
 * 而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。即省略空的右括号
 */
public class Solution2 {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        tree2str(t,sb);
        return sb.toString();

    }
    public void tree2str(TreeNode t,StringBuilder sb) {
        //整个树为空
        if(t == null) {
            return;
        }
        //先输出当前根节点
        sb.append(t.val);
        //如果当前节点左树不为空，需要在其后缀一对括号
        if (t.left != null) {
            sb.append("(");
            tree2str(t.left,sb);
            sb.append(")");
        } else {
            //左子树为空，但右子树不为空
            if (t.right != null) {
                sb.append("()");
            }
        }


        if (t.right != null) {
            sb.append("(");
            tree2str(t.right,sb);
            sb.append(")");
        }
    }
}
