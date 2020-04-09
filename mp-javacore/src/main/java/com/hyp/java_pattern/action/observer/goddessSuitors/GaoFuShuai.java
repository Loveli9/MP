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
* @ClassName：GaoFuShuai   
* @Description：   <p> 观察者对象 - 高富帅 </p>
* @Author： - Jason   
* @CreatTime：
* @Modify By：   
* @ModifyTime： 
* @Modify marker：   
* @version    V1.0
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GaoFuShuai implements Observer2 {

	/**
	 * 名字
	 */
	private String name;
	
	/**
	 * 资产
	 */
	private Long property;
	
	/**
	 * 备注
	 */
	private String Remark;
	
	@Override
	public void Update() {
		System.out.println("您好，我是高富帅。我叫："+name);
	}

	@Override
	public void Say() {
		System.out.println("小姐姐约吗？我的资产是："+ property);
	}

	@Override
	public String toString() {
		return "I'm GaoFuShuai [name=" + name + ", property=" + property + ", Remark=" + Remark + "]";
	}

}
