package com.kaka.test.lru;

import sun.misc.resources.Messages_zh_CN;

import javax.validation.constraints.Max;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sundaoping on 2018/2/11.
 */
//采用inheritance方式实现比较简单，而且实现了Map接口，在多线程环境使用时可以使用 Collections.synchronizedMap()方法实现线程安全操作
public class LRUCache1<K, V> extends LinkedHashMap<K, V> {
    private int MAX_CACHE_SIZE;

    /*
    //LinkedHashMap的一个构造函数，当参数accessOrder为true时，即会按照访问顺序排序，最近访问的放在最前，最早访问的放在后面
    public LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor);
        this.accessOrder = accessOrder;
    }

    //LinkedHashMap自带的判断是否删除最老的元素方法，默认返回false，即不删除老数据
    //我们要做的就是重写这个方法，当满足一定条件时删除老数据
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return false;
    }
    */

    public LRUCache1(int cacheSize) {
        //根据cacheSize和加载因子计算hashmap的capactiy，+1确保当达到cacheSize上限时不会触发hashmap的扩容，
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        MAX_CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size() > MAX_CACHE_SIZE;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(Map.Entry<K,V> entry : entrySet()){
            sb.append(String.format("%s:%s  ", entry.getKey(),entry.getValue()));
        }
        return sb.toString();
    }
}
