package com.deng.thread;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/31 下午 09:14
 */

class Goods{
    private String goodName;
    private int count;

    public Goods(String goodName, int count) {
        this.goodName = goodName;
        this.count = count;
    }

    //生产
    public synchronized void set(String goodName){
        this.goodName = goodName;
        count++;
        System.out.println(Thread.currentThread().getName()+"生产一个："+this);
    }
    //消费
    public synchronized void get(){
        count--;
        System.out.println(Thread.currentThread().getName()+"消费"+this);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodName='" + goodName + '\'' +
                ", count=" + count +
                '}';
    }
}
class Producter implements Runnable{
    Goods goods;

    public Producter(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        goods.set("小黑瓶");
    }
}

class Consumer implements Runnable{
    Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        goods.get();
    }
}

public class CPTest {
    public static void main(String[] args) {
        Goods goods =
    }
}
