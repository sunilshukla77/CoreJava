package com.thread.evenodd;

public class EvenOdd {

    int  counter;
    static int number= 10;


    void printEven(Object o1){

        synchronized(o1){

            while(counter<number) {
                while (counter % 2 != 0) {  // agar even nahi hai means odd hai to go to wait
                    try {
                        o1.wait(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Even Counter "+counter);
                counter++;
                o1.notifyAll();
            }
        }
    }

    void printOdd(Object o1){
        synchronized (o1) {
            while (counter < number) {
                while (counter % 2 != 1){   // agar odd nahi hai  even nahi hai to go to wait
                    try {
                        o1.wait(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                System.out.println("Print Odd "+ counter);
                counter++;
                o1.notify();
            }
        }
    }
}
