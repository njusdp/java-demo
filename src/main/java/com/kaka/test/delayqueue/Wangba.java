package com.kaka.test.delayqueue;

import java.util.concurrent.DelayQueue;

/**
 * Created by sundaoping on 2018/1/3.
 */
public class Wangba implements Runnable{

    //delayQueue
    private DelayQueue<Wangming> delayQueue = new DelayQueue<Wangming>();

    //1块钱1分钟
    public void shangji(String name, String id, int money){
        Wangming wm = new Wangming(name,id, money * 60 * 1000 + System.currentTimeMillis());


        System.out.println("用户:" + name + ",id:" + id + ",money:" + money + " 上机");

        this.delayQueue.add(wm);
    }

    public void xiaji(Wangming wm){
        System.out.println("用户:" + wm.getName() + ",id:" + wm.getId() + " 下机");
    }


    @Override
    public void run() {
        while(true){
            try{
                System.out.println("检查中");
                Wangming wm = this.delayQueue.take();
                this.xiaji(wm);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String args[]){
        System.out.println("网吧开始营业");

        try{
            Wangba wb = new Wangba();
            Thread thread = new Thread(wb);
            thread.start();

            wb.shangji("sdp","1234",1);
            wb.shangji("hw","1235",2);
            wb.shangji("sdphw","1236",1);
        }catch (Exception e){

        }

    }
}
