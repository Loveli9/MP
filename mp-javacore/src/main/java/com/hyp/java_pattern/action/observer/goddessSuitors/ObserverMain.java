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

import com.hyp.java_pattern.action.observer.goddessSuitors.observerAbs.Subject4;

/**
* @Package：cn.ucaner.pattern.action.observer   
* @ClassName：ObserverMain   
* @Description：   <p> 观察者模式   - 观察者模式运行类 </p>
* @Author： -  
* @CreatTime：2017年10月26日 下午5:26:58   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class ObserverMain {

	/**
	 * @Description: Test 
	 * @Autor: Jason - Jasonandy@hotmail.com
	 */
    public static void main(String[] args) {
    	
        NvShen nvShen = new NvShen();
        
        /**
         * 添加观察者
         */
        getObservers(nvShen);

        //女神要出去逛街了!!!
        nvShen.goShopping();

    }

    /**
     * 添加观察者
     */
    public static void getObservers(Subject4 nvShen){
        for (int i = 0; i < 10 ; i++) {
        	String remark = String.format("有车 : %s ,有房: %s ,有学历: %s", "BBQ","BeiJing","常春藤");
        	GaoFuShuai gaoFuShuai = new GaoFuShuai("高富帅"+i, (long)(i^(i+88)),remark );
            DiaoSi diaosi = new DiaoSi("屌丝"+i);
            nvShen.Attach(diaosi);
            if (i%2!=0) {
            	nvShen.Attach(gaoFuShuai); //添加高富帅
                nvShen.Detach(diaosi); //剔除
			}
        }
    }

}