package com.kaka.test.proxy.normal;

/**
 * Created by sundaoping on 2018/2/10.
 */
//代理类和真正类实现相同接口,(经纪人与艺人从属于同一公司)
public class RealSubjectProxy implements Subject {

    private Subject subject;

    public RealSubjectProxy(Subject subject ){
        this.subject = subject;
    }

    @Override
    public void Request() {
        System.out.println(RealSubjectProxy.class + " before Request method invoked!");
        subject.Request();
        System.out.println(RealSubjectProxy.class + " after Request method invoked!");
    }
}
