package com.thread.evenodd;

public class EvenOdd {

    int counter;
    static int number;

    void printEven(){

        synchronized(this){

            while(counter<number) {
                while (number % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Counter "+counter);
                counter++;
                notifyAll();
            }
        }
    }

    void printOdd(){
        synchronized (this) {
            while (counter < number) {
                while (number % 2 == 1){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                System.out.println("EvenOdd.printOdd "+ counter);
                counter++;
                notifyAll();
            }
        }
    }
}
