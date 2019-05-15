/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/15 下午 09:07
 */


public class JumpFloor {
    public int JumpFloor(int target) {
        if(target ==1) {
            return 1;
        }else if(target == 2) {
            return 2;
        } else {
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }

    }
}
