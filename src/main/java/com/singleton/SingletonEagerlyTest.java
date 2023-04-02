package com.singleton;

import java.io.Serializable;

//https://www.geeksforgeeks.org/prevent-singleton-pattern-reflection-serialization-cloning/
//Eager Initialization
class SingletonEagerly implements Serializable{

	// public instance initialized when loading the class
	private static final SingletonEagerly instance = new SingletonEagerly();

	private SingletonEagerly() {
		// private constructor
	}

	public static SingletonEagerly getInstance() {
		return instance;
	}
	
	
    //Overcome reflection issue: To overcome issue raised by reflection, 
    //enums are used because java ensures internally that enum value is instantiated only once.
	// Since java Enums are globally accessible, they can be used for singletons.
	// Its only drawback is that it is not flexible i.e it does not allow lazy initialization.
    public enum Singleton 
    {
      INSTANCE;
    }
	/*
	 * Pros: 1.Very simple to implement. 
	 * 2. May lead to resource wastage. Because instance of class is created always,
	 *  whether it is required or not.
	 * 3.CPU time is also wasted in creation of instance if it is not required. 
	 * 4.Exception handling is not possible.
	 */

}

public class SingletonEagerlyTest{
	
	public static void main(String[] args) {
		SingletonEagerly inst = SingletonEagerly.getInstance();
		SingletonEagerly inst2 = SingletonEagerly.getInstance();
		
		System.out.println(inst.hashCode());
		System.out.println(inst2.hashCode());
		
	}
	
}

