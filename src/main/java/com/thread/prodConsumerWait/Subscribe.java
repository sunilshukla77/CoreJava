package com.thread.prodConsumerWait;

import java.util.concurrent.BlockingQueue;

public class Subscribe implements Runnable{
    BlockingQueue bq;
    Subscribe(BlockingQueue bq){
        this.bq= bq;
    }


    /**
     *
     */
    @Override
    public void run() {
        while (true){
            synchronized (this){
                try {
                    System.out.println(bq.take());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
