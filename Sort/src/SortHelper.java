import java.util.Random;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/14 下午 03:13
 */


public class SortHelper {
    //快捷打印
    public static void printArray(int[] array) {
        for (int i: array) {
            System.out.print(i + " ");    //
        }
        System.out.println();
    }

    /**
     * 随机生成若干个元素的数组   数组区间为闭区间
     * @param n 要生成的数组长度
     * @param rangeL 数组左边界
     * @param rangeR 数组右边界
     * @return
     */
    public static int[] generateArray(int n,int rangeL,int rangeR) {
        int[] array = new int[n]; //声明数组
        if (rangeL > rangeL) {
            throw new IllegalArgumentException("范围非法");
        } else {
            for (int i = 0; i < n; i++) {
                array[i] = new Random().nextInt((rangeR - rangeL + 1) +rangeL);
            }
        }
        return array;
    }

    /**
     *
     * @param n 生成的随机数的个数
     * @param switchTimes 有序数组交换次数
     * @param range 随机下标生成范围
     * @return
     */
    public static int[] generateSortedArray(int n,int switchTimes,int range) {
        int[] result = new int[n];

        //有序数组
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }

        //交换部分数据使它近似有序
        for (int i = 0; i < switchTimes; i++) {
            //生成要交换的随机下标
            Random random = new Random();
            int a = random.nextInt(range);
            int b = random.nextInt(range);

            //交换
            int temp = result[a];
            result[a] = result[b];
            result[b] = temp;
        }
        return result;
    }
}
