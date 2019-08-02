/**
 *
 */

/**
 * @auther SNAYi
 *@describe  冒泡排序
 * @date 2019/5/14 下午 03:01
 */


public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{4,5,6,1,2,3};
        bubbleSort(array);
        SortHelper.printArray(array);
    }
    //4 5 6 1 2 3 要求排成升序
    public static void bubbleSort(int[] array) {
        int length = array.length;
        //确定要经过几轮才能让序列变有序
        for (int i = 0; i < length; i++) {
            boolean flag = false;
            //每一轮需要比的数的个数都会减小一个，因为最后一个已经有序了
            for (int j = 0; j < length-i-1; j++) {
                //不满足升序则交换
                if (array[j] > array [j+1]) {
                    flag = true;
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            if (!flag) {
                System.out.println(i);
                break;
            }
        }

    }
  /*  public static void bubbleSort(int[] array){
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
    }*/
}


