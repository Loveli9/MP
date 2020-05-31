package com.hyp.java_multi_thread.achieve_thread;

import java.util.concurrent.*;

public class CallableTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //创建目标对象
        MyCallable mcb1 = new MyCallable("唱歌");
        MyCallable mcb2 = new MyCallable("敲代码");
        //创建线程池执行服务
        ExecutorService svc = Executors.newFixedThreadPool(2);
        //提交执行
        Future<Boolean> result1 = svc.submit(mcb1);
        Future<Boolean> result2 = svc.submit(mcb2);
        System.out.println("提交完毕(1)......");
        Thread.sleep(3000);
        System.out.println("提交完毕(2)......");
        //获取结果
        boolean r1 = result1.get();
        boolean r2 = result2.get();
        //关闭服务
        svc.shutdownNow();
        System.out.println("线程1执行结果：" + r1);
        System.out.println("线程2执行结果：" + r2);
    }
}


class MyCallable implements Callable {

    private String str;

    public MyCallable(String str) {
        this.str = str;
    }

    @Override
    public 	Boolean call() throws Exception {
        for (int i = 0;i < 10;i++) {
            Thread.sleep(200);
            System.out.println("一边"+str);
        }
        return true;
    }
}
