package com.kaka.test.singleton;

/**
 * Created by sundaoping on 2018/1/18.
 */
public class singletest {
    public static void main(String args[]){

        //枚举单例
        new Thread(new Runnable() {

            @Override
            public void run() {
                Singleton4 singleton = Singleton4.INSTANCE;
                System.out.println("thread create instance:" + singleton.hashCode());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton4 singleton = Singleton4.INSTANCE;
                System.out.println("thread create instance:" + singleton.hashCode());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton4 singleton = Singleton4.INSTANCE;
                System.out.println("thread create instance:" + singleton.hashCode());
                singleton.fun1();
            }
        }).start();

        //静态内部类实现
        /**
        new Thread(new Runnable() {

            @Override
            public void run() {
                Singleton3 singleton = Singleton3.getInstance();
                System.out.println("thread create instance:" + singleton.hashCode());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton3 singleton = Singleton3.getInstance();
                System.out.println("thread create instance:" + singleton.hashCode());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton3 singleton = Singleton3.getInstance();
                System.out.println("thread create instance:" + singleton.hashCode());
            }
        }).start();
         */

        //双重检查锁单例
        /*
        new Thread(new Runnable() {

            @Override
            public void run() {
                Singleton2 singleton2 = Singleton2.getInstance();
                System.out.println("thread create instance:" + singleton2.hashCode());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton2 singleton2 = Singleton2.getInstance();
                System.out.println("thread create instance:" + singleton2.hashCode());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton2 singleton2 = Singleton2.getInstance();
                System.out.println("thread create instance:" + singleton2.hashCode());
            }
        }).start();
        */



        /*
         * 饿汉式单例中instance的初始化是在类加载时进行的，而类的加载是由ClassLoader来完成，这个过程由JVM来保证同步，
         * 所以这种方式天生是线程安全的。它的缺点也显而易见：容易造成资源的浪费，并且如果构造方法中处理过多，还有可能引发性能问题。
         */
        /**
        new Thread(new Runnable() {

            @Override
            public void run() {
                Singleton1 singleton1 = Singleton1.getInstance();
                System.out.println("thread create instance:" + singleton1.hashCode());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton1 singleton1 = Singleton1.getInstance();
                System.out.println("thread create instance:" + singleton1.hashCode());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton1 singleton1 = Singleton1.getInstance();
                System.out.println("thread create instance:" + singleton1.hashCode());
            }
        }).start();
         */

    }
}
