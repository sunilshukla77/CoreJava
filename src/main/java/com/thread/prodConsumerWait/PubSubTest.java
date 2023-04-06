package com.thread.prodConsumerWait;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PubSubTest {
    public static void main(String[] args) {
        BlockingQueue bq =new ArrayBlockingQueue(2);
        ExecutorService tp = Executors.newFixedThreadPool(2);
        tp.execute(new publish(bq));
        tp.execute(new Subscribe(bq));

    }
}
