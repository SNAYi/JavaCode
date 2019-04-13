package com.deng.dao;/**
 *
 */

import com.deng.impl.ICLinked;

/**
 * @auther deng
 * @date 2019/4/13 下午 06:48
 */


public class CLinkedImpl implements ICLinked {
    //1.节点类
    class Node{
        private  int data;
        private Node next;
        //无参构造，给头节点用的
        public Node(){
            this.data = -1;
        }
        public  Node(int data) {
            this.data = data;
        }
    }
    private Node head;
    //设置头节点
    public CLinkedImpl() {
        //调无参构造，设置头节点data为-1
        this.head = new Node();
        this.head.next =this.head;
    }
    @Override
    public void addFirst(int data) {
        //生成一节点
        Node node =new Node(data);
        node.next = head.next;
        head.next = node;
    }
    //1.找尾节点 2.插数据
    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        //循环出来后的cur就是尾节点
        while(cur.next != this.head){
            cur =cur.next;
        }
        node.next = this.head;
        //node.next = cur.next;
        cur.next = node;

    }

    private void checkIndex(int index) {
        //getLength不算头节点
        if (index < 0 || index > getLength()) {
            throw new IndexOutOfBoundsException("索引越界");
        }
    }

    @Override
    public boolean addIndex(int index, int data) {
        Node node = new Node(data);
        checkIndex(index);
        Node cur = this.head;
        //1.从head开始走，走到index的前一个位置，可以走index步
        for (int step = 0; step < index; step++) {
            cur = cur.next;
        }
        //2.插数据
        node.next = cur.next;
        cur.next =node;

        return true;
    }

    @Override
    public boolean contains(int key) {
        //1.从有data的数据开始找key
        Node cur = this.head.next;
        while(cur != this.head) {
            //找到
            if (cur.data == key){
                return true;
            }
            //没找到
            cur = cur.next;
        }
        //走完链表都没找到
        return false;
    }

    private Node searchPreKey(int key) {
        Node pre = this.head;
        //链表不是只有头节点，才开始循环
        while(pre.next != this.head) {
            if (pre.next.data == key) {
                return pre;
            }
            pre = pre.next;
        }
        return null;
    }
    //1.找key的前一个节点
    @Override
    public int remove(int key) {
        //拿到前驱
        Node pre = searchPreKey(key);
        if(pre == null) {
            throw new UnsupportedOperationException("key不存在");
        }
        int oldData = 0;
        Node delNode = pre.next;
        oldData =delNode.data;
        pre.next =delNode.next;

        return oldData;
    }

    @Override
    public void removeAllKey(int key) {
        Node pre = this.head;
        Node cur = this.head.next;
        //while(cur.next != this.head) {  这样如果head后只有一个节点，这个节点将不会被比较
        while(cur != this.head) {
            if (cur.data ==key){
                pre.next =cur.next;
                cur =pre.next;
            }
            pre =cur;
            cur = cur.next;
        }
    }

    //length指的是数据节点的个数
    @Override
    public int getLength() {
        Node cur = this.head.next;
        int count = 0;
        //不是空链表
        while(cur != this.head){
            count++;
            cur =cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head.next;
        while (cur !=this.head){
            System.out.print(cur.data + " ");
            cur =cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        while (this.head.next !=this.head) {
            Node cur = this.head.next;
            this.head.next =cur.next;
        }


    }
}
