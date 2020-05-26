package com.hyp.java_multi_thread;

public class TestMain {

    public static final String hhh = "cib";

    public static void main(String[] args) {
        String b = "c";
        String c = "i";
        String d = "b";
        String a = "c"+"i"+"b";
        System.out.println(a == hhh);
        System.out.println(b+c+d == hhh);
    }

}
