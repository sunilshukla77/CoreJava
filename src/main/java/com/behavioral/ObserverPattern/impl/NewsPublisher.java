package com.behavioral.ObserverPattern.impl;

import com.behavioral.ObserverPattern.Message;
import com.behavioral.ObserverPattern.Observer;
import com.behavioral.ObserverPattern.Subject;

import java.util.ArrayList;
import java.util.List;

public class NewsPublisher implements Subject {

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