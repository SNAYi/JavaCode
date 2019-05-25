package com.deng.programming;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/25 下午 10:38
 */
import java.util.Stack;

public class Title2 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {    //s1为优先输入栈
        stack1.push(node);
    }

    public int pop() {
        //s2为优先输出栈
        if(stack2.empty()){    //1.s2为空
            while(!stack1.empty()) {
                stack2.push(stack1.pop());    //将s2数据全部搬移到s2，s1的栈底到了s2栈顶
            }
            int temp = stack2.pop();    //取得栈顶元素然后返回
            return temp;
        } else {    //2.s2不为空，直接弹出s2元素
            int temp = stack2.pop();
            return temp;
        }
    }
}