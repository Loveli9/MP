package com.hyp.collections.collectionStudy.list;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
    }

}
