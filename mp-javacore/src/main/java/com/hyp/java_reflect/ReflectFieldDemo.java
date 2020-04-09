package com.hyp.java_reflect;

import org.junit.Test;
import org.thymeleaf.spring5.expression.Fields;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectFieldDemo {

    @Test
    public void createObj() {

        try {
            //得到字节码文件对象
            Class clazz = Class.forName("com.hyp.java_reflect.entity.Person");
            Object obj = clazz.newInstance();
            //getField：得到指定的field，只能得到public 的field
//            Field name1 = clazz.getField("name");这个会报错，name是private的
            //getDeclaredField：得到指定的field，可以得到private 的field
            Field name = clazz.getDeclaredField("name");
            name.setAccessible(true);//暴力访问
            name.set(obj,"zhangsan");
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
