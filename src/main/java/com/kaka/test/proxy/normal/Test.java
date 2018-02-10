package com.kaka.test.proxy.normal;

/**
 * Created by sundaoping on 2018/2/10.
 */
public class Test {
    public static void main(String []args){
        Subject subject = new RealSubject();
        Subject subjectProxy = new RealSubjectProxy(subject);
        subjectProxy.Request();
    }
}
