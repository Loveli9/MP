package com.hyp.java_pattern.create.factory.factory.example.abstractFactory;

/**
 * 抽象工厂模式：
 * 抽象工厂就是一个工厂不单生产一个种类的产品，而是生产多个种类的产品，也就是生产相关产品的产品家族。
 * 比如现在工厂不仅生产汽车，还生产飞机。
 * */
public class FactoryTest2 {
    public static void main(String[] args) {
        Car22 Benz = new FFfactory2().carfactory();
        Benz.factory();
        Plane battleplane = new FFfactory1().planefactory();
        battleplane.planeFactory();
    }
}

interface Car22{
    void factory();
}
class BMW2 implements Car22{
    public void factory() {
        System.out.println("生产宝马！");
    }
}
class Benz2 implements Car22{
    public void factory() {
        System.out.println("生产奔驰！");
    }
}
class Audi2 implements Car22{
    public void factory() {
        System.out.println("生产奥迪！");
    }
}
interface Plane{
    void planeFactory();
}
class BattlePlane implements Plane{
    public void planeFactory() {
        System.out.println("生产战斗机！");
    }
}
class Airplane implements Plane{
    public void planeFactory() {
        System.out.println("生产客机！");
    }
}
class Spacecraft implements Plane{
    public void planeFactory() {
        System.out.println("生产宇宙飞船！");
    }
}

//抽象工厂
interface Factory2{
    Car22 carfactory(); //造汽车，工厂方法
    Plane planefactory(); //造飞机，工厂
}
//具体工厂类
class FFfactory1 implements Factory2{
    @Override
    public Car22 carfactory() {
        return new BMW2();
    }
    @Override
    public Plane planefactory() {
        return new BattlePlane();
    }
}
class FFfactory2 implements Factory2{
    @Override
    public Car22 carfactory() {
        return new Benz2();
    }
    @Override
    public Plane planefactory() {
        return new Airplane();
    }
}
class FFfactory3 implements Factory2{
    @Override
    public Car22 carfactory() {
        return new Audi2();
    }
    @Override
    public Plane planefactory() {
        return new Spacecraft();
    }
}
