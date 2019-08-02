/**
 *
 */

/**
 * @auther SNAYi
 *@describe 二分插入排序
 * @date 2019/5/19 下午 06:12
 */


public class BinaryInsertSort {
    public static void main(String[] args) {
       //int[] array = SortHelper.generateArray(10000,0,100000);
       int[] array = new int[]{1,5,7,9,8,2,4,3};
       SortHelper.printArray(array);
       binaryInsertSort(array);
       SortHelper.printArray(array);
    }

/*    public static void binaryInsertSort(int[] array) {
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
    }*/

    /**
     * 折半插入查找，基于二分查找
     *
     */
    public static void binaryInsertSort(int[] array) {
        int length = array.length;
        //需排序元素个数
        for (int i = 1; i < length; i++) {
            int temp = array[i];
            //已排序区间最后一个数开始，向前
            int low = 0;
            int high = i-1;
            //缩小区域，找到合适插入位置
            while (low <= high) {
                int mid = (high+low)/2;
                //缩小比较区域
                if (array[i] > array[mid]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
            //数据搬移
            for (int j = i-1; j >= 0; j--) {
                if (j >=high+1) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[high+1] = temp;
        }
    }
  /*  public static void binaryInsertSort(int[] array) {
        long start = System.currentTimeMillis();
        int n = array.length;
        if (n <= 1) {    //如果数据集只有1/0个数据，就不参与排序
            return;
        } else {
            //1.待排序的数据个数
            for (int i = 1; i < n; i++) {
                int temp = array[i];
                int low = 0;    //已排序区间的第一个数据下标
                int high = i -1;    //已排序区间的最后一个数据下标
                int j = i - 1;    //已排序区间的最后一个数据下标
                //2.折半查找
                while (low <= high) {    //可能会有相等情况，需注意
                    int mid = (low + high) /2;    //已排序区间的中间数据下标
                    if (temp > array[mid]) {    //待排序值大于中间值
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                //3.找到当前待排序数据应插入的位置high + 1
                for (; j >= high + 1; j--) {
                    array[j + 1] = array[j];    //数据后移挪位置
                }
                array[high + 1] = temp;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("binary insert sort cost:"+(end - start)+"mS");
    }*/

}
