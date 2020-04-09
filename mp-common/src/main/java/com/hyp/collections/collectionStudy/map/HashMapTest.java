package com.hyp.collections.collectionStudy.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMapTest {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<>(4);
        hashMap.put("周瑜","周瑜");
        hashMap.put("曹操","曹操");
        hashMap.put("刘备","刘备");
        hashMap.put("孙权","孙权");
        hashMap.put("诸葛亮","诸葛亮");
        System.out.println(hashMap.get("周瑜"));

        for(String key : hashMap.keySet()) {
            int hashCode = key.hashCode();
            int index = hashCode % 8;
            System.out.println(String.format("%s的hashCode值是%s,index=%s",key,hashCode,index));
        }

    }

    /**
     * 直接【求余】和【按位】运算的差别验证
     */
    @Test
    public void test1() {
        long currentTimeMillis1 = System.currentTimeMillis();
        int a = 0;
        int times = 100000 * 100000;
        for (long i = 0; i < times; i++) {
            a = 9999 % 1024;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        int b = 0;
        for (long i = 0; i < times; i++) {
            b = 9999 & (1024 - 1);
        }
        long currentTimeMillis3 = System.currentTimeMillis();
        System.out.println(a + "," + b);
        System.out.println("%: " + (currentTimeMillis2 - currentTimeMillis1));
        System.out.println("&: " + (currentTimeMillis3 - currentTimeMillis2));
    }

    @Test
    public void test2() {
        long currentTimeMillis1 = System.currentTimeMillis();
        Map<String,String> map1 = new Hashtable<>();
        for(int i=0;i<1000000;i++) {
            map1.put("hyp" + i,"喜欢陈老师！");
        }
        long currentTimeMillis2 = System.currentTimeMillis();

        Map<String,String> map2 = new HashMap<>();
        for(int i=0;i<1000000;i++) {
            map2.put("hyp" + i,"爱陈老师！");
        }
        long currentTimeMillis3 = System.currentTimeMillis();
        System.out.println("HashTable耗时间：" + (currentTimeMillis2 - currentTimeMillis1));
        System.out.println("HashMap耗时间：" + (currentTimeMillis3 - currentTimeMillis2));
    }

    @Test
    public void test3() {
        int out = tableSizeFor(17);
        System.out.println(out);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
