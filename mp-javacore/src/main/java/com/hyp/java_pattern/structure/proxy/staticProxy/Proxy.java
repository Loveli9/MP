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
package com.hyp.java_pattern.structure.proxy.staticProxy;

/**
* @Description：   <p> 代理模式 代理模式代理类,他和装饰器模式的实现有点相近{}</p>
 */
public class Proxy implements Subject2 {
	
    private Subject2 realSuject;

    public Proxy(Subject2 realSuject) {
        this.realSuject = realSuject;
    }

    @Override
    public void request() {
        if(realSuject!=null){
            realSuject.request();
        }
    }
}
