package com.hyp.java_pattern.create.factory.factory.example.StaticFunction;

/**
 * 多方法静态工厂模式：
 * 创建一个工厂类，在工厂类中写多个静态方法来创建对应的类。当有新的需求时，只需要增删工厂类中的静态方法就行了。
 * */
public class FactoryTest1 {
    public static void main(String[] args) {
        Car car = CarFactory.Benzfactory();
        car.factory();
    }
}

interface Car{
    public void factory();
}
class BMW implements Car{
    public void factory() {
        System.out.println("生产宝马！");
    }
}
class Benz implements Car{
    public void factory() {
        System.out.println("生产奔驰！");
    }
}
class Audi implements Car{
    public void factory() {
        System.out.println("生产奥迪！");
    }
}

class CarFactory{
    public static Car BMWfactory(){
        return new BMW();
    }
    public static Car Benzfactory(){
        return new Benz();
    }
    public static Car Audifactory(){
        return new Audi();
    }

}
