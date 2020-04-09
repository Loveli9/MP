package com.hyp.java8.object;

public class ObjTest {

    static class People {
        String name;
        public People(String name) {
            this.name = name;
        }
        private void work() {
            System.out.println(name + " is working!");
        }
    }

    private static void startTest() {
        People p1 = new People("孙悟空");
        p1.work();
        // 获取 p1 对象的类型信息，在这里编译器只知道 p1 是 People 类型的对象的引用，
        // 但是编译器并不知道具体是 People 类型的对象还是 People 的子类对象（虽然在这里并没有 People 的子类），
        // 所以我们这里用泛型必须加类型边界限定符，
        // 当然也可以不加，这样就代表这是一个任意类型的 Class 对象
        Class<? extends People> cp = p1.getClass();
        People p2 = null;
        try {
            // 获取 cp 代表的 Class 对象的具有一个 String 类型的构造方法，
            // 再使用这个构造方法新建一个对象并将 p2 引用指向这个对象，
            // 即为通过反射的方式创建对象
            p2 = cp.getConstructor(String.class).newInstance("唐僧");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (p2 != null) {
            p2.work();
        }
    }

    public static void main(String[] args) {
        startTest();
    }

}
