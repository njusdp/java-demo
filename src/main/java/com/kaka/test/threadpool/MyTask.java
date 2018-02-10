package com.kaka.test.threadpool;

/**
 * Created by sundaoping on 2018/1/3.
 */
public class MyTask implements Runnable {

    private int threadNum;

    public MyTask(int num){
        this.threadNum = num;
    }

    @Override



    public void run() {
        System.out.println(this.threadNum + " is running...");
        try{
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.threadNum + " finished");
    }
}
