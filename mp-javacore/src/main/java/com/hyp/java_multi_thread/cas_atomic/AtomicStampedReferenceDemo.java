package com.hyp.java_multi_thread.cas_atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 此方式可以解决Atomic所带来的ABA问题
 * */
public class AtomicStampedReferenceDemo {

    public static void main(String[] args) {

        String str1 = "aaa";
        String str2 = "bbb";
        AtomicStampedReference<String> reference = new AtomicStampedReference<String>(str1,1);
        //比较预期的reference和当前的reference，预期的stamp和当前的stamp，
        //如果一致则CAS改为新的reference和stamp，不一致则CAS修改失败
        reference.compareAndSet(str1,str2,reference.getStamp(),reference.getStamp()+1);
        System.out.println("reference.getReference() = " + reference.getReference() + " reference.getStamp() = " + reference.getStamp());

        boolean b = reference.attemptStamp(str2, reference.getStamp() + 1);
        System.out.println("b: "+b);
        System.out.println("reference.getReference() = " + reference.getReference() + " reference.getStamp() = "+reference.getStamp());

        boolean c = reference.weakCompareAndSet(str2,"ccc",4, reference.getStamp()+1);
        System.out.println("reference.getReference() = "+reference.getReference() + " reference.getStamp() = " + reference.getStamp());
        System.out.println("c = " + c);
    }

}
