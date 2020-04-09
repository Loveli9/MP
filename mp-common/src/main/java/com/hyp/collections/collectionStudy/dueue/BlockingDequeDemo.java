package com.hyp.collections.collectionStudy.dueue;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

class DataItem {
    private final int number;
    private final boolean flag;

    protected static final AtomicInteger count = new AtomicInteger(0);

    public DataItem(int number) {
        this.number = number;
        if ((number % 3) == 0) {
            flag = true;
        } else {
            flag = false;
        }
        count.incrementAndGet();
    }

    public void show() {
        System.out.println(number + ": " + ((flag == true) ? "Urgency" : "Common"));
    }

    public boolean isUrgency() {
        return flag;
    }
}

class Receiver extends Thread {
    private final BlockingDeque<DataItem> queue;

    public Receiver(BlockingDeque<DataItem> queue) {
        this.queue = queue;
    }

    public void run() {
        DataItem item;
        try {
            while (true) {
                item = queue.takeLast();
                item.show();
                DataItem.count.decrementAndGet();
            }
        } catch (InterruptedException ie) {
            System.out.println("Receiver finished");
        }
    }
}

public class BlockingDequeDemo {

    public static void main(String[] args) {

        BlockingDeque<DataItem> queue = new LinkedBlockingDeque<DataItem>(20);

        try {
            for (int i = 0; i < 10; i++) {
                DataItem item = new DataItem(i);
                if (item.isUrgency()) {
                    queue.putLast(item);
                } else {
                    queue.putFirst(item);
                }
            }
        } catch (InterruptedException ie) {
            System.out.println("Interrupted");
        }

        Thread receiver = new Thread(new Receiver(queue));
        receiver.start();

        while(DataItem.count.get() > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        receiver.interrupt();

        System.out.println("Main finished");
    }
}

