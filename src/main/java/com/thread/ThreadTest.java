package com.thread;

public class ThreadTest implements Runnable{
    /**
     *
     */
    @Override
    public void run() {
        System.out.println("Running");

    }

    public static void main(String[] args) {
        ThreadTest tt = new ThreadTest();
        tt.run();
        tt.run();
        //tt.start();

    }
}
