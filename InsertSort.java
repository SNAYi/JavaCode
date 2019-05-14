/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/14 下午 04:24
 */

/**
 * 分两个区间：已排序区间，待排序区间
 * 用已排序区间的最后一个数和待排序区间的第一个数开始比
 * 当前待比较的数需要存放在一个临时变量上，比较时也用这个临时变量比
 * 默认第一个元素属于已排序区间
 *
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = new int[]{4,5,6,1,3,2};
        System.out.print("未排序数组：");
        SortHelper.printArray(array);
        insertSort(array);
        System.out.print("排序后数组：");
        SortHelper.printArray(array);
    }
    //1 3 5 7

    /**
     * 1 3 5 7
     * @param array
     */
    public static void insertSort(int[] array){
        int n = array.length;
        if (n <= 1) {
            return;
        } else {
            int value = 0;    //给一会要待排序的数作为临时存放点
            //确定'待排序'的数,第一个数已经有序，属于已排序空间
            for (int i = 1; i < n; i++) {
                //待排序空间的第一个数
                value = array[i];
                //已排序集合的最后一个数
                int j = i - 1;
                //寻找要插入的位置，从i- 1 开始找，往前遍历
                for (; j >= 0; j--) {
                    if (array[j] > value) {    //这里要用临时存放点的数据比，否则连续比较会出错
                         array[j + 1] = array[j];    //array[j]后移
                    } else {    //将其位置不动，归属到已排序空间
                        break;
                    }
                }
                //找到要插入的位置,并将本次待排序的数插入
                array[j + 1] = value;
            }
        }
    }
}
