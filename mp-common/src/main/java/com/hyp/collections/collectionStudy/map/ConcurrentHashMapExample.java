package com.hyp.collections.collectionStudy.map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

    public static void main(String[] args) {

        ConcurrentHashMap<String,Object> map = new ConcurrentHashMap<>(31);
        map.put("C","huyp");
        map.put("A","love");
        map.put("B","cl");
        System.out.println(map);
        System.out.println(map.get("A"));
        map.clear();
    }

}
