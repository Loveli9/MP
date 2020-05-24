package com.hyp.java_multi_thread.threadPool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCalculator {

    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
//            Thread.sleep(1000);
            return input * input;
        });
    }

    public static void main(String[] args) {

    }

    @Test
    public void test1() {
        SquareCalculator squareCalculator = new SquareCalculator();
        try {
            for(int i=1;i<=10;i++) {
                Future<Integer> out = squareCalculator.calculate(i);
                System.out.println("结果" + i + "===" + out.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
