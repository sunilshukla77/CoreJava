package com.behavioral.ObserverPattern;

public class DemoOberver {
    public static void main(String[] args) throws InterruptedException {

        Message aajTak = new Message("Aaj Tak updated news");
        Message zeeNews = new Message("Zee updated news");

        MessagePublisher producer = new MessagePublisher();

        MessageSubscriber subscriber1 = new MessageSubscriber();

        MessageSubscriber subscriber2 = new MessageSubscriber();


        producer.attach(subscriber1);
        producer.attach(subscriber2);


        producer.notifyUpdate(aajTak);
        producer.detach(subscriber1);
        producer.notifyUpdate(zeeNews);



    }
}
