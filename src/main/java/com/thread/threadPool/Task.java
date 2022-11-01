package com.thread.threadPool;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    private String name;
 
    public Task(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
 
    @SuppressWarnings("deprecation")
	public void run() {
        try {
            Long duration = (long) (Math.random() * 10);
            System.out.println("Executing : " + name);
            TimeUnit.SECONDS.sleep(duration);
            
            System.out.println("Executing : " + name + ", Current Seconds : " + new Date().getSeconds());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}