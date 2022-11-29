package com.thread.ProdConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProdConsumerTest {

    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(1024);
        final OrderProducer orderProducer = new OrderProducer(queue);
        final OrderConsumer orderConsumer = new OrderConsumer(queue);
        new Thread(orderProducer).start();
        new Thread(orderConsumer).start();
    }
}
