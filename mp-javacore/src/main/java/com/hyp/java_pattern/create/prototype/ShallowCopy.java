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
package com.hyp.java_pattern.create.prototype;

import com.hyp.java_pattern.create.prototype.prototypeAbs.BaseMessage;

/**
* @Description：   <p> 设计模式  原型模式     --- 浅拷贝的对象</p>
 */
public class ShallowCopy extends BaseMessage implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ShallowCopy shallowCopy = null;
        try {
            shallowCopy = (ShallowCopy) super.clone();
        }catch (Exception e){
            e.printStackTrace();
        }
        return shallowCopy;
    }

}
