package com.hyp.clone.deep;


public class SubjectDeep implements Cloneable {

    private String name;

    public SubjectDeep(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //SubjectDeep 如果也有引用类型的成员属性，也应该和 Student 类一样实现
        return super.clone();
    }

    @Override
    public String toString() {
        return "[SubjectDeep: " + this.hashCode() + ",name:" + name + "]";
    }
}
