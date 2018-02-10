package com.kaka.test.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by sundaoping on 2018/2/10.
 */

/**
 * ：jdk动态代理和cglib动态代理。两种方法同时存在，各有优劣。jdk动态代理是由java内部的反射机制来实现的，
 *  cglib动态代理底层则是借助asm来实现的。总的来说，反射机制在生成类的过程中比较高效，而asm在生成类之后
 *  的相关执行过程中比较高效（可以通过将asm生成的类进行缓存，这样解决asm生成类过程低效问题）。还有一点必
 *  须注意：jdk动态代理的应用前提，必须是目标类基于统一的接口。如果没有上述前提，jdk动态代理不能应用。由
 *  此可以看出，jdk动态代理有一定的局限性，cglib这种第三方类库实现的动态代理应用更加广泛，且在效率上更有
 *  优势。。
 */
public class MyInvocationHandler implements InvocationHandler {
    protected Object target ; //代理的类

    public MyInvocationHandler(){
        super();
    }

    public MyInvocationHandler(Object target){
        super();
        this.target = target;
    }

    // 然后是invoke的三个参数、第一个参数就是代理者，如果你想对代理者做一些操作可以使用这个参数；
    // 第二个就是被执行的方法，第三个是执行该方法所需的参数。
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if("getName" .equals(method.getName())){
            System.out.println(MyInvocationHandler.class + " before invoke getName");
            Object result = method.invoke(target, args);
            System.out.println(MyInvocationHandler.class + " after invoke getName");
            return result;
        }else{
            Object result = method.invoke(target, args);
            return result;
        }

    }
}
