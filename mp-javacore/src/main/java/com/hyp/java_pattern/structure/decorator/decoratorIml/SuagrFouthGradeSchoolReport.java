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

/**
* @Package：cn.ucaner.pattern.structure.decorator.decoratorIml   
* @ClassName：SuagrFouthGradeSchoolReport   
* @Description：   <p> 装饰器模式  SuagrFouthGradeSchoolReport -  FouthGradeSchoolReport </p>
* @Author： -  
* @CreatTime：2017年10月26日 下午5:21:41   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class SuagrFouthGradeSchoolReport extends FouthGradeSchoolReport {

    @Override
    public void report() {
        System.out.print("我英语得了90分,语文得了80分. "); //先把最高成绩说出去
        super.report();
    }
}

