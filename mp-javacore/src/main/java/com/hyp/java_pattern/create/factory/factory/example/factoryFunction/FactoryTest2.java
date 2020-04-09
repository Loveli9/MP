package com.hyp.java_pattern.create.factory.factory.example.factoryFunction;

/**
 * 工厂方法模式：
 * 设置一个工厂接口，通过其他的类实现这个接口来创建实例。
 * 不仅实体要抽象，工厂也要抽象，由具体的工厂类来创建对象。
 * 当有新的需求时，只需要添加或者删除具体工厂类就行了，不需要修改已有的已有类中的代码。
 *
 * 工厂方法模式是对简单工厂模式的抽象升级，将工厂这个概念抽象出来成为接口，
 * 然后针对每种目标实现类创建一个工厂实现，
 * 一对一来实现，当新增了目标实现，只要同时新增一个工厂实现即可。
 * */
public class FactoryTest2 {
    public static void main(String[] args) {
        Car2 BMW = new BMWfactory2().carfactory();
        BMW.factory();
    }
}

interface Car2{
    public void factory();//方法：生产一类汽车
}
class BMW2 implements Car2{
    public void factory() {
        System.out.println("生产宝马！");
    }
}
class Benz2 implements Car2{
    public void factory() {
        System.out.println("生产奔驰！");
    }
}
class Audi2 implements Car2{
    public void factory() {
        System.out.println("生产奥迪！");
    }
}
//抽象工厂
interface CarFactory2{
    Car2 carfactory();//工厂：生产一类工厂
}
//具体工厂类
class BMWfactory2 implements CarFactory2{
    @Override
    public Car2 carfactory() {
        return new BMW2();
    }
}
class Benzfactory2 implements CarFactory2{
    @Override
    public Car2 carfactory() {
        return new Benz2();
    }
}
class Audifactory2 implements CarFactory2{
    @Override
    public Car2 carfactory() {
        return new Audi2();
    }
}
