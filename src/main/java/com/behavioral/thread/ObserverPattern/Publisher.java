package com.behavioral.thread.ObserverPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Publisher extends Thread implements Subject {
    List<Observer> observers = new ArrayList<>();
    Message message;

    Publisher(Message message, String name) {
        super(name);
        this.message = message;
    }

    /**
     * @param o
     */
    @Override
    public void attach(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    /**
     * @param o
     */
    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    /**
     * @param m
     */
    @Override
    public void notifyUpdate(Message m) {
        for (Observer o : observers) {
            o.update(m);
        }
    }

    @Override
    public void run() {
        //System.out.println(Thread.currentThread().getName());
        this.message.produced();
        this.notifyUpdate(this.message);
    }

}
