package com.kaka.test.delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by sundaoping on 2018/1/3.
 */
public class Wangming implements Delayed{

    //姓名
    private String name;
    //身份证
    private String id;
    //截止时间
    private long endTime;

    /**
     *
     * @param name
     * @param id
     * @param endTime
     */
    public Wangming(String name, String id, long endTime){
        this.name = name;
        this.id = id;
        this.endTime = endTime;
    }

    public String getName(){
        return this.name;
    }
    public String getId(){
        return this.id;
    }
    public long getEndTime(){
        return this.endTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return this.endTime - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        Wangming wm = (Wangming)o;
        return this.endTime - wm.getEndTime() > 0 ? 1 : 0;
    }
}
