package com.singleton;

import com.core.dto.Employee;

/**
 * @author sunil
 * Singleton pattern in Java for caching, logging, thread pooling, 
 * configuration settings, and much more.
 *
 */
public class SingletonLazy {
	
	private static SingletonLazy lazyInstance = null;
	
	String s;
	private SingletonLazy() {
		// Private constructor
		s= "Hello I am a string part of Singleton class";
	}
	
	public static SingletonLazy getInstance() {
		if(lazyInstance== null) {
			lazyInstance = new SingletonLazy();
		}
		return lazyInstance;
	}
	
	public static void main(String args[]){
			SingletonLazy i1= SingletonLazy.getInstance();
			SingletonLazy i2= SingletonLazy.getInstance();
			SingletonLazy i3= SingletonLazy.getInstance();
			
			System.out.println("****Singleton*****");
			System.out.println(i1.hashCode());
			System.out.println(i2.hashCode());
			System.out.println(i3.hashCode());
			
			
			Employee emp1 = new Employee();
			Employee emp2 = new Employee();
			Employee emp3 = new Employee();
			System.out.println("****Prototype*****");
			
			System.out.println("Emp : " + emp1.hashCode());
			System.out.println("Emp : " + emp2.hashCode());
			System.out.println("Emp : " + emp3.hashCode());
	}
	

}
