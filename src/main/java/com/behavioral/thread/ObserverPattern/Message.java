package com.behavioral.thread.ObserverPattern;

public final class Message {
    private final String messageContent;

    private boolean consumed = false;

    int count =0;

    public Message(String m) {
        this.messageContent = m;
    }

    //Defensive copy class provide it this.department.clone();


    public String getMessageContent() {
        return messageContent;
    }

    public boolean isConsumed() {
        return consumed;
    }

    public void setConsumed(boolean consumed) {
        this.consumed = consumed;
    }

    void produced() {
        synchronized (this) {
            if (this.getMessageContent().isEmpty() && this.isConsumed()) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Producer " + this.messageContent);
                this.setConsumed(false);
            }
        }
    }


    /*void consumed() {
        synchronized (this) {
            if (this.getMessageContent().isEmpty()) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                this.setConsumed(false);
                System.out.println(" Consumer " + this.messageContent);
                this.notify();
            }
        }
    }*/


    void print() throws InterruptedException {
        while(count< 25){
            synchronized (this){
                while (count%5 != 0){
                    this.wait();
                }
                System.out.println(count);
                count++;
                this.notifyAll();

            }
        }
    }

    void print1() throws InterruptedException {
        while(count< 25){
            synchronized (this){
                while (count%5 != 1){
                    this.wait();
                }
                System.out.println(count);
                count++;
                this.notifyAll();

            }
        }
    }

    void print2() throws InterruptedException {
        while(count< 25){
            synchronized (this){
                while (count%5 != 2){
                    this.wait();
                }
                System.out.println(count);
                count++;
                this.notifyAll();

            }
        }
    }

    void print3() throws InterruptedException {
        while(count< 25){
            synchronized (this){
                while (count%5 != 3){
                    this.wait();
                }
                System.out.println(count);
                count++;
                this.notifyAll();

            }
        }
    }

    void print4() throws InterruptedException {
        while(count< 25){
            synchronized (this){
                while (count%5 != 4){
                    this.wait();
                }
                System.out.println(count);
                count++;
                this.notifyAll();

            }
        }
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageContent='" + messageContent + '\'' +
                '}';
    }
}
