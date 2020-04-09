package com.hyp.collections.collectionStudy.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//测试三种并发集合的读写效率
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        //HashMap不是线程安全的,通过 Collections.synchronizedMap()转换成线程安全的.
        final Map<Integer, Integer> hm = Collections.synchronizedMap(new HashMap<>());
        //HashTable内部自带同步,线程安全的.
        final Map<Integer, Integer> ht = new Hashtable<>();
        //JDK1.5之后提供的并发集合.
        final Map<Integer, Integer> chm = new ConcurrentHashMap<>();
        putMap(hm);//输出:13321
        putMap(ht);//输出:11834
        putMap(chm);//输出:8312  数据量达到一定程度之后,会比前两种快3~4倍左右.
    }

    private static void putMap(final Map<Integer, Integer> hm) {
        long begin = System.currentTimeMillis();
        for (int k = 0; k < 100; k++) {//为了让效果更明显,再循环100次.
            for (int i = 0; i < 1000; i++) {//1000条线程
                final int key = i;
                new Thread(
                        () -> {
                            for (int j = 0; j < 1000; j++) {//每条线程向其中添加1000次
                                hm.put(key, j);
                            }
                        }
                ).start();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时："+  + (end - begin));
    }

}