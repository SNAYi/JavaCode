class MyClass<T> {
    //泛型类里的普通方法
    public T method1(T t) {
        return t;
    } 
    //泛型类例里的泛型方法
    public <E> E method2(E e) {
        return  t;
    }
}
public class TestGeneric {
    public static void main(String[] args) {
        MyClass<String> myClass = new MyClass<>();
        System.out.println(myClass.method1("呵呵呵"));
        System.out.println(myClass.method2(22223));
    }
}