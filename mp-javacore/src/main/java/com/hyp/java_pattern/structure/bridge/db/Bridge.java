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
package com.hyp.java_pattern.structure.bridge.db;

import com.hyp.java_pattern.structure.bridge.db.inf.Driver;
import lombok.Data;

/**
* @Package：cn.ucaner.pattern.structure.bridge.db   
* @ClassName：Bridge   
* @Description：   <p> Bridge </p>
* @Author： - Jason   
* @CreatTime：2018年6月5日 下午9:34:03   
* @Modify By：   
* @ModifyTime：  2018年6月5日
* @Modify marker：   
* @version    V1.0
*/
@Data
public abstract class Bridge {
	
	/**
	 * JDBC 驱动
	 */
	private Driver driver;
	
	/**
	 * @Description: 连接器
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
	public void connect(){  
	    driver.connect();  
	}
	 
}
