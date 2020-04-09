package com.hyp.java8.object;

/**
 * 深度拷贝
 * */
public class DeepCopy {

    // 车轮类
    static class Wheel implements Cloneable {
        int radius;

        public Wheel(int radius) {
            this.radius = radius;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Wheel && radius == ((Wheel) obj).radius;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Wheel wheelCopy = (Wheel)super.clone();
            wheelCopy.radius = radius;
            return wheelCopy;
        }
    }

    static class Bike implements Cloneable {
        // 车的前后轮
        Wheel frontWheel;
        Wheel backWheel;
        int weight;

        public Bike(Wheel frontWheel, Wheel backWheel, int weight) {
            this.frontWheel = frontWheel;
            this.backWheel = backWheel;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Bike)) {
                return false;
            }
            Bike bike = (Bike) obj;
            return frontWheel.equals(bike.frontWheel) &&
                    backWheel.equals(bike.backWheel) &&
                    weight == bike.weight;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            // 先通过 super.clone() 方法获取对应的对象
            Bike bikeCopy = (Bike)super.clone();
            // 基本数据类型直接赋值
            bikeCopy.weight = weight;
            // 引用数据类型通过调用被拷贝属性对象的 clone 方法赋值
            bikeCopy.frontWheel = (Wheel) frontWheel.clone();
            bikeCopy.backWheel = (Wheel) backWheel.clone();
            return bikeCopy;
        }
    }

    private static void startTest() {
        Bike bike1 = new Bike(new Wheel(1), new Wheel(2), 5);
        try {
            Bike bike2 = (Bike) bike1.clone();
            System.out.println("bike1 == bike2: " + (bike1 == bike2));
            System.out.println("bike1.equals(bike2): " + (bike1.equals(bike2)));
            System.out.println("bike1.frontWheel == bike2.frontWheel: " + (bike1.frontWheel == bike2.frontWheel));
            System.out.println("bike1.frontWheel.equals(bike2.frontWheel): " + (bike1.frontWheel.equals(bike2.frontWheel)));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        startTest();
    }
}
