package com.thread.evenodd;

public class EvenOdd {

    int counter;
    static int number;

    void printEven(){

        synchronized(this){

            while(counter<number) {
                while (counter % 2 == 0) {
                    try {
                        wait(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Even Counter "+counter);
                counter++;
                notifyAll();
            }
        }
    }

    void printOdd(){
        synchronized (this) {
            while (counter < number) {
                while (counter % 2 == 1){
                    try {
                        wait(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                System.out.println("Print Odd "+ counter);
                counter++;
                notifyAll();
            }
        }
    }
}
