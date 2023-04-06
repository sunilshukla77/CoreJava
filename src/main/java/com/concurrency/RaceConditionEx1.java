package com.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
/*
 * A condition in which the critical section
 * (a part of the program where shared memory is accessed) is concurrently executed by two or more threads.
 * It leads to incorrect behavior of a program.
 */
class Counter {
	//`	private volatile int count = 0;
	private AtomicInteger atomicCount = new AtomicInteger(0);
	
	/*
	 * This method is not thread-safe because ++ is not an atomic operation
	 */
	/*public int getCount() {
		System.out.println("******");
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return count++;
	}*/
	
	/**
	 * This method is thread-safe now because of locking and synchronization
	 */
	/*public synchronized int getCount() {
		System.out.println("******");
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return count++;
	}*/
	
	/*
     * This method is thread-safe because count is incremented atomically
     */
    public int getCount(){
        return atomicCount.incrementAndGet();
    }
}

public class RaceConditionEx1 {
	public static void main(String[] args) {
		final Counter c = new Counter();
		ExecutorService threadPool = Executors.newFixedThreadPool(2);

		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println(c.getCount());
			}
		});

		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println(c.getCount());
			}
		});
		
		threadPool.shutdown();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End:"+c.getCount());
	}
}
