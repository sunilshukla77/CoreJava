package com.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
	int num;
	MyCallable(int val){
		this.num = val;
	}
	@Override
	public Integer call() throws Exception {
		System.out.println(Thread.currentThread().getName() + " is calculating sum of all the number " + num);
		int sum = 0;
		for (int i = 0; i < num; i++) {
			sum+=i;
		}
		return sum;
	}

}
