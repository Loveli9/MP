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
package com.hyp.java_pattern.structure.decorator.decoratorAbs;

/**
* @Description：   <p> 装饰器模式  - 
* 抽象装饰器 这种方式看起来和静态代理模式很像
 * 区别：
 * 我们需要从概念上了解代理和装饰的区别：
 *      代理是全权代理，目标根本不对外，全部由代理类来完成。
 *      装饰是增强，是辅助，目标仍然可以自行对外提供服务，装饰器只起增强作用。
 */
public abstract class Decorator extends SchoolReport { //Decorator 装饰器
	
	/**
	 * 成绩单的抽象类
	 */
    private SchoolReport  schoolReport;

    /**
    * Decorator.  将成绩单的属性包装到 Decorator里面去
    * @param schoolReport
     */
    public Decorator(SchoolReport schoolReport) {
        this.schoolReport = schoolReport;
    }

    /**
     * 展示自己的成绩
     */
    public void report(){
        schoolReport.report();
    }

    //家长签名
    @Override
    public void sign(String name) {
        schoolReport.sign(name);
    }

}
