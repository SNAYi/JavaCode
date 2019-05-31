package com.deng.choose;/**
 *
 */

import java.util.ArrayList;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/30 下午 08:28
 */


public class Title8 {
    public static void main(String[] args) {
        Object obj = new Object() {
            public boolean equals(Object obj) {
                return  true;
            }
        };
        System.out.println(obj.equals("Fred"));
    }
}
