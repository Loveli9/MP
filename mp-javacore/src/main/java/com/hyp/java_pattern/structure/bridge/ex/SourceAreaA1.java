package com.hyp.java_pattern.structure.bridge.ex;

/**
 * 来源地A1
 */
public class SourceAreaA1 extends SourceAreaA {

    @Override
    void fromAreaA() {
        System.out.println("我来自A1");
    }

}