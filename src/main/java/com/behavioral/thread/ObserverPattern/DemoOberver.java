package com.behavioral.thread.ObserverPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//Implement a producer thread, having responsibility of pushing messages to the Queue at an interval of X messages/second.
//There are 4 subscriber threads to this queue, these will recieve message once its availbale in queue.
//Pring out recieved message with Thread number as it's been recieved by Thread.

public class DemoOberver {
    public static void main(String[] args) throws InterruptedException {

        Message aajTak = new Message("Aaj Tak updated news");
        Message zeeNews = new Message("Zee updated news");

        List<Message> messageList = new ArrayList<>();
        messageList.add(aajTak);
        messageList.add(zeeNews);

        Publisher producer = null;
        Consumer subscriber1 = null;
        Consumer subscriber2 = null;
        Consumer subscriber3 = null;

        //All the message send by Publisher

        for (int i = 0; i < messageList.size(); i++) {

            producer = new Publisher(messageList.get(i),"Publisher");
            subscriber1 = new Consumer(messageList.get(i), "Consumer 1");
            subscriber2 = new Consumer(messageList.get(i), "Consumer 2");
            subscriber3 = new Consumer(messageList.get(i), "Consumer 3 ");

            ExecutorService tp = Executors.newFixedThreadPool(4);
            tp.execute(producer);
            tp.execute(subscriber1);
            tp.execute(subscriber2);
            tp.execute(subscriber3);
            tp.shutdown();
        }

        producer.attach(subscriber1);
        producer.attach(subscriber2);
        producer.attach(subscriber3);


        ExecutorService tp = Executors.newFixedThreadPool(5);

        tp.execute(()-> {
            try {
                aajTak.print();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        tp.execute(()-> {
            try {
                aajTak.print1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        tp.execute(()->{
            try {
                aajTak.print2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        tp.execute(()-> {
            try {
                aajTak.print3();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        tp.execute(()-> {
            try {
                aajTak.print4();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        //tp.shutdown();


    }
}
