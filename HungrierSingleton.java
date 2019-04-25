/**
 * 单例：一个类只有一个实例化对象
 * 1.构造方法私有
 * 2.提供一个静态方法用于返回对象
 * 3.多次调用静态方法返回的对象必须是同一个
 * 4.定义一个静态的属性对象表示当前类的对象
 */
public class HungrierSingleton {
    public static void main(String[] args) {
        SingletionA singletionA = null;
        singletionA = singletionA.getInstance();
        singletionA.print();
    }
}

/**
 * 恶汉式单例：立即初始化
 */
class SingletionA{
    public static final SingletionA INSTANCE = new SingletionA();
    private SingletionA() { }
    public static SingletionA getInstance() {
        return INSTANCE;
    }
    public void print(){
        System.out.println("hello A");
    }
}