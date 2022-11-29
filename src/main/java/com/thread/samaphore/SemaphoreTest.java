package com.thread.samaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        EvenOddSemaphore evenOddSemaphore= new EvenOddSemaphore();
        int value= 10;

        Thread oddThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < value; i=i+2) {
                    evenOddSemaphore.oddPrint(i);
                }

            }
        });

        Thread evenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 2; i < value; i=i+2) {
                    evenOddSemaphore.evenPrint(i);
                }

            }
        });

        oddThread.start();
        evenThread.start();
    }
}
