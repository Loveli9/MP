package com.hyp.java_multi_thread.thread_sync;

import org.junit.Test;

import java.util.concurrent.*;

public class M6_CallBack {

    @Test
    public void test() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Boolean> submit = executorService.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return false;
            }
        });
        try {
            if (submit.get()) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}
