package com.hyp.java_reflect;

import org.junit.Test;
import java.lang.reflect.Method;

public class ReflectFunctionDemo {

    @Test
    public void createObj() {

        try {
            //得到字节码文件对象
            Class clazz = Class.forName("com.hyp.java_reflect.entity.Person");
            //得到字节码文件对象中的所有Method对象
            //clazz.getMethods()：得到类所有的公共public修饰的的Method方法（括继承自Object对象中的所有方法）
            //clazz.getDeclaredMethods()：得到当前类的所有的Method方法
            for(Method method : clazz.getDeclaredMethods()) {
                System.out.println(method);
            }
            //得到特定的方法，调用方法
            Method method1 = clazz.getMethod("hello",String.class);
            System.out.println("method = " + method1);
            //字节码文件对象为咱们提供了一个便捷创建对象的方法
            Object obj = clazz.newInstance();//底层是调用类的无参构造器
            //反射调用方法 方法.invoke(对象，实参)
            Object outObj1 = method1.invoke(obj,"大妞");
            System.out.println(outObj1.toString());
            //注意：访问私有方法，需要getDeclaredMethod之后再setAccessible(true);
            Method method2 = clazz.getDeclaredMethod("hi",String.class);
            method2.setAccessible(true);
            Object outObj2 = method2.invoke(obj,"大嫂");
            System.out.println(outObj2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
