package com.behavioral.ObserverPattern;

import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class MessageSubscriber implements Observer{

    Queue<Message> queue;

    /**
     * @param m
     */
    @Override
    public void update(Message m) {
        System.out.println(" Updated News : " + m);
    }

}
