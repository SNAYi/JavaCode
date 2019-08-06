/**
 * @Author: snayi
 * @CreateTime: 2019-08-05 15:11
 * @Description:
 */
public class QuickSort {
    public static void quickInternal(int[] array) {
        int n = array.length;
        if (n <=1) {
            return;
        }
        quickInternal(array,0,n-1);
    }

    /**
     *  快排的递归实现
     * @param array
     * @param low 数组第一个元素下标
     * @param high 数组最后一个元素下标
     */
    public static void quickInternal(int[] array,int low,int high) {
        //递归出口
        if (low >= high) {
            return;
        }
        //获取分区点

        int pivot = partition2(array,low,high);
        //分区快排
        quickInternal(array,low,pivot-1);
        quickInternal(array,pivot+1,high);
    }

    /**
     * 获得数组分区点
     * @param array 带排序数组
     * @param low   数组开始点下标
     * @param high  数组结束点下标
     * @return  数组分区点
     */
    public static int partition(int[] array,int low,int high) {
        //默认数组分区点为当前数组第一个元素,将其值保存下来
        int pivot = array[low];
        //小于分区点的最后一个值下标
        int j = low;
        //使用下标i遍历整个数组的值
        for (int i = low+1; i <= high ; i++) {
            //当前值小于分区点值
            if (array[i] < pivot) {
                //将当前值和j+1位置的值交换。让小于分区点的值增加一个
                swap(array,j+1,i);
                //小于分区点的值多了一个，j后移
                j++;
            }
        }
        //交换分区点的值，使其处在中间位置
        swap(array,low,j);
        //返回分区点下标
        return j;
    }

    /**
     * 两路快排
     * @param array
     * @param low
     * @param high
     */
    public static int partition2(int[] array,int low,int high) {
        //取数组中任意一个值的下标作为分区点
        int pivotIndex = (int) (Math.random()*(high-low+1)+low);
        //将分区点值交换到数组最前
        swap(array,low,pivotIndex);
        //将分区点值保存下来
        int pivot = array[low];
        //i用来记录小于array[pivotIndex]的值下标
        //j用来记录大于array[pivotIndex]的值下标
        int i = low+1;
        int j = high;
        while (true) {
            //当前值没有右出边界且当前值小于pivot,小于分区后移扩大
            while (i <= high && array[i] < pivot) {
                i++;
            }
            //当前值没有左出边界且当前值大于pivot,大于分区前移扩大
            while (j >= low + 1 && array[j] > pivot) {
                j--;
            }
            //可以停止排序，跳出死循环
            if (i > j) {
                break;
            }
            //i遇到大于pivot的值，j遇到小于pivot的值，交换
            swap(array,i,j);
            //也需要扩大分区
            i++;
            j--;
        }
        //将分区点的值交换到应去的位置j
        swap(array,low,j);
        return j;
    }
    public static void swap(int[] array,int x,int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
    public static void main(String[] args) {
        int[] array = new int[]{8,10,2,3,6,1,5};
        System.out.println("快排前的数组");
        SortHelper.printArray(array);
        System.out.println("快排后的数组");
        quickInternal(array);
        SortHelper.printArray(array);

    }
}
