package heap;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-25 15:53
 * @Description:
 */
public class HeapTest {
    public static void main(String[] args) {
        int[] nums = new int[]{62,41,30,28,16,22,13,19,17,15};
        Heap<Integer> heap = new Heap<>();
        for (int i:nums)
            heap.add(i);
        System.out.println(heap.replace(20));
        System.out.println(heap.findMax());
        System.out.println(heap);
    }
}
