package com.bit.dao;/**
 *
 */

import com.Impl.ILinked;

/**
 * @auther deng
 * @date 2019/3/31 下午 04:20
 */


public class MySingleListImpl  implements ILinked {
    //把节点写成成员内部类
    class Node {
        private int data;
        private Node next;

        //在构造器里初始化
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
       private Node head;
       public MySingleListImpl(){
           this.head = null;
       }
    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        //第一次插入数据
        if(this.head == null) {
            this.head =node;
        } else {
            node.next = head;
            this.head =node;
        }
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        //第一次插入
        if(cur == null) {
            this.head = node;
        } else {
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //找到index-1位置的节点
    private Node searchIndex(int index) {
           checkIndex(index);
           //如果是头节点
           if(index == 0) {
               return null;
           }
           //记录从头节点移动的次数
           int count = 0;
           Node cur =this.head;
           while(cur != null && count < index - 1) {
               cur = cur.next;
               count++;
           }
           return cur;
    }

    //判断index下标合法性
    private  void checkIndex(int index) {
           if(index < 0 || index > getLength()) {
               throw new IndexOutOfBoundsException("下标不合法");
           }
    }

    @Override
    public boolean addindex(int index, int data) {
           Node node = new Node(data);
           Node cur =searchIndex(index);
           if(cur ==null) {
               node.next = this.head;
               this.head = node;
           }
        return false;
    }

    @Override
    public boolean contains(int key) {
           Node cur = this.head;
           while(cur != null) {
               if(cur.data == key) {
                   return true;
               } else {
                   cur =cur.next;
               }
           }
        return false;
    }

    @Override
    public int remove(int key) {
        return 0;
    }

    @Override
    public void removeAllKey(int key) {

    }

    @Override
    public int getLength() {
        Node cur = this.head;
        int num=0;
        while(cur != null){
            num++;
            cur = cur.next;
        }
        return num;
    }

    @Override
    public void display() {
        Node cur = this.head;
        while(cur !=null) {
            System.out.println(cur.data + " ");
            cur = cur.next;
        }
    }

    @Override
    public void clear() {

    }
}

