package com.kaka.test.lru;

/**
 * Created by sundaoping on 2018/2/11.
 */
public class LRUTest {
    public static void main(String[] args) throws Exception {
        System.out.println("start...");

        lruCache1();
        lruCache2();
        lruCache3();
      //  lruCache4();

        System.out.println("over...");
    }
    private static void lruCache1() {
        System.out.println();
        System.out.println("===========================LRU LinkedHashMap(inheritance)实现===========================");
        LRUCache1<Integer, String> lru = new LRUCache1(5);
        lru.put(1, "11");
        lru.put(2, "22");
        lru.put(3, "33");
        lru.put(4, "44");
        lru.put(5, "55");
        System.out.println(lru.toString());
        lru.put(6, "66");
        lru.get(2);
        lru.put(7, "77");
        lru.get(4);
        System.out.println(lru.toString());
        System.out.println();
    }

    private static void lruCache2() {
        System.out.println();
        System.out.println("===========================LRU LinkedHashMap(delegation)实现===========================");
        LRUCache2<Integer, String> lru = new LRUCache2(5);
        lru.put(1, "11");
        lru.put(2, "22");
        lru.put(3, "33");
        lru.put(4, "44");
        lru.put(5, "55");
        System.out.println(lru.toString());
        lru.put(6, "66");
        lru.get(2);
        lru.put(7, "77");
        lru.get(4);
        System.out.println(lru.toString());
        System.out.println();
    }

    private static void lruCache3() {
        System.out.println();
        System.out.println("===========================LRU 双向链表+HashMap实现===========================");
        LRUCache3<Integer, String> lru = new LRUCache3(5);
        lru.put(1, "11");
        lru.put(2, "22");
        lru.put(3, "33");
        lru.put(4, "44");
        lru.put(5, "55");
        System.out.println(lru.toString());
        lru.put(6, "66");
        lru.get(2);
        lru.put(7, "77");
        lru.get(4);
        System.out.println(lru.toString());
        System.out.println();
    }

}
