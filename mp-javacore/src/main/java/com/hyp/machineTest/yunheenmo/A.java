package com.hyp.machineTest.yunheenmo;

import org.junit.Test;

public class A {

    public A() {
        System.out.println("1");
    }

    public void run() {
        System.out.println("2");
    }

    @Test
    public void test() {
        B b = new B();
        b.run();
        A a = new A();
        a.run();
        System.out.println(a.getClass() == A.class);
        System.out.println(b.getClass() == B.class);
    }

}

class B extends A {
    public B() {
        System.out.println("3");
    }

    @Override
    public void run() {
        System.out.println("4");
    }
}
