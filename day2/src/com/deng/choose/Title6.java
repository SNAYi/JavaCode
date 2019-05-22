package com.deng.choose;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/22 下午 09:00
 */


public class Title6 {
    //aMethod()是个普通方法。不能拥有静态属性。
        public int aMethod(){
//            static int i = 0;
             int i = 0;
            i++;
            return i;
        }
        public static void main(String args[]){
            Title6 title6 = new Title6();
            title6.aMethod();
            int j = title6.aMethod();
            System.out.println(j);
        }
}
