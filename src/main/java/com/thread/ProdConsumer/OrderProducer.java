package com.thread.ProdConsumer;

import java.util.concurrent.BlockingQueue;

public class OrderProducer implements Runnable{

    private BlockingQueue<String> queue;

    public OrderProducer(BlockingQueue<String> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            queue.put("Mac Book pro");
            queue.put("Dell Laptop");
            queue.put("Iphone");
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
