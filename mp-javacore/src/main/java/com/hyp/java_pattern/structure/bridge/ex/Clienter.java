package com.hyp.java_pattern.structure.bridge.ex;

public class Clienter {

    public static void main(String[] args) {
        SourceAreaA a = new SourceAreaA2();
        a.qiao = new TargetAreaB3();
        a.fromAreaA();
        a.qiao.targetAreaB();
    }

}
