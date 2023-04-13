package com.thread.ProdConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProdConsumerTest {

    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue = new LinkedList<>();
        OrderProducer producer = new OrderProducer(queue, 5, "Producer");
        OrderConsumer consumer4 = new OrderConsumer(queue, 1, "Consumer 4");
        OrderConsumer consumer1 = new OrderConsumer(queue, 1, "Consumer 1");
        OrderConsumer consumer2 = new OrderConsumer(queue, 1, "Consumer 2");
        OrderConsumer consumer3 = new OrderConsumer(queue, 1, "Consumer 3");

        producer.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();

        producer.join();
        consumer1.join();
        consumer2.join();
        consumer3.join();
        consumer4.join();
    }
}
