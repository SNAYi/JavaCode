package 递归和循环;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/16 下午 04:17
 */

//我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
// 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
public class RectangleCover {
    public static void main(String[] args) {
        System.out.println(RectCover(5));
    }
    public static int RectCover(int target) {
        if (target <= 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            //要处理好target==0 的情况，要不然会影响整个递归
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }
}
