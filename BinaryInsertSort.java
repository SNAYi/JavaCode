/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/19 下午 06:12
 */


public class BinaryInsertSort {
    public static void main(String[] args) {
       int[] array = SortHelper.generateArray(10000,0,100000);
       //int[] array = new int[]{1,5,7,9,8,2,4,3};
       //SortHelper.printArray(array);
       binaryInsertSort(array);
       SortHelper.printArray(array);
    }

    public static void binaryInsertSort(int[] array) {
        long start = System.currentTimeMillis();
        int n = array.length;
        if (n <= 1) {
            return;
        } else {
            int temp = 0;
            for (int i = 1; i < n; i++) {
                temp = array[i];    //当前待比较的数
                int low = 0;    //已排序区间的第一个数下标
                int high = i-1;    //已排序区间的最后一个数下标
                int j = i - 1;    //
                while (low <= high) {
                    int mid = (high + low) /2;
                    if (temp > array[mid]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                //已找到插入位置high + 1 1)将数据搬移2)插入数据
                for (; j >= high + 1; j--) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = temp;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("binary insert sort cost:"+(end - start)+"mS");
    }
}
