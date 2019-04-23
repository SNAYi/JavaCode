class Person{
    private String name;
    private  int age;

    private Person() {
    }

    protected Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class TestReflectConstructor {
    public static void main(String[] args) throws Exception {
        //通过类名取得Class类的对象
        Class classz = Person.class;
        //取得有参构造
        Constructor constructor =classz.getConstructor(String.class,int.class);
        //实例化对象
        //相当于调用Person person = new Person("张三"，18);
        Person person = (Person) constructor.newInstance("张三",18);
        System.out.println(person);
    }
}