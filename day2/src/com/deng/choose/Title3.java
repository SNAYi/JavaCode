package com.deng.choose; /**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/22 下午 06:18
 */

class Test {
    public static void hello() {
        System.out.println("hello");
    }
}

/**
 * 因为hello()是静态方法。且test变量类型是Test，所以可以调用。
 * 如果是hello()普通方法执行test.hello(); 会有空指针异常。
 */
public class Title3 {
    public static void main(String[] args) {
        Test test = null;
        test.hello();
    }
}