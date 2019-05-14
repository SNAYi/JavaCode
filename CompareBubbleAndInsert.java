/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/14 下午 05:18
 */


public class CompareBubbleAndInsert {
    public static void main(String[] args) {
        int[] data = SortHelper.generateArray(100000,10000,1000000);
        int[] data2 = SortHelper.generateArray(100000,10000,1000000);
        bubbleSort(data);
        insertSort(data2);
    }
    public static void insertSort(int[] array){
        long start = System.currentTimeMillis();
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
        long end = System.currentTimeMillis();
        System.out.println("直接插入排序耗时"+(end - start) +"mS");
    }
    public static void bubbleSort(int[] array){
        long start = System.currentTimeMillis();
        //1.判断是否有排序必要
        int n = array.length;
        if (n <= 1) {
            return;    //return在返回值为空的方法里作用为结束方法
        } else {
            //控制排序次数
            //一次排序只能让一个数据到达最终位置
            for (int i = 0; i < n; i++) {
                boolean flag = false;   //优化
                for (int j = 0; j < n - i - 1; j++) {    //j < n - i - 1否则交换数据是可能会越界
                    if (array[j] > array[j + 1]) {    //降序则交换
                        flag = true;
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
                if (!flag) {    //flag没有变化，表明一次循环完了都没有交换，则认为有序
                    System.out.println("序列在第"+i+"次遍历完已经有序");
                    break;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("冒泡排序耗时"+(end - start) +"mS");
    }
}
