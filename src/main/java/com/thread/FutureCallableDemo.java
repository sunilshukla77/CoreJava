package com.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCallableDemo {

	public static void main(String[] args) {

		MyCallable[] callables = { new MyCallable(10), new MyCallable(20), new MyCallable(40), new MyCallable(50) };
		ExecutorService service = Executors.newFixedThreadPool(3);

		for (MyCallable myCallable : callables) {
			Future<Integer> future = service.submit(myCallable);
			try {
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		service.shutdown();
	}

}
