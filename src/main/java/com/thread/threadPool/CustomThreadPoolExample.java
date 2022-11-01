package com.thread.threadPool;

public class CustomThreadPoolExample {
	 public static void main(String[] args) 
	    {
	        CustomThreadPool customThreadPool = new CustomThreadPool(2);
	         
	        for (int i = 1; i <= 5; i++) 
	        {
	            Task task = new Task("Task " + i);
	            System.out.println("Created : " + task.getName());
	 
	            customThreadPool.execute(task);
	        }
	    }
}

// Refer: https://howtodoinjava.com/java/multi-threading/java-thread-pool-executor-example/
// Fork join : https://www.baeldung.com/thread-pool-java-and-guava