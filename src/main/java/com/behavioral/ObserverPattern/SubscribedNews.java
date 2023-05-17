package com.behavioral.ObserverPattern;

import java.util.Queue;

public class SubscribedNews implements Observer{

    Queue<Message> queue;

    /**
     * @param m
     */
    @Override
    public void update(Message m) {

        System.out.println(" Updated News : " + m);
    }

}
