package com.creational.factory;

public class CarFactory {

	public static Car getCar(String type) {
		Car car= null;
		if("audi".equals(type)) {
			car =  new Audi();
		}else if("Tata".equals(type)) {
			car =  new Tata();
		}
		return car;
	}
}

/*
 * Some important points about Factory Design Pattern method are;

1. We can keep Factory class Singleton or we can keep the method that returns the subclass as static.
2. Notice that based on the input parameter, different subclass is created and returned. 
    getComputer is the factory method.

*/