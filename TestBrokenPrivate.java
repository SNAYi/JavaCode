class Person{
    private int age;
}

public class TestBrokenPrivate {
    public static void main(String[] args) throws Exception {
        //取得类对象
        Class<Person> cls = Person.class;
        //取得属性对象,因为age是私有的，所以getField()获取不到
        Field field = cls.getDeclaredField("age");
        //取得实例化对象
        Person person = cls.newInstance();
        //动态破坏封装
        field.setAccessible(true);
        field.set(person,20);
        System.out.println(field.get(person));
    }
}