package com.deng.dao;/**
 *
 */

import com.deng.impl.IMyStack;

/**
 * @auther deng
 * @date 2019/4/14 下午 03:08
 */


public class MyStackImpl implements IMyStack {
    private int[] elem;
    private int top;
    private  int usedsize;
    private static final int DEFAUIL_CAPICITY = 10;
    public MyStackImpl() {
        this.elem = new int[DEFAUIL_CAPICITY];
        this.top = 0;
        this.usedsize = 0;
    }

    public boolean isFull(){
       return this.top ==DEFAUIL_CAPICITY;
        //return this.top ==this.elem.length;
    }

    // 将 item 压入栈中
    @Override
    public void push(int item) {
        //1.判断栈是否满了
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("栈已满");
        }
        //this.elem[this.top++] =item;
        this.elem[this.top] =item;
        top++;
        usedsize++;
    }

    @Override
    public int pop() {
        if (empty()){
            throw new UnsupportedOperationException("栈为空");
        }
        int returnData =this.elem[this.top -1];
        this.top--;
        this.usedsize--;

        return returnData;
    }
    //不出栈，不用--
    @Override
    public int peek() {
        if (empty()){
            throw new UnsupportedOperationException("栈为空");
        }
        int returnData =this.elem[this.top -1];
        return returnData;
    }

    @Override
    public boolean empty() {
        if (this.top == 0){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        //return this.usedsize;
        return this.top;
    }
}
