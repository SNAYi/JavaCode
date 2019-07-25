package heap;

import java.util.Random;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-25 18:54
 * @Description:
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
    public static void heapSort2(Integer[] arr) {
        //1.arr->堆

    }

    public static void main(String[] args) {
        int n = 100;
        Integer[] arr = new Integer[n];
        Random random = new Random();
        //时间复杂度 O(nlogn)
        for (int i = 0; i < n; i++) {       //n
            arr[i] = random.nextInt(10000);     //logn
        }
        heapSort1(arr);
        for (int i:arr) {
            System.out.print(i+" ");
        }
    }
}
