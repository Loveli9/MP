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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @Package：cn.ucaner.pattern.action.observer.observerIml   
* @ClassName：DiaoSi   
* @Description：   <p> 观察者模式  ---  屌丝</p>
* @Author： -  
* @CreatTime：2017年10月26日 下午5:28:58   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DiaoSi  implements Observer2 {
   
    private String name;

    @Override
    public void Update() {
        System.out.println(name+"：已经知道女神出门,准备跟(wei)踪(sui)");
    }

	@Override
	public void Say() {
		System.out.println(name+"：在下想约你可以吗？");
	}

}
