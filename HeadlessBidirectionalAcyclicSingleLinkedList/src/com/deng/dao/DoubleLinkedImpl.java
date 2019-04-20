package com.deng.dao;/**
 *
 */

import com.deng.impl.IDoubleLinked;

/**
 * @auther deng
 * @date 2019/4/13 下午 09:02
 */


public class DoubleLinkedImpl implements IDoubleLinked {
    class  Node{
        private int data;
        private Node prev;//前驱
        private  Node next;//后继

        private Node(int data){
            this.data = data;
//            this.prev = null;
//            this.next = null;
        }
    }
    private Node head;//头节点
    private Node last;//尾节点的出现让我们尾插可以不用遍历单链表

    public  DoubleLinkedImpl() {
        this.head =null;
        this.last =null;
    }

    @Override
    public void addFirst(int data) {
        Node node =new Node(data);
        //1.第一次插入
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            node.next = this.head;
            //this.node.prev = node;
            node.next.prev =node;
            this.head = node;
        }
    }

    @Override
    public void addLast(int data) {
        Node node =new Node(data);
        //1.第一次插入
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }

    private Node searchIndex(int index){
        checkIndex(index);
        Node cur = this.head;
        int step =0;
        while(step < index) {
            cur = cur.next;
            step++;
        }
        //出循环之后的cur就是index的位置
        return cur;
    }

    private void checkIndex(int index){
        if(index < 0 ||index >getLength()){
            throw new IndexOutOfBoundsException("下标越界");
        }
    }

    //双向链表不用再找前驱
    @Override
    public boolean addIndex(int index, int data) {
        Node node = new Node(data);
        if (index ==0) {
            addFirst(data);
            return true;
        } else if (index ==getLength()){
            addLast(data);
            return true;
        }else {
            Node cur =searchIndex(index);
            //先next,后prev
            node.next =cur;
            cur.prev.next = node;
            node.prev = cur.prev;
            cur.prev =node;
            return true;
        }
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return  true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public int remove(int key) {
        Node cur =this.head;
        while(cur != null){
            if (cur.data == key) {
                int oldData = cur.data;
                //是否删除的是头节点
                if (cur ==this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                    return oldData;
                } else  {
                    cur.prev.next = cur.next;
                    //不为尾节点时才执行
                    if (cur.next !=null) {
                        cur.next.prev =cur.prev;
                    } else {
                        //删除最后一个节点，last需要前移一个
                        this.last =cur.prev;
                    }
                return oldData;
                }
            }
            cur = cur.next;
        }
        return 0;
    }

    @Override
    public void removeAllKey(int key) {
        Node cur =this.head;
        while(cur != null){
            if (cur.data == key) {
                //是否删除的是头节点
                if (cur ==this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else  {
                    cur.prev.next = cur.next;
                    //不为尾节点时才执行
                    if (cur.next !=null) {
                        cur.next.prev =cur.prev;
                    } else {
                        //删除最后一个节点，last需要前移一个
                        this.last =cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

    @Override
    public int getLength() {
        int count = 0;
        Node cur  =this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        while (this.head != null) {
            Node cur = this.head.next;
            this.head.next = null;
            this.head = cur;
        }
        this.last = null;
    }
}
