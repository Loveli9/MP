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
package com.hyp.java_pattern.structure.proxy.dynamicProxy;

/**
* @Description：   <p> 代理模式 -  动态代理真实类 </p>
 */
public class RealSujectImpl implements Subject3 {

    @Override
    public void request() {
        System.out.println("*** dynamicProxy  do request ***");
    }

}
