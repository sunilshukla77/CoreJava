package com.thread.ProdConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProdConsumerTest {

    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(1024);
        final OrderProducer orderProducer = new OrderProducer(queue);
        final OrderConsumer orderConsumer = new OrderConsumer(queue);
        final OrderConsumer orderConsumer1 = new OrderConsumer(queue);

        ExecutorService tp = Executors.newFixedThreadPool(3);
        tp.execute(orderProducer);
        tp.execute(orderConsumer);
        tp.execute(orderConsumer1);
        //new Thread(orderProducer).start();
        //new Thread(orderConsumer).start();
    }
}
