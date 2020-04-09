package com.hyp.java_pattern.create.factory.factory.example.simple;

/**
 *简单工厂模式：
 * 工厂模式一般用于当我们创建复杂对象时，通过简单的new来创建会比较麻烦，这时候我们就可以使用工厂模式来创建一个工厂类，
 * 我们只需向工厂类中传入需要创建的类的有关信息即可，工厂类中实现了创建对象的复杂细节。
 * */
public class FactoryTest1 {
    public static void main(String[] args) {
        Car11 car = CarFactory.carFactory(BMW.class);
        car.factory();
    }
}

interface Car11 {
    public void factory();
}

class BMW implements Car11{
    public void factory() {
        System.out.println("生产宝马！");
    }
}
class Benz implements Car11{
    public void factory() {
        System.out.println("生产奔驰！");
    }
}
class Audi implements Car11{
    public void factory() {
        System.out.println("生产奥迪！");
    }
}

class CarFactory{
    public static Car11 carFactory(Class<?> class1){
        if (class1.getName().equals(BMW.class.getName())){
            return new BMW();
        }
        if (class1.getName().equals(Benz.class.getName())){
            return new Benz();
        }
        if (class1.getName().equals(Audi.class.getName())){
            return new Audi();
        }
        return null;
    }
}
