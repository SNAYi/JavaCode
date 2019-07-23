/**
 * @Author: snayi
 * @CreateTime: 2019-07-23 20:32
 * @Description: 接口的多继承
 */
interface A{
    void playA();
}
interface B{
    void playB();
}
//接口多继承
interface C extends A,B{
    void playC();
}

public class TestDemo2 implements C{
    @Override
    public void playA() {
        System.out.println("A");
    }

    @Override
    public void playB() {
        System.out.println("B");
    }

    @Override
    public void playC() {
        System.out.println("C");
    }

    public static void main(String[] args) {
        TestDemo2 testDemo2 =new TestDemo2();
        testDemo2.playA();
        testDemo2.playB();
        testDemo2.playC();
    }
}
