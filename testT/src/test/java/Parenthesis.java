/**
 * @Author: snayi
 * @CreateTime: 2019-08-18 22:11
 * @Description: 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 *                  给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 *
 *                  使用栈实现
 */
import java.util.*;
import java.lang.*;

public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        Stack<Character> stack = new Stack<>();
        int stackLen = 0;
        for(int i = 0;i < n;i++) {
            char c = A.charAt(i);
            //左括号入栈
            if(c == '(') {
                stack.push(c);
                stackLen++;
            } else {    //右括号
                if(c == ')' && stackLen!=0){  //当前为右括号且栈里还有左括号
                    stack.pop();
                    stackLen--;
                } else {	//既不是左括号也不是右括号
                    return false;
                }
            }
        }
        return true;
    }
}
