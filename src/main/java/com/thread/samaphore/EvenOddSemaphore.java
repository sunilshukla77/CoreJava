package com.thread.samaphore;

import java.util.concurrent.Semaphore;
/*
 Semaphore:
 */
public class EvenOddSemaphore {

    Semaphore oddSemaphore = new Semaphore(1);
    Semaphore evenSemaphore = new Semaphore(0);

    public void oddPrint(int number){
        try {
            oddSemaphore.acquire();
            System.out.println(Thread.currentThread().getName() +" "+ number);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally{
            evenSemaphore.release();
        }
    }

    public void evenPrint(int number){
        try {
            evenSemaphore.acquire();
            System.out.println(Thread.currentThread().getName() +" "+ number);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally{
            oddSemaphore.release();
        }
    }
}
