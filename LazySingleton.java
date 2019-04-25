/**
 * 单例：一个类只有一个实例化对象
 * 1.构造方法私有
 * 2.提供一个静态方法用于返回对象
 * 3.多次调用静态方法返回的对象必须是同一个
 * 4.定义一个静态的属性对象表示当前类的对象
 */
public class LazySingleton {
    public static void main(String[] args) {
        SingletionB singletionB = null;
        singletionB = singletionB.getInstance();
        singletionB.print();
    }
}


/**
 * 懒汉式单例：延迟实例化对象
 */
class SingletionB{
    public static SingletionB instance;

    private SingletionB() {}

    public static SingletionB getInstance() {
        if (instance == null) {
            instance = new SingletionB();
        }
        return instance;
    }

    public void print(){
        System.out.println("hello B");
    }
}