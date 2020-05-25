package com.hyp.java_multi_thread.thread_sync;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class M8_CyclicBarrier {

    /**
     * CyclicBarrier是一个同步的辅助类，和上面的CountDownLatch比较类似，
     * 不同的是他允许一组线程相互之间等待，达到一个共同点，
     * 再继续执行。可看成是个障碍，所有的线程必须到齐后才能一起通过这个障碍。
     * */
    public static void main(String[] args) {
        //启动两个线程，分别执行完毕之后再执行主线程
        CyclicBarrier barrier  = new CyclicBarrier(2, () -> {
            //执行主线程
            System.out.println("主线程执行完毕");

        });

        //线程1执行
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程执行完毕");
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        //线程2执行
        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程执行完毕");
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
    }

}
