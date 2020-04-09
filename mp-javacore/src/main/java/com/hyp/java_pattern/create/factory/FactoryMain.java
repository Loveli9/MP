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
package com.hyp.java_pattern.create.factory;

import com.hyp.java_pattern.create.factory.factory.AbsHumanFactory;
import com.hyp.java_pattern.create.factory.factory.HumanFactory;
import com.hyp.java_pattern.create.factory.human.BlackHuman;
import com.hyp.java_pattern.create.factory.human.Human;
import com.hyp.java_pattern.create.factory.human.WhiteHuman;
import com.hyp.java_pattern.create.factory.human.YellowHuman;

/**
* @Package：cn.ucaner.pattern.create.factory   
* @ClassName：FactoryMain   
* @Description：   <p> 工厂模式  - 执行类</p>
* @Author： -  
* @CreatTime：2017年10月26日 下午5:47:54   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class FactoryMain {
	
    public static void main(String[] args) {
        //初始化一个工厂
        AbsHumanFactory humanFactory = new HumanFactory();

        //建造一个黄种人
        Human yellowHuman = humanFactory.createHumen(YellowHuman.class);
        System.out.println(yellowHuman);
        yellowHuman.getColor();

        //建造一个黑人
        Human blackHuman = humanFactory.createHumen(BlackHuman.class);
        System.out.println(blackHuman);
        blackHuman.getColor();

        //建造一个白人
        Human whiteHuman = humanFactory.createHumen(WhiteHuman.class);
        System.out.println(whiteHuman);
        whiteHuman.getColor();

    }

}
