package com.behavioral.observeremail;

import java.util.List;

public class EmailTopic implements Subject{

    List<Observer> observerList;
    String msg;

    EmailTopic(List<Observer> observerList){
        this.observerList = observerList;
    }
    /**
     * @param observer
     */
    @Override
    public void register(Observer observer) {
        if(observerList == null){
            throw new NullPointerException("Null object/Observer");
        }
        if(!observerList.contains(observer)){
            observerList.add(observer);
        }

    }

    /**
     * @param observer
     */
    @Override
    public void unregister(Observer observer) {
        observerList.remove(observer);
    }

    /**
     *
     */
    @Override
    public void notifyObserver() {
        for (Observer observer: observerList) {
            //observer.update();
        }
    }

    /**
     * @param observer
     * @return
     */
    @Override
    public Object getUpdate(Observer observer) {
        return this.msg;
    }

    public void postMessage(String msg){
        System.out.println("Message posted to my topic:" +msg);
        this.msg = msg;
        notifyObserver();
    }
}
