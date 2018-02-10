package com.kaka.test.proxy.dynamic;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by sundaoping on 2018/2/10.
 */
//基于cglib的动态代理实现
public class CglibProxy implements MethodInterceptor {

    /**
     * 第一个参数是代理对像，第二和第三个参数分别是拦截的方法和方法的参数。
     * 原来的方法可能通过使用java.lang.reflect.Method对象的一般反射调用，
     * 或者使用 net.sf.cglib.proxy.MethodProxy对象调用
     * 。net.sf.cglib.proxy.MethodProxy通常被首选使用，因为它更快。
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(CglibProxy.class + " before invoke " + methodProxy.getSuperName());
        //String name = method.getName();

        //System.out.println("name:" + name);
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println(CglibProxy.class + " after invoke " + methodProxy.getSuperName());
        return o1;
    }
}
