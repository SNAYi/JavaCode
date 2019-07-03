import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Teacher implements Serializable {
    private String name;
    private String job;

    public Teacher(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}

class Student implements Serializable {
    private String name;
    private Integer age;
    private Teacher teacher;
    public Student(String name, Integer age,Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", teacher=" + teacher +
                '}';
    }
}
public class CloneTest {
    public static void main(String[] args) throws Exception{
        Teacher teacher = new Teacher("gb","Java Teacher");
        Student student = new Student("zs",20,teacher);
        //student写到内存中
        ByteOutputStream bos = new ByteOutputStream();    //拿到一块内存
        ObjectOutputStream oos = new ObjectOutputStream(bos);    //拿到输出流，传bos是为了知道输出到哪
        oos.writeObject(student);

        //内存中的student输入到程序中
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.getBytes());
        ObjectInputStream ois = new ObjectInputStream(bis);
        Student cloneStudent = (Student) ois.readObject();
        System.out.println(cloneStudent == student);
        System.out.println(cloneStudent);
        System.out.println(cloneStudent.getTeacher()==student.getTeacher());
    }
}
