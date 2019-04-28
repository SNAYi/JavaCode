/**
 *
 */

import java.util.Arrays;
import java.util.Random;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/4/28 下午 06:50
 */


public class selectSort {
    public static void main(String[] args) {
        int[] array = new int[1000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000) + 1;
        }
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @param array Array to be sorted
     */
    public static void selectSort(int[] array) {
        long start = System.nanoTime();//纳秒
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp =array[i];
                    array[i] = array[j];
                    array[j] = temp;
                } else {
                    break;
                }
            }
        }
        long end = System.nanoTime();
        System.out.println("使用时间" + (end - start));
    }
}
