package heap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-25 14:28
 * @Description:    基于数组实现的二叉堆
 */
public class Heap<E> {
    //实现任意类大小比较
    private Comparator<E> comparator;
    private int size;
    private E[] elementData;
    private  static  final int DEFAULT_CAPACITY = 10;

    public Heap() {
        this(DEFAULT_CAPACITY,null);
    }

    public Heap(int initialCapacity) {
        this(initialCapacity,null);
    }
    public Heap(int initialCapacity,Comparator<E> comparator){
        this.elementData = (E[]) new Object[initialCapacity];
        this.comparator = comparator;
    }

    /**
     * 将任意数组调整成堆
     * @param arr   任意数组
     */
    public Heap(E[] arr) {
        //堆初始化
        elementData = (E[]) new Object[arr.length];
        //取到需要调整的数组
        for (int i = 0; i < elementData.length; i++) {
            elementData[i] = arr[i];
        }
        //维护size长度
        size = elementData.length;
        //从最后一个非叶子节点开始SiftDown
        for (int i = (elementData.length-1-1)/2; i >=  0; i--) {
            siftDown(i);
        }
    }

    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return this.size == 0;
    }

    public void add(E e) {
        //数组达到最大值，先扩容
        if (size == elementData.length) {
            grow();
        }
        //向数组末尾添加元素
        elementData[size++] = e;
        //上浮
        siftUp(size-1);
    }

    public E findMax() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("堆为空");
        return elementData[0];
    }
    //取得最大值
    public E extractMax() {
        E result = findMax();
        //删除最大值
        //1.交换堆顶元素与最后一个元素位置
        swap(0,size-1);
        //2.删除最后一个节点(即最大值)
        elementData[size - 1] = null;
        //3.下浮
        siftDown(0);
        return result;
    }

    /**
     * 返回替换前的堆顶元素
     * @param newValue
     * @return
     */
    public  E replace(E newValue) {
        E result = findMax();
        elementData[0] = newValue;
        siftDown(0);
        return result;
    }
    /**
     * 将当前索引对应节点下沉到对应位置
     * 终止条件：当调整到叶子节点
     * @param index
     */
    private void siftDown(int index) {
        while (leftChildIndex(index) < size) {
            //当前左孩子下标
            int j = leftChildIndex(index);
            //判断左孩子大还是右孩子
            if (j+ 1 < size ) {
                //此时有右孩子
                //右孩子值比左孩子大
                if (compare(elementData[j],elementData[j+1]) < 0)
                    j ++;
            }
            //elementData[j]一定是左右孩子最大值
            if (compare(elementData[index],elementData[j])< 0)
                break;
            swap(index,j);
            index = j;
        }
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (E e:elementData) {
            if (e != null)
            res.append(e+"、");
        }
        return res.toString();
    }

    /**
     * 调整当前节点在堆中的位置
     * @param index
     */
    private void siftUp(int index) {
        //需满足当前节点不是根节点，且当前节点值大于其父节点值
        while ((index > 0 && (compare(elementData[index],elementData[parentIndex(index)])> 0))) {
            //交换当前节点值和父节点值
            swap(index,parentIndex(index));
            index = parentIndex(index);
        }
    }

    private void swap(int indexA,int indexB) {
        E temp = elementData[indexA];
        elementData[indexA] = elementData[parentIndex(indexB)];
        elementData[parentIndex(indexB)] = temp;
    }
    /**
     * 扩容操作
     */
    private void grow() {
        int oldCapacity = elementData.length;
        //如果原来数组大小小于64：则二倍扩容，否则1.5倍扩容
        int newCapacity = oldCapacity+(oldCapacity < 64 ? oldCapacity :oldCapacity>>1);
        if (newCapacity > Integer.MAX_VALUE - 8)
            throw new IndexOutOfBoundsException("数组太大!");
        //扩容
        elementData = Arrays.copyOf(elementData,newCapacity);
    }
    /**
     * 比较两个元素的大小
     * @param o1
     * @param o2
     * @return
     */
    private int compare(E o1,E o2) {
        if (comparator == null) {
            //此时E必须为Comparable接口子类
            return ((Comparable<E>)o1).compareTo(o2);
        }
        return comparator.compare(o1,o2);
    }

    //返回当前节点的左孩子下标
    private int leftChildIndex(int index) {
        return 2*index+1;
    }
    //返回当前节点的右孩子下标
    private int rightChildIndex(int index) {
        return 2*index+2;
    }

    /**
     * 取得当前节点的父节点下标
     * @param index
     * @return
     */
    private int parentIndex(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("根节点没有父节点，无法查询");
        }
        return (index-1)/2;
    }

}
