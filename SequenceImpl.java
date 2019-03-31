package com.bit.dao;

import com.com.bit.Impl.Sequence;

import java.util.Arrays;

/**
 *
 */
public class SequenceImpl implements Sequence.ISequence {
    public  final int DEFAULT_CAPACITY=9;
    private Object[] elemData;
    private int usedSize;


    public SequenceImpl() {
    this.elemData = new Object[DEFAULT_CAPACITY];
    this.usedSize = 0;
    }

    private boolean isFull(){
        return this.usedSize ==this.elemData.length;
    }

    @Override
    public boolean add(int pos, Object data) {

        //1.判断pos合法性,放入数据后是否会发生溢出(插入要有前驱)
        if(pos < 0 || pos > this.usedSize) {
            return false;
        }

        if(isFull()) {
            //扩容
            //Arrays.CopyOf有返回值
           this.elemData = Arrays.copyOf(this.elemData, this.elemData.length*2);
        }
        //2.挪数据
        for(int i=usedSize-1; i>= pos;i--) {
           this.elemData[i+1] = this.elemData[i];
        }

        //3.放入数据 usedSize++
            //注释：ctrl+shift+/
        this.elemData[pos] =data;
        usedSize++;

        return true;
    }

    private boolean isEmpty() {
        return this.usedSize ==0;
    }

    @Override
    public int search(Object key) {
        //key 可以传null
        if(key == null) {
            throw new UnsupportedOperationException("不可以传入null作为参数");
        }

        //如果顺序表为空
        if(isEmpty()) {
            return -1;
        }
        //找顺序表里与key相等的值
        for (int i = 0; i < usedSize; i++) {
            //引用类型比大小要用equals
            if(this.elemData[i].equals(key)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object key) {
        if(key ==null) {
            //抛异常提醒
            throw new UnsupportedOperationException("不能传null");
        }
        if(isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elemData[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object getPos(int pos) {
        if(pos < 0 || pos > this.usedSize) {
            return null;
        }
        return this.elemData[pos];
    }

    @Override
    public Object remove(Object key) {
        int index = search(key);
        if(index ==-1 ) {
            return null;
        }

        //1.找key位置
/*        for (int i = 0; i <this.usedSize ; i++) {
            if(this.elemData[i].equals(key)){
                System.out.println("this.elemData[i]");
            }
        }*/
        Object oldData =this.elemData[index];
        int i =0;
        for ( i = index; i <=this.usedSize-1 ; i++) {
            this.elemData[i] =this.elemData[i + 1];
        }
        //要将顺序表最后一个数据置空
        this.elemData[i+1] = null;
        this.usedSize--;
        return null;
    }

    @Override
    public int size() {
        return this.usedSize;
    }

    @Override
    public void display() {
        for (int i = 0; i <this.usedSize; i++) {
            System.out.println(this.elemData[i] +" ");
        }
        System.out.println();
    }

    @Override
    public void clear() {
        for (int i = 0; i <this.usedSize ; i++) {
            this.elemData[i] =null;
        }
        this.usedSize = 0;
    }
}
