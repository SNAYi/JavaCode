class Person{
    public static String test;
    private String name;
    public int age;
}

class Student extends Person {
    private String school;
    public String className;
}

public class TestReflectField {

    public static void main(String[] args) throws Exception {
        Class<Student> cls = Student.class;
        {
            Field[] fields = cls.getFields();
            for (Field field: fields) {
                System.out.println(field);
            }
        }
        System.out.println("-----------");
        {
            Field[] fields = cls.getDeclaredFields();
            for (Field field: fields) {
                System.out.println(field);
            }
        }
    }

}