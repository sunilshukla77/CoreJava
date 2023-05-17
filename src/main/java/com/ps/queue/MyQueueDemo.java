package com.ps.queue;

public class MyQueueDemo {
    public static void main(String[] args) {
        MyQueue<String>  queue= new MyQueue<>();

        queue.insert("Sunil");
        queue.insert("Sachin");
        queue.insert("Kapil");
        queue.insert("Alok");

        queue.printQueue();
        queue.delete();
        queue.delete();
        queue.delete();
        System.out.println("*** After Delete ***");

        queue.printQueue();


    }
}
