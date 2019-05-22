package com.deng.choose;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/22 下午 06:38
 */


public class Title2 {
    public static boolean isAdmin(String userld) {
        return userld.toLowerCase() == "admin";
    }

    /**
     * String类的toLowerCase()有返回值，为一个String对象。对象与字符串常量用== 比，自然不等。
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isAdmin("Admin"));
    }
}
