package 递归和循环;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/16 下午 02:53
 */


public class JumpFloorII {
    public static void main(String[] args) {
        System.out.println(JumpFloorII(3));

    }
    //递归
    public static int JumpFloorII(int target) {
        if (target <= 0) {
            return -1;
        }
        return (int)Math.pow(2,target - 1);
    }
    //迭代
    // 第一种做法
    public static int jumpFloor1(int target) {
        if (target <= 0) return 0;
        return (int) Math.pow(2, target - 1);
    }
    //第二种做法
    public static int jumpFloor2(int target) {
        if (target <= 0) return 0;
        if (target == 1) return 1;
        int a = 1;
        int b = 2;
        for (int i = 2; i <= target; i++) {
            b = 2 * a;
            a = b;
        }
        return b;
    }
}
