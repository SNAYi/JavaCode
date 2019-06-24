/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/21 下午 02:42
 */

    class Test
    {
        private int data;    //private 的权限在本类内
        int result = 0;    //默认default的访问权限在本包内
        public void m()    //4.
        {
            result += 2;
            data += 2;
            System.out.print(result + " " + data);
        }
    }
    class ThreadExample extends Thread
    {
        private Test mv;
        public ThreadExample(Test mv)    //2.
        {
            this.mv = mv;
        }
        public void run()    //3.
        {
            synchronized(mv)    //4.
            {
                mv.m();
            }
        }
    }

    class test{

    }
    class ThreadTest {
        private static int data;
        public static void print() {
            for (int i = 0; i < 3; i++) {
                data += 1;
            }
            System.out.println(data);
        }
        public static void main(String args[])
        {
/*            Test mv = new Test();   //1.调默认构造
            Thread t1 = new ThreadExample(mv);    //2.
            Thread t2 = new ThreadExample(mv);
            Thread t3 = new ThreadExample(mv);
            t1.start();    //3.
            t2.start();
            t3.start();*/
print();

        }
    }

