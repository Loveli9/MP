package com.hyp.spring_study.spring_bean;

import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name;
    private Integer age;
    private Character sex;

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

    public char getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public Person(String name, Integer age, Character sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    protected Person(String name) {
        this.name = name;
    }
    private Person(Integer age, Character sex) {
        this.age = age;
        this.sex = sex;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    private String hi(String name) {
        System.out.println("进入到Person 的 hi(Strng name) 方法...");
        return "Hello World！";
    }

    public String hello(String name) {
        System.out.println("进入到Person 的 hello(String name) 方法...");
        return "Hello World！" + name;
    }

}
