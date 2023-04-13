package com.thread.ProdConsumer;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class OrderProducer extends Thread {
    Queue<Integer> queue;
    int maxSize;
    String name;

    int count = 0;

    public OrderProducer(Queue<Integer> queue, int size, String name) {
        super(name);
        this.queue = queue;
        this.maxSize = size;
    }

    @Override
    public void run() {
        while (count < 10) {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        System.out.println("Queue is full, " + "Producer thread waiting for " + "consumer to take something from queue");
                        queue.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

                //Random random = new Random();
                //int i = random.nextInt();
                //for (int i = 0; i < 10; i++) {
                System.out.println("Producing value : " + count);
                queue.add(count);
                count++;
                //}
                queue.notify();
            }
        }
    }
}
