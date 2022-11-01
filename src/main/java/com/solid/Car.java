package com.solid;

public abstract class Car {
	
	String name;
	int power;
	String type;
	
	public abstract String Company(String name, int power, String type);

	@Override
	public String toString() {
		return "Car [name=" + name + ", power=" + power + ", type=" + type + "]";
	}
	
}
