package com.snayi.main;

import com.snayi.dao.BeanUtils;

import java.util.Date;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/4/26 下午 10:47
 */


public class TestBeanUtils {
    public static void main(String[] args) throws IllegalAccessException {
        Teacher teacher =new Teacher();
        teacher.setName("张三");
        teacher.setSkill("物理");
        teacher.setBirthday(new Date());
        teacher.setAge(20);
        System.out.println(teacher);
        Student student = new Student();
        BeanUtils.copy(teacher,student);
        System.out.println(student);
    }
}
class Teacher{
    private String name;
    private String skill;
    private Date birthday;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                '}';
    }
}

class Student{
    private String name;
    private Integer skill;
    private Date birthday;
    private boolean gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSkill() {
        return skill;
    }

    public void setSkill(Integer skill) {
        this.skill = skill;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", skill=" + skill +
                ", birthday=" + birthday +
                ", gender=" + gender +
                '}';
    }
}
