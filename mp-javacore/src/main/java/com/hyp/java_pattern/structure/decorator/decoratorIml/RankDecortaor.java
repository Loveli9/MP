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
package com.hyp.java_pattern.structure.decorator.decoratorIml;

import com.hyp.java_pattern.structure.decorator.decoratorAbs.Decorator;
import com.hyp.java_pattern.structure.decorator.decoratorAbs.SchoolReport;

/**
* @Package：cn.ucaner.pattern.structure.decorator.decoratorIml   
* @ClassName：RankDecortaor   
* @Description：   <p> 装饰器模式  -  装饰学校排名</p>
* @Author： -  
* @CreatTime：2017年10月26日 下午5:21:15   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class RankDecortaor extends Decorator {

    public RankDecortaor(SchoolReport schoolReport) {
        super(schoolReport);
    }

    @Override
    public void report() {
        System.out.println("在学校排名也很靠前");
        super.report();
    }

	@Override
	public void discuss(String discuss) {
		System.out.println("学校的排名这么靠前，还需要啥建议？建议低调一点，继续保持!");
	}

}
