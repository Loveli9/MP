package com.hyp.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestJava8 {

    public static void main(String[] args){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        //定义格式化的对象
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");

        Callable<LocalDate> callable = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                //调用LocalDate.parse方法并传入格式化对象即可
                return LocalDate.parse("20181012",dtf);
            };
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<LocalDate>> LocalDates = new ArrayList();

        for(int i=0;i<10000;i++){
            LocalDates.add(pool.submit(callable));
        }

        LocalDates.forEach((Future<LocalDate> LocalDateFuture) -> {
            try {
                System.out.println("----" + LocalDateFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        pool.shutdown();
    }


}
