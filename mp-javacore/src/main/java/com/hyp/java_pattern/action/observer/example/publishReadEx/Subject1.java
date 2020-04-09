package com.hyp.java_pattern.action.observer.example.publishReadEx;

import java.util.ArrayList;
import java.util.List;
/**
 * 定义抽象被观察者角色
 * 观察者模式：目标对象模板
 * @author dengp
 *
 */
public interface Subject1<T> {
    // 存储订阅者
    List<Observer1> list = new ArrayList<>();

    // 注册订阅者
    void registerObserver(T obs);

    // 移除订阅者
    void removeObserver(T obs);

    //通知所有的观察者更新状态
    void notifyAllObservers();

}
