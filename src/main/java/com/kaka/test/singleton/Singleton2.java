package com.kaka.test.singleton;

/**
 * Created by sundaoping on 2018/1/18.
 * 双重检查锁单例:
 * 优点:
 * 1. 延迟加载，它的实例在第一次使用时才会创建
 * 2. 线程安全，使用synchronized来解决线程同步的问题
 * 3. 性能提升，如果只有一次检查的话，相当于为了解决1%几率的同步问题，而使用了一个100%出现的防护盾。双重检查就是把100%出现的防护盾，也改为1%的几率出现。只有instance为null的时候，才进入synchronized的代码段——大大减少了几率。
 * 4. volatile关键字:
 *      4.1 内存可见性：可见性的意思是当一个线程修改一个共享变量时，另外一个线程能读到这个修改的值。
 *      4.2 禁止指令重排：双重检查锁单例中利用的就是这一点。
 *
 */
public class Singleton2 {
    private static volatile Singleton2 instance;

    private Singleton2(){}

    public static Singleton2 getInstance(){
        if(instance == null){
            synchronized (Singleton2.class){
                if(instance == null){
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}

/**
 * 那什么是指令重排呢？指令重排是指计算机为了提高执行效率，会做一些优化，在不影响最终结果的情况下，可能会对一些语句的执行顺序进行调整。
 以下是引用程序员之家公众号里关于指令重排导致程序出错的例子，写得非常清楚：
 主要是在 instance = new Singleton() 这句，这并非是一个原子操作，事实上在 JVM 中这句话大概做了下面 3 件事情。

 1. 给 instance 分配内存
 2. 调用 Singleton 的构造函数来初始化成员变量，形成实例
 3. 将instance对象指向分配的内存空间（执行完这步 instance才是非 null ）

 但是在 JVM 的即时编译器中存在指令重排序的优化。也就是说上面的第二步和第三步的顺序是不能保证的，最终的执行顺序可能是 1-2-3 也可能是 1-3-2。如果是后者，则在 3 执行完毕、2 未执行之前，
 被线程二抢占了，这时 instance 已经是非 null 了（但却没有初始化），所以线程二会直接返回 instance，然后使用，然后顺理成章地报错。
 再稍微解释一下，就是说，由于有一个『instance已经不为null但是仍没有完成初始化』的中间状态，而这个时候，如果有其他线程刚好运行到第一层if (instance == null)这里，这里读取到的instance已经不为null了，
 所以就直接把这个中间状态的instance拿去用了，就会产生问题。

 这里的关键在于——线程T1对instance的写操作没有完成，线程T2就执行了读操作。
 把instance声明为volatile之后，对它的写操作就会有一个内存屏障，这样在它的赋值完成之前，就不用调用读操作。
 注意：volatile阻止的不instance = new Singleton()这句话内部[1-2-3]的指令重排，而是保证了在一个写操作（[1-2-3]）完成之前，不会调用读操作（if (instance == null)）。
 */

