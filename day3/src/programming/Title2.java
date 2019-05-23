package programming;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/23 下午 09:55
 */


import java.util.Stack;
public class Title2 {
    public boolean chkParenthesis(String A, int n) {
        Stack<Character> lefts = new Stack<Character>();
        if(A == null || A.length() != n){
            return false;
        }
        for(int i = 0; i < n; i++){
            if(A.charAt(i) == '('){
                lefts.push(A.charAt(i));
            }else if(A.charAt(i) == ')'){
                if(lefts.empty()){
                    return false;
                }else{
                    lefts.pop();
                }
            }else{
                return false;
            }
        }
        if(!lefts.empty()){
            return false;
        }else{
            return true;
        }
    }
}
