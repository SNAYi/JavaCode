package prigramming;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/28 下午 03:44
 */



import java.util.*;
public class Title2{
    public static void iSort(int[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        }
        int step = n/2;
        int value = 0;
        while (step >= 1) {
            for (int i = 1; i <n; i++) {    //1.待排序空间的第一数
                value = array[i];
                int j = i-step;    //2.已排序区间最后一个数
                for (; j >= 0; j-=step) {
                    if (value < array[j]) {    //升序
                        array[j + step] = array[j];
                    } else {    //比已排序区间的最后一个数还小
                        break;
                    }
                }
                array[j + step] = value;
            }
            step /= 2;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] temp = str.split(" ");

        int[] data = new int[temp.length-1];
        //将所有数据全部放进了整形数组里
        for(int i = 0;i < temp.length - 1;i++) {
            data[i] = Integer.valueOf(temp[i]);
        }

        int k = Integer.valueOf(temp[temp.length - 1]);    //取到要输出的K个数
        iSort(data);
        for (int i = 0; i < k; i++) {
            System.out.print(data[i]+ " ");
        }
    }
}