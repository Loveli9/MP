package com.hyp.java_pattern.action.observer.example.javaBuiltIn;

import java.util.Observable;
import java.util.Observer;

/**
 * 2.定义具体观察者
 * 观察者模式：观察者(消息订阅者)
 * 实现Observer接口
 * @author dengp
 *
 */
public class ObserverA implements Observer {

    private int myState;

    @Override
    public void update(Observable o, Object arg) {
        myState = ((ConcreteSubject)o).getState();
    }

    public int getMyState() {
        return myState;
    }
    public void setMyState(int myState) {
        this.myState = myState;
    }

}
