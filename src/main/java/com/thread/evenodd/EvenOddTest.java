package com.thread.evenodd;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenOddTest {

    public static void main(String[] args) throws InterruptedException {

        EvenOdd.number=10;
        final EvenOdd evenOdd = new EvenOdd();
        /*Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                evenOdd.printOdd();

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                evenOdd.printEven();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();*/

        ExecutorService tp = Executors.newFixedThreadPool(2);
        Object o1 = new Object();
        tp.execute(()-> evenOdd.printEven(o1));
        tp.execute(()->evenOdd.printOdd(o1));
    }
}
