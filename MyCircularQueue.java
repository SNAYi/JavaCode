package com.deng.main;/**
 *
 */

/**
 * @auther deng
 * @date 2019/4/21 下午 02:43
 */

//此方案浪费了一个数组空间，LeeCode要求不能浪费空间，要在new数组时 k + 1
public class MyCircularQueue {
    private int front;  // 堆头下标
    private int rear;   //队尾下标
    private int[] elem; //  数组构成的队列
    private int usedSize;

    public MyCircularQueue(int k) {
        this.elem = new int[k];
        this.front = 0;
        this.rear = 0;
        this.usedSize = 0;
    }

    /** 将元素插入循环队列。如果操作成功，返回true */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        this.elem[this.rear] = value;
        usedSize++;
        this.rear = (rear + 1) % this.elem.length;
        return  true;

    }

    /** 从循环队列中删除一个元素。如果操作成功，返回true。 */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        this.front = (this.front + 1) % this.elem.length;
        this.usedSize--;
        return true;
    }

    /** 获取队头元素 */
    public int Front() {
        if (isEmpty()) {
            return  -1;
        }
        return this.elem[this.front];
    }

    /** 获取队尾元素 */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        //int temp = ((this.rear + this.elem.length) -1) % this.elem.length;
//        return this.elem[temp];
        return this.rear == 0 ? this.elem[this.elem.length - 1] : this.elem[this.rear -1];

    }

    /** 是否为空 */
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    /** 是否为满 */
    public boolean isFull() {
        return (rear + 1) % this.elem.length == this.front;
    }
}
