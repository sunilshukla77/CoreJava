package com.behavioral.thread.ObserverPattern;

public class Consumer extends Thread implements Observer {

    Message message;

    Consumer(Message message, String name) {
        super(name);
        this.message = message;
    }

    @Override
    public void update(Message m) {
        this.message = m;
        System.out.println(" Recieved Updated News : " + m);
    }


    @Override
    public synchronized void run() {
        //System.out.println(Thread.currentThread().getName());
        //message.consumed();
        /*if(this.message.isConsumed()==true){
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else{
            this.message.setConsumed(true);
        }*/
        System.out.println("Run consumer");
    }
}
