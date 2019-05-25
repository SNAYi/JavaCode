package com.deng.choose; /**
 *
 */

import java.util.Stack;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/25 下午 06:19
 */


public class Title10 {
        String str = new String("good");
        char[]ch = {'a','b','c'};

        public static void main(String args[]){
            Title10 ex=new Title10();
            ex.change(ex.str,ex.ch);
            System.out.print(ex.str+" and ");
            System.out.print(ex.ch);
        }

        public void change(String str, char ch[]){
            str="test ok";
            ch[0]='g';
            Stack stack =new Stack();
        }
}
