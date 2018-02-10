package com.kaka.test.singleton;

/**
 * Created by sundaoping on 2018/1/18.
 * 枚举单例:使用枚举除了线程安全和防止反射强行调用构造方法外，还提供了自动序列化机制，防止反序列化的时候创建新的对象。因此，Effective Java推荐尽可能地使用单元素枚举来实现单例。
 */
public enum Singleton4 { //编译后:public abstract class Singleton extends Enum
    INSTANCE;

    public void fun1(){
        // do something
        System.out.println("singleton4 enum");
    }
}
