package com.hyp.java_multi_thread.example.ex4;

import java.util.ArrayList;
import java.util.List;

/**
 * 五．实例四:
 * 在一个KFC内，服务员负责生产食物，消费者负责消费食物；
 * 当生产到一定数量可以休息一下，直到消费完食物，再马上生产，一直循环
 * 程序涉及到的内容：
 * 1.这设计到java模式思想：生产者消费者模式
 * 2.要保证操作对象的统一性，即消费者和服务者都是跟同一个KFC发生关系的，KFC只能new一次
 * 3.this.notifyAll();和 this.wait();一个是所有唤醒的意思，一个是让自己等待的意思；
 * 比如本题中，生产者生产完毕后，先所有唤醒（包括消费者和生产者），再让所有自己（生产者）等待
 *  这时，消费者开始消费，直到食材不够，先所有唤醒（包括消费者和生产者），再让所有自己（消费者）等待
 * 一直执行上面的操作的循环
 * 4.生产者和消费者都要继承Thread，才能实现多线程的启动
 * 程序设计的步骤思路：
 * 1.创建一个食物类Food，有存放/获取食物的名称的方法
 * 2.创建一个KFC类，有生产食物和消费食物的方法
 * 3.创建一个客户类Customer，继承Thread，重写run方法，在run方法里面进行消费食物操作
 * 4.创建一个服务员类Waiter，继承Thread，重写run方法，在run方法里面进行生产食物的操作
 * 5.创建主方法的调用类
 * */
public class KFC {

    //食物的种类
    public static final String[] names = { "薯条", "烧板", "鸡翅", "可乐" };

    //生产的最大值，到达后可以休息
    static final int Max = 20;

    //存放食物的集合
    List<Food> foods = new ArrayList<>();

    // 生产食物的方法
    public void prod(int index) {
        synchronized (this) {
            // 如果食物数量大于20
            while (foods.size() > Max) {
                System.out.println("食材生产够了");
                this.notifyAll();//这个唤醒是针对生产者和消费者，有all
                try {
                    String name = Thread.currentThread().getName();
                    this.wait();//让自己等待
                    System.out.println("生产者："+ name + "等待...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 开始生产食物食物，有一点要注意的
            System.out.println("开始生产食物......");
            for (int i = 0; i < index; i++) {
                Food food = new Food(names[(int) (Math.random() * 4)]);
                foods.add(food);
                System.out.println("生产了" + food.getName() + "，目前餐盘食物总个数：" +  foods.size());
            }

        }
    }

    // 消费食物的方法
    public void consu(int index) {
        synchronized (this) {
            while (foods.size() < index) {
                System.out.println("食材不够了");
                this.notifyAll();//这个唤醒是针对生产者和消费者，有all
                try {
                    String name=Thread.currentThread().getName();
                    this.wait();//让自己等待
                    System.out.println("消费者："+name + "等待...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 足够消费
            System.out.println("开始消费......");
            for (int i = 0; i < index; i++) {
                Food food = foods.remove(foods.size() - 1);
                System.out.println("消费了一个" + food.getName() + "，剩余餐盘食物总个数：" + foods.size());
            }
        }
    }
}
