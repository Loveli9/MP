package com.hyp.java_reflect;

import com.hyp.java_reflect.entity.Person;
import org.junit.Test;
import java.lang.reflect.Constructor;

public class ReflectConstructorDemo {

    @Test
    public void createObj() {

        try {
            //得到字节码文件对象
            Class clazz = Class.forName("com.hyp.java_reflect.entity.Person");//这才是反射存在的意义
            //方式一
            //该方法只要传入一个字符串类名，程序可以根据该类名生成Java对象
            Person person1 = (Person)clazz.newInstance();
            person1.setSex('男');
            person1.setName("hyp");
            person1.setAge(10);
            System.out.println(person1);
            //方式二
            Person person2 = Person.class.newInstance();
            person2.setName("huyp");
            person2.setAge(26);
            person2.setSex('男');
            System.out.println(person2);
            //方式三
            //clazz.getConstructor：得到单独的指定的构造器（必须是public修饰的）
            //clazz.getDeclaredConstructor：得到单独的指定的构造器（不管修饰符），但是私有的构造器不能访问，必须保利访问
//            Constructor privateConstructor = clazz.getDeclaredConstructor(String.class);
//            privateConstructor.setAccessible(true);//暴力访问
//            Object privatePerson = privateConstructor.newInstance("陈丽");
//            System.out.println(privatePerson);
            Constructor constructor = clazz.getConstructor(String.class,Integer.class,Character.class);
            Object person3 = constructor.newInstance("胡亚鹏",26,'男');
            System.out.println(person3);
            //clazz.getConstructors() ： 得到字节码中的构造器对象【公共构造器，public修饰的】
            //clazz.getDeclaredConstructors() ： 得到字节码中的构造器对象【所有的构造器，不管修饰符】
            for(Constructor con : clazz.getDeclaredConstructors()) {
                System.out.println(con);
            }
            Object chenli = clazz.getConstructors()[0].newInstance("陈丽",25,'女');
            Object nullperson = clazz.getConstructors()[1].newInstance();
            System.out.println(chenli);
            System.out.println(nullperson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
