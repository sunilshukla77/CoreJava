package com.cache;

//Java Program to Illustrate ReentrantReadWriteLock Class

//Importing ReentrantReadWriteLock
//fro java.util package
import java.util.concurrent.locks.ReentrantReadWriteLock;

//Class 1
//Main class
public class ReentrantReadWriteLockExample {

	private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

	// Initially the string contains only 1 character
	private static String message = "a";

	// Main driver method
	public static void main(String[] args)
		throws InterruptedException
	{

		// Creating threads
		Thread t1 = new Thread(new Read());
		Thread t2 = new Thread(new WriteA());
		Thread t3 = new Thread(new WriteB());

		// Starting threads with help of start() method
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
	}

	// Class 2
	// Helper class implementing Runnable interface
	static class Read implements Runnable {

		// run() method for thread
		public void run()
		{

			for (int i = 0; i <= 10; i++) {
				if (lock.isWriteLocked()) {
					System.out.println(
						"I'll take the Lock from Write");
				}

				// operating lock()
				lock.readLock().lock();

				System.out.println(
					"ReadThread "
					+ Thread.currentThread().getId()
					+ " Message is " + message);
				lock.readLock().unlock();
			}
		}
	}

	// Class 3
	// Helper class implementing Runnable interface
	static class WriteA implements Runnable {

		// run() method for thread
		public void run()
		{

			for (int i = 0; i <= 10; i++) {

				// Try block to check fr exceptions
				try {
					lock.writeLock().lock();
					message = message.concat("WA");
				}
				finally {
					lock.writeLock().unlock();
				}
			}
		}
	}

	// Class 4
	// Helper class implementing Runnable interface
	static class WriteB implements Runnable {

		// run() method for thread
		public void run()
		{

			for (int i = 0; i <= 10; i++) {

				// Try block to check for exceptions
				try {
					lock.writeLock().lock();
					message = message.concat("Wb");
				}
				finally {
					lock.writeLock().unlock();
				}
			}
		}
	}
}
