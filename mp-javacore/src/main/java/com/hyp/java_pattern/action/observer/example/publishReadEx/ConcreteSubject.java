package com.hyp.java_pattern.action.observer.example.publishReadEx;

import lombok.Getter;

/**
 * 观察者模式:目标对象(主体对象 topic)
 * 定义具体被观察者角色
 * @author dengp
 *
 */

@Getter
public class ConcreteSubject implements Subject1<Observer1> {

    private int state;

    public void setState(int state) {
        this.state = state;
        //主题对象(目标对象)值发生了变化，请通知所有的观察者
        this.notifyAllObservers();
    }

    @Override
    public void notifyAllObservers() {
        for (Observer1 obs : list) {
            // 更新每一个观察者中的信息
            obs.update(this);
        }
    }

    @Override
    public void registerObserver(Observer1 obs) {
        // TODO Auto-generated method stub
        list.add(obs);
    }


    @Override
    public void removeObserver(Observer1 obs) {
        // TODO Auto-generated method stub
        list.remove(obs);
    }

}
