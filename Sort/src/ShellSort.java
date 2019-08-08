/**
 *
 */

/**
 * @auther SNAYi
 *@describe  希尔排序
 * @date 2019/5/19 下午 08:02
 */


public class ShellSort {
    public static void main(String[] args) {
        int[] array =new int[]{1,5,7,9,2,4,3,8};
        //int[] array =SortHelper.generateArray(10000,0,100000);
        shellSort(array);
        SortHelper.printArray(array);

    }

    /**
     * 希尔排序实现
     * 是直接插入的优化。相比于直接插入。进行了预排序过程，预排序让序列变得更有序。
     * @param array
     */
    private static void shellSort(int[] array) {
        int length = array.length;
        if (length ==1)
            return;
        else {
            int step = length/2;
            while (step>=1) {
                //待排序区间的数
                for (int i = step; i < length; i++) {
                    int temp = array[i];
                    //从已排序区间最后一个数向前,下一个数取间隔为step
                    int j = i-step;
                    for (; j >= 0 ; j -= step) {
                        if (temp < array[j]) {
                            array[j + step] = array[j];
                        } else {
                            break;
                        }
                    }
                    array[j+step] = temp;
                }
                step /=2;
            }
        }
    }
    public static void shellSort2(int[] array) {
        long start = System.currentTimeMillis();
        int n = array.length;
        if (n <= 1) {
            return;
        } else {
            int step = n / 2;
            while (step >= 1) {
                for (int i = 0; i < n; i++) {
                    int temp = array[i];
                    int j = i - step;
                    for (; j >= 0; j-= step) {
                        if (array[j] > temp) {
                            array[j + step] = array[j];
                        } else {
                            break;
                        }
                    }
                    array[j + step] = temp;
                }
                step /= 2;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("the shell sort cost:" +(end - start)+"mS");
    }

    /**
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     * 稳定性：是
     * shell排序是插入排序的优化，采用分组思想，不再是把数据一个一个比较
     */

   /* public static void shellSort(int[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        } else {
            int step = n / 2;
            while (step >= 1) {
                for (int i = 1; i < n; i++) {
                    int temp = array[i];
                    int j = i - step;
                    for (; j >= 0; j-=step) {
                        if (temp < array[j]) {
                            array[j + step] = array[j];
                        } else {
                            break;
                        }
                    }
                    array[j + step] = temp;
                }
                step /=2;
            }
        }
    }*/
}
