/**
 * @Author: snayi
 * @CreateTime: 2019-08-03 23:40
 * @Description:
 */
public class MergeSort2 {
    public static void main(String[] args) {
        //int[] data = SortHelper.generateArray(100000,10000,1000000);
        int[] data = new int[]{1,5,7,9,8,2,4,3};
        mergeFun(data);
        SortHelper.printArray(data);
    }

    public static void mergeFun(int[] array) {
        int n = array.length;
        //序列只有一个值，不需要排序
        if (n <=1) {
            return;
        }
        int mid = n / 2;
        mergeFun(array,0,n-1);
    }
    /**
     * 递归实现对数组进行归并排序。传入数组和其起点，终点下标
     * @param array
     * @param left 数组第一个数下标
     * @param right 数组最后一个数下标
     */
    public static void mergeFun(int[] array,int left,int right) {
        int n = array.length;
        //递归出口
        if (left >= right)
            return;
        int minIndex = (left + right) / 2;
        //先拆分
        //当前序列的前半部分
        mergeFun(array,left,minIndex);
        //当前序列的后半部分
        mergeFun(array,minIndex+1,right);
        //再合并
        combine(array,left,minIndex,right);

    }

    /**
     * 将拆分完成的数组排序并合并
     * 采用一个临时数组temp 然后用两个指针i j分别指向需要合并的两个数组的头。
     * 对两个数组进行比较。然后将较小的放入temp里。最后给array重新赋值为temp
     * @param array
     * @param left
     * @param midIndex
     * @param right
     */
    private static void combine(int[] array,int left,int midIndex,int right) {
        int i = left;
        int j = midIndex+1;
        int[] temp = new int[right+1-left];
        int k = 0;
        //保证指针不会跑出去,且两部分都还有数据
        while (i <= midIndex && j <=right) {
            //l-midIndex的数组优先
            if (array[i] <= array[j]) {
                temp[k++] = array[i];
                i++;
            } else {
                temp[k++] = array[j];
                k++;
            }
        }
        //将剩余的数据放入temp中
        while (i <= midIndex) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }
        //更新array排序
        for (int m = 0; m <= right-left ; m++) {
            array[left+m] = temp[m];
        }

    }
}
