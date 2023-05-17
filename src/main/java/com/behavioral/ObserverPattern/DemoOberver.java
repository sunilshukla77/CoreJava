package com.behavioral.ObserverPattern;

public class DemoOberver {
    public static void main(String[] args) throws InterruptedException {

        Message aajTak = new Message("Aaj Tak updated news");
        Message zeeNews = new Message("Zee updated news");

        NewsPublisher producer = new NewsPublisher();

        SubscribedNews subscriber1 = new SubscribedNews();

        SubscribedNews subscriber2 = new SubscribedNews();


        producer.attach(subscriber1);
        producer.attach(subscriber2);


        producer.notifyUpdate(aajTak);
        producer.detach(subscriber1);
        producer.notifyUpdate(zeeNews);



    }
}
