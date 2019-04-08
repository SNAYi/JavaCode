package com.dao;/**
 *
 */

import com.impl.CLinkList;

/**
 * @auther deng
 * @date 2019/4/7 上午 10:24
 */


public class CHeadSingleListImpl implements CLinkList {

    class Node{
        private int data;
        private Node next;

        public Node() {
            //标志头节点
            this.data = -1;
        }
        public Node(int data) {
            this.data =data;
        }
    }


    private Node head;
    public CHeadSingleListImpl() {
        this.head = new Node();
        this.head.next = this.head;
    }

    @Override
    public void addFirst(int data) {
        Node node = new Node();
        node.next = this.head.next;
        this.head.next = node;

    }

    @Override
    public void addLast(int data) {
        Node cur = this.head;
        while(cur.next != this.head) {
            cur = cur.next;
        }
        Node node = new Node(data);
        node.next = this.head;
        cur.next = node;
    }

    public void checkIndex(int index) {
        if(index < 0 || index > getLength()){
            throw new UnsupportedOperationException("插入位置不合法");
        }
    }

    @Override
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index, int data) {
        checkIndex(index);
        Node cur = this.head;
        for (int i = 0; i < index ; i++) {
            cur = cur.next;
        }
        Node node =new Node();
        node.next = cur.next;
        cur.next = node;

        return true;
    }

    @Override
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        Node cur = this.head.next;
        while(cur.data != key) {
            if(cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //找key前驱
    public Node searchPre(int key) {
        Node pre =this.head;
        while(pre.next == this.head ){//pre.next.data !=key
            if(pre.next.data == key) {
                return pre;
            }
            pre = pre.next;
        }
        return null;
//        if(pre.next == this.head) {
//            return null;
//        }
    }

    @Override
    //删除第一次出现关键字为key的节点
    public int remove(int key) {
        Node pre = searchPre(key);
        if(pre == null) {
            throw new UnsupportedOperationException();
        }
        int oldData = 0;
        Node delNode =pre.next;
        oldData =delNode.data;
        pre.next= delNode.next;
        return oldData;
    }

    @Override
    public void removeAllKey(int key) {
        Node pre = this.head;
        Node cur = this.head.next;
        while(cur !=this.head) {
            if(cur.data == key) {
                pre.next= cur.next;
                cur = cur.next;
            } else{
                pre = cur;
                cur = cur.next;

            }
        }
    }

    @Override
    public int getLength() {
        Node cur = this.head.next;
        int count = 0;
        while(cur !=this.head) {
            count++;
            cur = cur.next;
        }
        System.out.println();
        return count;
    }

    @Override
    public void display() {
        Node cur =this.head.next;
        while(cur !=this.head) {
            System.out.println(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        while(this.head.next != this.head) {
            Node cur = this.head.next;
            this.head.next = cur.next;
            cur.next = null;
        }
    }
}
