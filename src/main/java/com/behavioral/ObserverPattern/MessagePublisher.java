package com.behavioral.ObserverPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MessagePublisher implements Subject{

    List<Observer> observers = new ArrayList<>();

    /**
     * @param o
     */
    @Override
    public void attach(Observer o) {
        if(!observers.contains(o)) {
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
        for (Observer o: observers) {
            o.update(m);
        }
    }

}
