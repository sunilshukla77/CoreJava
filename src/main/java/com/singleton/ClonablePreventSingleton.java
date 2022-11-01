package com.singleton;

//Java code to explain cloning 
//issue with singleton
class SuperClass implements Cloneable {
	int i = 10;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}

//Singleton class
class Singleton extends SuperClass {
// public instance initialized when loading the class
	public static Singleton instance = new Singleton();

	private Singleton() {
		// private constructor
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return instance;
	}
}

public class ClonablePreventSingleton {
	public static void main(String[] args) throws CloneNotSupportedException {
		Singleton instance1 = Singleton.instance;
		Singleton instance2 = (Singleton) instance1.clone();
		System.out.println("instance1 hashCode:- " + instance1.hashCode());
		System.out.println("instance2 hashCode:- " + instance2.hashCode());
	}
}

//Overcome Cloning issue:- To overcome this issue, override clone() method and throw an exception from clone method that 
//is CloneNotSupportedException. Now whenever user will try to create clone of singleton object, it will throw exception and hence
//our class remains singleton.