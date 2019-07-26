/*
import java.util.Arrays;

*/

import java.util.Arrays;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-26 22:21
 * @Description:    基于数组实现的顺序表
 */
public class SequenceImpl implements Sequence {
    //首先得有一个顺序表
    private Object[] elemData;
    private  int usedsize;

    private static final int DEFAULT_CAPACITY = 10;
    //通过构造器初始化成员属性
    public SequenceImpl() {
        this.elemData = new Object[DEFAULT_CAPACITY];
        this.usedsize = 0;
    }

    @Override
    //在pos位置插入data
    public boolean add(int pos, Object data) {
        //1.判断pos合法性，放入数据后，是否会溢出
        if (pos < 0 || pos > this.usedsize ) {
            return false;
        }

        //溢出则扩容   Arrays.copyOf(要扩容的数组，扩容之后的长度) 有返回值，按Ctrl然后点击跳转
        if (isFull()) {
            this.elemData = Arrays.copyOf(this.elemData,this.elemData.length * 2);
        }
        //2.诺数据
        for (int i = this.usedsize -1; i >= pos ; i--) {
            this.elemData[i + 1] = this.elemData[i];
        }
        //3.放入数据，usedsize++
        this.elemData[pos] = data;
        this.usedsize++;
        return true;
    }
    //判断顺序表满了是否溢出
    private boolean isFull() {
        return this.usedsize == this.elemData.length;
    }

    @Override
    //查找关键字key,找到第一个就返回找到返回key的下标，没有返回-1;
    public int search(Object key)
    {
        //1.判断数据合法性
        if (key == null){
            throw new UnsupportedOperationException("不可以作为null作为参数");
        }
        //1.1 如果顺序表为空
        if (this.usedsize == 0) {
            return -1;
        }
        //2.找数据
        for (int i = 0; i <this.usedsize ; i++) {
            //！！！引用数据类型比较
            if (this.elemData[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    //查找是否包含关键字key是否在顺序表当中(这个和search有点冲突)
    public boolean contains(Object key) {
        //1.判断数据合法性
        if (key == null){
            throw new UnsupportedOperationException("不可以作为null作为参数");
        }
        //1.1 如果顺序表为空
        if (this.usedsize == 0) {
            return false;
        }
        for (int i = 0; i <this.usedsize ; i++) {
            //！！！引用数据类型比较
            if (this.elemData[i].equals(key)) {
                return true;
            }
        }
        //前面都没有跳出，就证明找不到
        return false;
    }

    @Override
    //得到pos位置的值
    public Object getPos(int pos) {
        if (pos < 0 ||pos > this.usedsize) {
            return null;
        }
        return this.elemData[pos];
    }

    @Override
    //删除第一次出现的关键字key
    public Object remove(Object key) {
        //1.判断是否有关键字，
        int index = search(key);
        if(index == -1) {
            return null;
        }
        //有返回值，删除前先保存要删除的值
        Object oldData =this.elemData[index];
        //int i = 0;
        for (int i = index; i <this.usedsize - 1 ; i++) {
            this.elemData[i] = this.elemData[i+1];
        }
        //最后一位要置空，好被回收
        this.elemData[usedsize - 1] =null;
        //i走出for循环的时候是this.usedsize - 1
        //this.elemData[i + 1] = null;
        this.usedsize--;
        return oldData;
    }

    @Override
    //得到顺序表的长度
    public int size() {
        return this.usedsize;
    }

    @Override
    //打印顺序表
    public void display() {
        for (int i = 0; i <this.usedsize ; i++) {
            System.out.print(this.elemData[i] + " ");
        }
        System.out.println();
    }

    @Override
    //清空顺序表以防内存泄漏
    public void clear() {
        for (int i = 0; i <this.usedsize; i++) {
            this.elemData[i] = null;
        }
        this.usedsize = 0;
    }
}