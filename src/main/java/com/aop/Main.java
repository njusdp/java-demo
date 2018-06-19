package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sundaoping on 2018/6/20.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("appContextConfig.xml");
        ClassWithMethods bean = (ClassWithMethods) context.getBean("classWithMethods");

        bean.k1();
        bean.k2();
        bean.k3();

       /* int x = bean.m();
        System.out.println(x);

        try {
            bean.msg1();
        } catch (Exception e) {
            //
        }
        bean.msg2();
        bean.msg3();*/
    }
}
