import java.util.Arrays;

/**
 * @auther SNAYi
 *@describe 归并排序
 * @date 2019/5/26 上午 11:12
 */


public class MergeSort {

    public static void mergeSort(int[] array) {
        int n = array.length;
        if (n <=1) {
            return;
        }
        int mid = n / 2;
        mergeInternal(array,0,n-1);
    }

    /**
     * 这里的low high mid指的都是下标
     * @param array
     * @param low
     * @param high
     */
    private static void mergeInternal(int[] array,int low,int high) {
        if (low >= high) {    //递归出口
            return;
        }
        int mid = (low + high) / 2;
        //1.分解为两半,递归着一直分
        mergeInternal(array,low,mid);
        mergeInternal(array,mid + 1,high);
        //2.合并 当low 和mid相遇 或者 mid + 1和high相遇
        merge(array,low,mid,high);
    }
    public static void merge(int[] array,int low,int mid,int high) {
        int i = low;
        int j = mid + 1;
        int[] temp = new int[(high+1)- low];
        int k = 0;
        //1.要合并的两部分都还有数据
        while (i <=mid && j <=high) {
            if (array[i] <= array[j]) {    // 5 6 5 7
                //第一个部分当前位置数据小
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        //2.判断哪个部分还有数据,默认第一部分还有剩下数据
        int start= i;
        int end = mid;
        //如果是第二个部分还有数据
        if (j <= high) {
            start =j;
            end =high;
        }

        //3.将剩余数据拷回临时数组
        while (start <= end) {
            temp[k++] = array[start++];
        }

        //4.将临时数组拷回array
        for (int i1 = 0; i1 <= high- low; i1++) {
            array[low + i1] = temp[i1];    //直接给是不可以的，要
        }
    }

    public static void main(String[] args) {
        //int[] data = SortHelper.generateArray(100000,10000,1000000);
        int[] data = new int[]{1,5,7,9,8,2,4,3};
        mergeSort(data);
        SortHelper.printArray(data);
    }
}
