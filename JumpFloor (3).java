package 递归和循环; /**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/15 下午 09:07
 */


public class JumpFloor {
    public static void main(String[] args) {
        System.out.println(JumpFloor2(-1));
    }
    public int JumpFloor(int target) {
        if(target ==1) {
            return 1;
        }else if(target == 2) {
            return 2;
        } else {
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }
    public static int JumpFloor2(int target) {
        int a = 1;
        int b = 2;
        int temp = 0;
        if (target == a) {
            return a;
        } else if (target ==b){
            return b;
        } else {
            for (int i = 3; i <= target; i++) {
                temp = a +b;
                a = b;
                b = temp;
            }
        }
        return temp;
    }
}
