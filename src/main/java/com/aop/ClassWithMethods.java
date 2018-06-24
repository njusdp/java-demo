package com.aop;

/**
 * Created by sundaoping on 2018/6/20.
 */
public class ClassWithMethods {
    public void msg1() throws Exception {
        System.out.println("msg1() invoked");
        throw new Exception();
    }

    int msg2() {
        System.out.println("msg2() invoked");
        return 5;
    }

    void msg3() {
        System.out.println("msg3() invoked");
    }

    public void msg4() {
        System.out.println("msg4() invoked");
    }

    public void msg5() {
        System.out.println("msg5() invoked");
    }

    public int m() {
        System.out.println("m() invoked");
        return 1;
    }

    public void k1() {
        System.out.println("k1() invoked");
    }

    public void k2() {
        System.out.println("k2() invoked");
    }

    public int k3() {
        System.out.println("k3() invoked");
        return 3;
    }
}
