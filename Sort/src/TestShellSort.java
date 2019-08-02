/**
 *
 */

/**
 * @auther SNAYi
 *@describe  希尔排序
 * @date 2019/5/19 下午 08:02
 */


public class TestShellSort {
    public static void main(String[] args) {
        int[] array =new int[]{1,5,7,9,2,4,3,8};
        //int[] array =SortHelper.generateArray(10000,0,100000);
        shellSort(array);
        SortHelper.printArray(array);

    }
/*    public static void shellSort(int[] array) {
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
    }*/

    /**
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     * 稳定性：是
     * shell排序是插入排序的优化，采用分组思想，不再是把数据一个一个比较
     */
    public static void shellSort(int[] array) {
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
    }
}
