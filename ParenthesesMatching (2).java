package com.deng.main;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/11 下午 07:40
 */


public class ParenthesesMatching {
    //1.括号匹配问题
    public boolean isValid(String s) {
        //stack是栈
        char[] stack = new char[s.length()];
        int top = 0;
        //char ch = str.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack[top++] =s.charAt(i);
            } else {
                //右括号多
                if (top == 0) {
                    return false;
                }
                char valid =stack[top -1];
                if (valid == '(' && s.charAt(i) == ')' || valid == '{' && s.charAt(i) == '}'
                        ||valid == '[' && s.charAt(i) == ']') {
                    --top;
                } else {
                    return false;
                }
            }
            if (top > 0) {
                System.out.println("左括号多了");
            }
        }
        System.out.println("左右括号匹配");
        return true;
    }
    //自己实现

    //判断传进来的s的每个字符是不是括号
    public boolean isBracket(char ch) {
        if (ch =='(' || ch ==')' || ch =='{' || ch =='}' || ch =='[' || ch ==']') {
            return true;
        } else {
            return false;
        }
    }

    /**
     *采用栈实现。
     * 1.如果是左括号，就入栈；
     * 2.如果一开始就是右括号，则一定匹配不成功
     * 3.如果遇到右括号，就从拿出栈顶左括号与之匹配，匹配成功该左括号出栈，继续匹配，否则匹配不成功
     * @param s The string to determine
     * @return  if String valid,return true
     */

    public boolean isValid2(String s) {
        //1.得有一个长度与s相同或大于s长度的一个char类型的栈
        char[] c = new char[s.length()];
        int top = 0;
        //2.遍历字符串，判断传进来的s的每个字符是不是括号
        for (int i = 0; i < s.length(); i++) {
            //2.1不是括号
            if (!isBracket(s.charAt(i))) {
                continue;
            } else {    //2.2是括号
                if (s.charAt(i) =='(' || s.charAt(i) =='{' || s.charAt(i) =='[') {    //2.2.1是左括号入栈
                    c[top++] = s.charAt(i);
                } else { //2.2.2是右括号,匹配
                    if (top == 0) { // 结果1：右括号多
                        return false;
                    }
                    if ((s.charAt(i) ==')' && c[top-1] == '(') || (s.charAt(i) =='}' && c[top-1] == '{')
                            || (s.charAt(i) ==']' && c[top-1] == '[')) {    //匹配成功,c[--top]出栈
                        top--;
                    } else {    //结果2：右括号前有左括号匹配,但匹配不成功
                        return false;
                    }
                }
            }
        }
        if (top > 0) { // 结果3：左括号多
            return false;
        }
        return true; //结果4：匹配成功
    }
}
