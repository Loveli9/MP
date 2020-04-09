package com.hyp.java_pattern.action.observer.example.publishReadEx;

import lombok.Data;

/**
 * 4.定义具体观察者角色
 * 观察者模式：观察者 实现
 * @author dengp
 *
 */
@Data
public class ObserverA implements Observer1 {

    //myState需要跟目标对象的state值保持一致！
    private int myState;

    /**
     * 更新为和目标对象的值一致
     */
    @Override
    public void update(Subject1 subject) {
        myState = ((ConcreteSubject)subject).getState();
    }

}
