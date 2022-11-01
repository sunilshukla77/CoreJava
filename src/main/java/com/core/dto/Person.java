package com.core.dto;

public final class Person {
	
	private final String  name;
	private final int  age;
	private final Address ad;
	
	
	public Person(String name, int age, Address ad) {
		super();
		this.name = name;
		this.age = age;
		this.ad = ad;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public Address getAd() throws CloneNotSupportedException {
		return (Address) ad.clone();
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", ad=" + ad + "]";
	}

}
