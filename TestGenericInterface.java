interface IInterface<T> {
    T test(T t);
}
//1.子类实现接口时继续保留泛型
//class InterfaceImpl<T> implements IInterface<T>{
//    @Override
//    public T test(T t) {
//        return t;
//    }
//}
//2.子类实现接口时就确定好类型
class InterfaceImpl implements IInterface<String>{

    @Override
    public String test(String s) {
        return s;
    }
}
public class TestGenericInterface {
    public static void main(String[] args) {
     // 1.IInterface<String> iInterface = new InterfaceImpl<>();
      IInterface iInterface = new InterfaceImpl();
        System.out.println( iInterface.test("hiusi"));
    }
}