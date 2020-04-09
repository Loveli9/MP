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
package com.hyp.java_pattern.create.builder;

/**
* @Package：cn.ucaner.pattern.create.builder   
* @ClassName：BuilderTest   
* @Description：   <p> 测试类,生产一个金刚狼</p>
 * 建造者模式，顾名思义的就是类似建房子，有一个固定的流程。在大话设计模式中，
 * 作者举了一个例子大概意思是同一道菜在中国的每一个地方都有不同的味道
 * （LZ印象最深的是鱼香肉丝，来北方最之后印象最深的是宫保鸡丁。哈哈），
 * 而肯德基的鸡腿、汉堡在每一个城市都是一样的味道。我觉的这一个例子可以清楚的认识到建造者模式有一个固定的建造过程。
 * 建造者模式实现了依赖倒转原则，抽象不应该依赖细节，细节应该依赖与抽象。
 * 建造者模式的定义是：将一个复杂对象的构造与它的表示分离，使同样的构建过程可以创建不同的表示，这样的设计模式被称为建造者模式。
 * 建造者模式的角色定义，在建造者模式中存在以下4个角色：
 * builder:为创建一个产品对象的各个部件指定抽象接口
 * ConcreteBuilder:实现Builder的接口以构造和装配该产品的各个部件，定义并明确它所创建的表示，并提供一个检索产品的接口
 * Director:构造一个使用Builder接口的对象
 * Product:表示被构造的复杂对象。ConcreteBuilder创建该产品的内部表示并定义它的装配过程，包含定义组成部件的类，
 * 包括将这些部件装配成最终产品的接口
* @Author： -    
* @CreatTime：2018年1月16日 下午2:04:55   
* @Modify By：   
* @ModifyTime：  2018年1月16日
* @Modify marker：   
* @version    V1.0
 */
public class BuilderTest {

    public static void main(String[] args) {
        WolverineDirector director = new WolverineDirector();
        XMan wolverine = director.constructWolverine(new WolverineBuilder());
        String lover = wolverine.getLover();
        String getxFactor = wolverine.getxFactor();
        Integer age = wolverine.getAge();
        String name = wolverine.getName();
        System.out.println("Lover:"+lover+"  xFactor:"+getxFactor+" Name:"+name+" Age:"+age);
        System.out.println(wolverine.toString());
    }

}