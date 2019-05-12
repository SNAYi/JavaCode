package com.deng.main;/**
 *
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/12 下午 10:20
 */

/**
 * 使用两个队列实现栈：q1作为优先输入队列，q2作为优先输出队列
 */
public class UseQueuesImplmentStack {
    private Queue<Integer> queue1;    //q1作为优先输入队列
    private Queue<Integer> queue2;    //q2作为优先输出队列
    public int size;

    public UseQueuesImplmentStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
        size = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (queue1.peek() != null) {    //q1队列不为空
            queue1.offer(x);
        } else if (queue2.peek() != null) {    //q2队列不为空
            queue2.offer(x);
        } else {
            queue1.offer(x);    //如果q1,q2都为空，选择q1放入数据
        }
        this.size++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int returnVal = 0;
        if (queue2.peek() != null) { //q2不为空，先把q2的size-1个数据给q1。只剩一个数据
            for (int i = 0; i < size - 1; i++) {
                queue1.offer(queue2.poll());
            }
            returnVal = queue2.peek();
            queue2.poll(); // 然后把q2剩得数据出出去
        } else {
            for (int i = 0; i < size - 1; i++) {
                queue2.offer(queue1.poll());
            }
            returnVal = queue1.peek();
            queue1.poll();
        }
        size--;
        return returnVal;
    }

    /** Get the top element. */
    public int top() {
        if (empty()){
            throw new RuntimeException("无数据");
        }
        int temp = 0;
        if (queue2.peek() != null) {    //q2不为空，top一定在q2
            for (int i = 0; i < size - 1; i++) {
                queue1.offer(queue2.poll());
            }
            return temp = queue2.peek();
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.size == 0;
    }
}
