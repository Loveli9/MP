package com.hyp.clone.shallow;

public class SubjectShallow {

    private String name;

    public SubjectShallow(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[SubjectDeep: " + this.hashCode() + ",name:" + name + "]";
    }
}
