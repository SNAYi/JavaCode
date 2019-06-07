package com.snayi.collection;/**
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/6/7 下午 09:34
 */

class Person{
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        //向下转型
        Person person = (Person)obj;

        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }
}
public class TestListBOJO {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("张三",10)) ;
        people.add(new Person("李四",11)) ;
        people.add(new Person("王五",12)) ;
        // 集合类中contains()、remove()方法需要equals()支持
        System.out.println(people.remove(new Person("李四",11)) );;
        System.out.println(people.contains(new Person("王五",12)));
    }
}
