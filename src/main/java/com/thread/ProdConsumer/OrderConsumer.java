package com.thread.ProdConsumer;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class OrderConsumer extends Thread {
    Queue queue;
    int size;

    public OrderConsumer(Queue queue, int size, String name) {
        super(name);
        this.queue = queue;
        this.size = size;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    System.out.println("Queue is empty,"
                            + "Consumer thread is waiting"
                            + " for producer thread to put something in queue");
                    try {
                        queue.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
                System.out.println("Consuming value : " + queue.remove());
                queue.notifyAll();
            }
        }
    }
}
