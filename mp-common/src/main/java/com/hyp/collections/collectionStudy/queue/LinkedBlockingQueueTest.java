package com.hyp.collections.collectionStudy.queue;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlockingQueueTest {

    @Test
    public void test() {
        LinkedBlockingDeque<String> dueue = new LinkedBlockingDeque<>();
        dueue.addFirst("Java");
        dueue.addFirst("Scala");
    }

}
