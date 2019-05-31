package com.deng.programming;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/31 下午 02:53
 */

import java.util.*;
public class Title2 {


        public int countWays(int x, int y) {
            //1.出口，只有一行或者一列
            if (x==1 || y==1) {
                return 1;
            } else {
                //2.两种走法:向右走或者向下走
                return countWays(x,y-1)+ countWays(x-1,y);
            }
        }
}
