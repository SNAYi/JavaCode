class Person{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class TestReflectMethod {

    public static void main(String[] args) throws Exception {
/*        Person person =new Person();
        person.setName("张三");
        System.out.println(person.getName());*/
        //1.取得Class对象
        Class<Person>  cls = Person.class;
        //2.组装方法名称
        String setMethodName = "set" + initCap("a");
        String getMethodName = "get" + args[0];
        //3.取得Method对象
        Method setMethod = cls.getMethod(setMethodName,String.class);
        Method getMethod = cls.getMethod(getMethodName);
        //4.取得Person类的实例化对象，然后调用方法
        Person person = cls.newInstance();
        setMethod.invoke(person,"张三");
        System.out.println(getMethod.invoke(person));

    }
    private static String initCap(String str) {
        return str.substring(0,1).toUpperCase() + str.substring(1) ;
    }
}