package com.hyp.java_pattern.structure.proxy.example;

public class LvShi implements ZiRanRen {
    @Override
    public void Quanli() {
        new MaYun().Quanli();
    }
}