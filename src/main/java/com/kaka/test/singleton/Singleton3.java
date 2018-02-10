package com.kaka.test.singleton;

/**
 * Created by sundaoping on 2018/1/18
 * 静态内部单例:由于InnerClass是一个内部类，只在外部类的Singleton的getInstance()中被使用，所以它被加载的时机也就是在getInstance()方法第一次被调用的时候。并且InnerClass初始化的时候会由ClassLoader来保证同步。
 *
 * 精妙:既利用了ClassLoader保证同步，又实现了延迟加载，简直神乎其技
 */
public class Singleton3 {
    private Singleton3(){};

    private static class InnerClass{
        private static final Singleton3 instance = new Singleton3();
    }

    public static Singleton3 getInstance(){
        return InnerClass.instance;
    }
}
