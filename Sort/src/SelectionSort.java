/**
 * @auther SNAYi
 *@describe 选择排序
 * @date 2019/5/26 上午 10:15
 */

/**
 * 从未排序区间中找到最小值
 * 1.当前数和它之后的数比较。最后一个值没有之后数 确定要当前数的个数
 * 2.比较     比较完之后不交换数据，只改变索引指向。
 */
public class SelectionSort {
    public static void selectSort(int[] array) {
        long start = System.currentTimeMillis();
        int n = array.length;
        if (n <= 1) {
            return;
        } else {
            //1.
            //当前的i号值对应的元素是要的后面的元素交换的，如果i < n 会存在越界情况
            for (int i = 0; i < n-1; i++) {
                int minIndex = i;   //默认最小值下标为当前i
                //2.
                for (int j = i + 1; j < n; j++) {
                    if (array[j] < array[minIndex]) {
                        minIndex = j;   //将minIndex指向当前待排序区间的最小值下标
                    }
                }
                //将最小值交换去最前面已排序区间
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Selection sort cost"+(end -start)+"mS");
    }

    public static void main(String[] args) {
        int[] array = SortHelper.generateArray(10000,0,100000);
        selectSort(array);
    }
}
