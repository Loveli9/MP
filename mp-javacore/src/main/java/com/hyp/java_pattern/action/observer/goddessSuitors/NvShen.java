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
package com.hyp.java_pattern.action.observer.goddessSuitors;

import com.hyp.java_pattern.action.observer.goddessSuitors.observerAbs.Observer2;
import com.hyp.java_pattern.action.observer.goddessSuitors.observerAbs.Subject4;
import java.util.ArrayList;
import java.util.List;

/**
* @Package：cn.ucaner.pattern.action.observer.observerIml   
* @ClassName：NvShen   
* @Description：   <p> 观察者模式  --- 女神</p>
* @Author： -  
* @CreatTime：2017年10月26日 下午5:28:12   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */

public class NvShen implements Subject4 {
	
	/**
	 * 女神有一大堆观察者.
	 */
    private List<Observer2> observersList;

    //女神要去逛街了
    public void goShopping(){
        System.out.println("女神准备要去逛街了！！！");
        //调用通知方法，通知所有的观察者
        Notify();
    }

    /**
     * 添加观察者
     */
    @Override
    public void Attach(Observer2 observer) {
        if(observersList==null){
            observersList=new ArrayList<Observer2>();
        }else {
            observersList.add(observer);
        }
    }

    /**
     * 删除观察者
     */
    @Override
    public void Detach(Observer2 observer) {
        String name=((DiaoSi)observer).getName();
        if(observersList==null||observersList.size()==0){
            return;
        }
       if( observersList.remove(observer)){
           System.out.println("Sorry , 条件不满足 ---- "+name+"已经被踢出队伍.");
       }
    }

    
    /**
     * 通知所有观察者
     */
    @Override
    public void Notify() {
    	//observersList 观察者List
        for (Observer2 observer : observersList) {
            //通知所有的跟随人员
            observer.Update();
            //跟随人员想跟女神说的话
            observer.Say();
        }
        System.out.print("追求者已全部出动！");
    }

}
