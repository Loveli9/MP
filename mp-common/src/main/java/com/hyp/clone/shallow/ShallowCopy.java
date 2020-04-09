package com.hyp.clone.shallow;

public class ShallowCopy {

    /**
     * 由输出的结果可见，对于浅拷贝：
     * 通过 studentA.clone() 拷贝对象后得到的 studentB，和 studentA 是两个不同的对象。
     * studentA 和 studentB 的基础数据类型的修改互不影响，而引用类型 subject 修改后是会有影响的。
     * 说到底：
     * 浅拷贝是指在拷贝对象时，对于基本数据类型的变量会重新复制一份，而对于引用类型的变量只是对直接引用进行拷贝，
     * 没有对直接引用指向的对象进行拷贝。
     *
     * 克隆的特点：
     * （1）克隆的对象与原对象并不是同一个对象，分别占用不同的堆空间 x.clone()!=x
     * （2）克隆的对象与原对象的类型一样 x.clone().getClass()==x.clone().getClass()
     * */
    public static void main(String[] args) {
        SubjectShallow subject = new SubjectShallow("语文");
        Student studentA = new Student();
        studentA.setSubject(subject);
        studentA.setName("陈老师");
        studentA.setAge(20);
        Student studentB = (Student) studentA.clone();
        studentB.setName("胡老师");
        studentB.setAge(18);
        SubjectShallow subjectB = studentB.getSubject();
        subjectB.setName("数学");
        System.out.println("studentA:" + studentA.toString());
        System.out.println("studentB:" + studentB.toString());//改变了引用，原来的引用类型也跟着变化
    }

}