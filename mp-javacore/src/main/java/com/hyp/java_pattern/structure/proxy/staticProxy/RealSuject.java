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
* @Description：   <p> 代理模式真实类</p>
 */
public class RealSuject implements Subject2 {
	
    @Override
    public void request() {
        System.out.println("*** static proxy do request ！By Jason ***");

    }
}
