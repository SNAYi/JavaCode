package com.deng.dao;/**
 *
 */

import com.deng.impl.IMyQueue;

/**
 * @auther deng
 * @date 2019/4/14 下午 03:48
 */


public class MyQueueImpl implements IMyQueue {
    class Node{
        private int data;
        private Node next;
        public Node(int data) {
            this.data =data;
        }
    }

    private  Node front;
    private Node rear;
    private  int usedsize;

    public MyQueueImpl() {
        this.front = null;
        this.rear = null;
        this.usedsize = 0;
    }

    @Override
    public boolean empty() {
       // return this.front == null;
        return this.usedsize == 0;
    }

    // 返回队首元素，但不出队列
    @Override
    public int peek() {
        if (empty()){
            throw new UnsupportedOperationException("队列为空");
        }
//        int returnData = this.front.data;
//        return returnData;
        return this.front.data;
    }


    // 返回队首元素，并且出队列
    @Override
    public int poll() {
        if (empty()){
            throw new UnsupportedOperationException("队列为空");
        }
        //保存队首元素
        int returnData = this.front.data;
        //队首后移
        this.front = this.front.next;
        this.usedsize--;
        return returnData;
    }
    // 将 item 放入队列中，尾插
    @Override
    public void add(int item) {
        Node node = new Node(item);
        //插入第一个节点
        if (empty()){
           this.front = node;
           this.rear = node;
           usedsize++;
        }else {
            //插入的不是第一个节点，采用尾插
            this.rear.next = node;
            this.rear =node;
            usedsize++;
        }
    }

    @Override
    public int size() {
        return this.usedsize;
    }
}
