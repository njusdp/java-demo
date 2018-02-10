package com.kaka.test.proxy.dynamic;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * Created by sundaoping on 2018/2/10.
 */
public class Test {
    public static void main(String []args){
        UserService userService = new UserServiceImpl();


        System.out.println("#######InvocationHandler方式动态代理#########");
        //创建一个InvocationHandler，描述我们希望代理者执行哪些操作
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(userService);

        //通过刚才创建的InvocationHandler，创建真正的代理者。第一个参数是类加载器，
        // 第二个参数是这个代理者实现哪些接口(与被代理者实现的是相同的接口)
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(), myInvocationHandler);

        String name = userServiceProxy.getName("njusdp");
        Integer age = userServiceProxy.getAge(333);

        System.out.println(name + "---" + age);


        System.out.println("#######Cglib方式动态代理#########");
        CglibProxy cglibProxy = new CglibProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(cglibProxy);

        UserService userServiceProxy2 = (UserService) enhancer.create();

        String name2 = userServiceProxy2.getName("njusdp2222");
        Integer age2 = userServiceProxy2.getAge(4444);
        System.out.println(name2 + "----" + age2);

    }

}
