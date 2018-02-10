package com.kaka.test.proxy.normal;

/**
 * Created by sundaoping on 2018/2/10.
 */
public class RealSubject implements Subject {
    @Override
    public void Request() {
        System.out.println(RealSubject.class + " Request method invoked !");
    }
}
