package com.hyp.clone.deep;


public class DeepCopy {

    /**
     * 由输出结果可见，深拷贝后，
     * 不管是基础数据类型还是引用类型的成员变量，
     * 修改其值都不会相互造成影响。
     * 深拷贝:
     * 深拷贝是指在拷贝对象时,不仅把基本数据类型的变量会重新复制一份，同时会对引用指向的对象进行拷贝。
     * */
    public static void main(String[] args) {
        SubjectDeep subject = new SubjectDeep("语文");
        Student studentA = new Student();
        studentA.setSubject(subject);
        studentA.setName("小陈");
        studentA.setAge(18);
        Student studentB = (Student) studentA.clone();
        studentB.setName("小胡");
        studentB.setAge(20);
        SubjectDeep subjectB = studentB.getSubject();
        subjectB.setName("数学");
        System.out.println("studentA:" + studentA.toString());
        System.out.println("studentB:" + studentB.toString());
    }

}
