package com.behavioral.observeremail;

public interface Subject {
    public void register(Observer obs);
    public void unregister(Observer obs);

    public void notifyObserver();
    public Object getUpdate(Observer obs);
}
