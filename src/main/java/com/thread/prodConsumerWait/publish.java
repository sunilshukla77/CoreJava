package com.thread.prodConsumerWait;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class publish implements Runnable{
    BlockingQueue bq;
    publish(BlockingQueue bq){
        this.bq = bq;
    }

    /**
     *
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                bq.put(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
