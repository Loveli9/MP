package com.hyp.collections.collectionStudy.map;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {

    public static void main(String[] args) {
        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("C","lchenli");
        map.put("B","love");
        map.put("A","huyapeng");
        System.out.println(map);
    }

}
