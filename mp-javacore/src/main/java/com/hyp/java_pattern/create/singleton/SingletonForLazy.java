/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 19941115</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package com.hyp.java_pattern.create.singleton;

/**
* @Description：   <p> 双重锁的单例   单例模式</p>
* Singleton的静态属性instance中，只有instance为null的时候才创建一个实例，构造函数私有，确保每次都只创建一个，避免重复创建
 */
/**
 * 推荐一：使用该方式进行实现单例模式
 * 在Spring中创建的Bean实例默认都是单例模式存在的。
 * */
public class SingletonForLazy {

    private SingletonForLazy() {
    }
    
    /**
     * 唯一实例 
     * 内存可见性：通俗来说就是，线程A对一个volatile变量的修改，对于其它线程来说是可见的，即线程每次获取volatile变量的值都是最新的。
     * https://www.cnblogs.com/chengxiao/p/6528109.html
     */
    private static volatile SingletonForLazy mInstance;

    //懒汉模式【线程安全】
    public static SingletonForLazy getInstance() {
        
        if (mInstance == null) {
            //第一个锁，如果没有实例
        	/**
        	 * 第二个锁，如果没有任何线程创建Singleton实例  对象锁 - 若多个线程拥有同一个MyObject类的对象，则这些方法只能以同步的方式执行
             *
             * 补充：关于锁内部的第二重空判断的作用，当多个线程一起到达锁位置时，进行锁竞争，其中一个线程获取锁，
             * 如果是第一次进入则dl为null，会进行单例对象的创建，完成后释放锁，其他线程获取锁后就会被空判断拦截，直接返回已创建的单例对象。
        	 * https://www.cnblogs.com/hapjin/p/5452663.html
             * 不论如何，使用了双重加锁机制后，程序的执行速度有了显著提升，不必每次都同步加锁。
        	 */
            synchronized (SingletonForLazy.class) {
                if (mInstance == null) {
                    mInstance = new SingletonForLazy();
                }
            }
        }
        return mInstance;
    }
    
    public static void main(String[] args) {
    	//单例模式获取单例实例化对象
    	System.out.println(getInstance());
		System.out.println(mInstance);
	}
}

