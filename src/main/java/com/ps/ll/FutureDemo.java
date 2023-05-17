package com.ps.ll;

import java.util.List;
import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo cd = new CallableDemo();
        ExecutorService tp = Executors.newFixedThreadPool(2);
        Future future = tp.submit(cd);
        System.out.println(future.get());
    }
}
