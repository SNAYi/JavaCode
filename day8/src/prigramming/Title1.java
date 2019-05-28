package prigramming;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/27 下午 10:51
 */



import java.util.*;
public class Title1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();

        boolean[] data = null;
        //1.设置好数组长度
        if(n <= 1000) {    //数组长度小于1000
            data = new boolean[n];
        } else {    //数组长度大于1000
            data = new boolean[999];
        }

        //2.设置当前这么多数都是在圈内,状态为true
        for(int i = 0;i < n;i++) {
            data[i] = true;
        }
        int index = -1;    //每个数的下标，初始为-1,第一个数下标为0
        int disIn = 0;    //退圈的数的个数，初始为0
        int cIndex = 0;    //每个数在循环之中的下标，下标为1.2留下，3退出

        while(disIn < n-1){    //3.只能有n-1个数退圈
            index = (index + 1)% n;    //4.让数组成环
            if(data[index] == false) {    //状态已经为不在圈内
                continue;
            }

            cIndex = (cIndex + 1) % 3;    //1%3.2%3.3%3
            if(cIndex == 0) {    //第三个数则退圈
                data[index] = false;
                disIn++;
            }
        }
        //5.找出状态还为true的那个下标
        int i = 0;
        for(;i < n;i++) {
            if(data[i]) {
                break;
            }
        }
        System.out.println(i);
    }
}
