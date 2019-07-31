package heap;

import java.util.Random;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-25 18:54
 * @Description: 原地堆排序
 */
public class HeapSort {
    //将数组变成堆
    public static void heapSort1(Integer[] arr) {
        Heap<Integer> heap = new Heap<>(arr);
        //从最后一个位置开始
        //降序变升序
        for (int i = arr.length-1; i >= 0; i--) {
            arr[i] = heap.extractMax();
        }
    }

    /**
     * 原地堆排序，空间复杂度为O(1)
     * @param arr
     */
    public static void heapSort2(Integer[] arr) {
        int length = arr.length;
        //1.arr->堆
        //从最后一个非叶子节点开始到根节点，逐一调整
        for (int i = (length-1-1)/2; i >= 0; i--) {
            //从第一个非叶子节点开始调整，直到根节点
            siftDown(arr,length,i);
        }
        //2.依次将最大值换到数组末尾 ,变成小根堆
        for (int i = length-1; i >= 0; i--) {
            swap(arr,0,i);
            siftDown(arr,i,0);
        }
    }
    private static void swap(Integer[] arr,int indexA,int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

    /**
     * 下沉
     * @param arr   需要调整的数组
     * @param n 本次需要调整的个数
     * @param k 本次调整的根节点
     */
    private static void siftDown(Integer[] arr,int n,int k) {
        while ((k*2+1) < n) {   //当前非叶子节点的左节点还在堆内
            int j = k*2+1;  //当前非叶子节点的左子树节点下标
            if (j+1 < n) {  //当前非叶子节点也有右子树节点
                if (arr[j].compareTo(arr[j+1]) < 0) {   //右子树的值大于左子树的值
                    j++;    //将j指向右子树
                }
            }
            if (arr[k] > arr[j]) {  //根节点值大于子树值
                break;
            }
            //否则需要交换
            swap(arr,k,j);
            //交换完之后继续在新位置比较k和新的子节点
            k = j;
        }
    }

    public static void main(String[] args) {
        int n = 100;
        Integer[] arr = new Integer[n];
        Random random = new Random();
        //时间复杂度 O(nlogn)
        for (int i = 0; i < n; i++) {       //n
            arr[i] = random.nextInt(1000);     //logn
        }
        heapSort2(arr);
        for (int i:arr) {
            System.out.print(i+" ");
        }
    }
}
