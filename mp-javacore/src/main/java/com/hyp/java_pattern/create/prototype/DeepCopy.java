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

import java.util.ArrayList;

/**
* @Description：   <p> 原型模式  ---  原型模式深拷贝</p>
 */
public class DeepCopy extends BaseMessage implements Cloneable {

    @SuppressWarnings("unchecked")
	@Override
    protected Object clone() throws CloneNotSupportedException {
        DeepCopy deepCopy = null;
        try {
            deepCopy= (DeepCopy) super.clone();
            this.setImgList((ArrayList<String>) this.getImgList().clone());
        }catch (Exception e){
            e.printStackTrace();
        }
        return deepCopy;
    }
}
