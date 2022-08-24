package com.hefu.module_mvvm.bean;

public class User {

    public String name;
    public int age;
    public boolean sex;


    public User(){}

    public User(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "{" +
                "姓名='" + name + '\'' +
                ", 年龄=" + age +
                ", 性别=" + (sex?"男":"女") +
                '}';
    }
}
