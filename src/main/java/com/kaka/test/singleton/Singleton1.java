package com.kaka.test.singleton;

/**
 * Created by sundaoping on 2018/1/18.
 * 饿汉式单例 : 饿汉式单例中instance的初始化是在类加载时进行的，而类的加载是由ClassLoader来完成，这个过程由JVM来保证同步，
 *             所以这种方式天生是线程安全的。它的缺点也显而易见：容易造成资源的浪费，并且如果构造方法中处理过多，还有可能引发性能问题。
 */
public class Singleton1 {
    private Singleton1(){}

    private static Singleton1 singleton1 = new Singleton1();

    public static Singleton1 getInstance(){
        return singleton1;
    }
}
