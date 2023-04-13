package com.behavioral.ObserverPattern;

public interface Subject
{
    public void attach(Observer o);// Subscribe
    public void detach(Observer o);// Unsubscribe
    public void notifyUpdate(Message m);
}
